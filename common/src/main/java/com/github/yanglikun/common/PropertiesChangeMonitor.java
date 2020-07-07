package com.github.yanglikun.common;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yanglikun
 */
public class PropertiesChangeMonitor {

    private PropertiesChangeMonitor() {
    }

    public static void monitor(String classPathFile, ChangeCallback changeCallback) {
        new Thread(new Monitor(changeCallback)).start();
    }

    public static interface ChangeCallback {
        void handle(String key, String value);
    }

    private static class Monitor implements Runnable {

        private long lastModified;

        private ChangeCallback changeCallback;

        public Monitor(ChangeCallback changeCallback) {
            this.changeCallback = changeCallback;
        }

        @Override
        public void run() {
            for (; ; ) {
                try {
                    //加载配置文件
                    URL resource = PropertiesChangeMonitor.class.getClassLoader().getResource("loglevel.properties");
                    if (resource == null) {
                        continue;
                    }
                    File logLevelFile = new File(resource.getPath());
                    if (!logLevelFile.exists()) {
                        continue;
                    }
                    if (lastModified <= 0) {
                        lastModified = logLevelFile.lastModified();
                    } else {
                        if (lastModified == logLevelFile.lastModified()) {//文件没有变化
                            continue;
                        } else {
                            lastModified = logLevelFile.lastModified();//文件变化，赋值为新的
                        }
                    }
                    lastModified = logLevelFile.lastModified();
                    //如果不sleep，下面读到会是空内容，不知道为什么，经过测试用vi不会出现这个问题，vscode和idea会出现。估计和编辑器刷盘有关
                    TimeUnit.SECONDS.sleep(1);
                    List<String> levelConfs = FileUtils.readLines(logLevelFile, "utf-8");
                    for (int i = 0; i < levelConfs.size(); i++) {
                        String line = levelConfs.get(i);
                        if (StringUtils.isEmpty(line)) {
                            continue;
                        }
                        String[] split = line.split("=");
                        if (split.length >= 2) {
                            changeCallback.handle(split[0], split[1]);
                        } else {
                            changeCallback.handle(split[0], null);
                        }
                    }
                    System.out.println("log配置变化，加载成功");
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
