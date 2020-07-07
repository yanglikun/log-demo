package com.github.yanglikun.common.logger;

import com.github.yanglikun.common.PropertiesChangeMonitor;

/**
 * @author yanglikun
 */
public class LogLevelChangeMonitor {

    private static boolean log4j2Exist = false;
    private static boolean log4jExist = false;
    private static boolean logbackExist = false;

    static {
        log4jExist = isAllClassExist("org.apache.log4j.Logger", "org.apache.log4j.Level", "org.apache.log4j.LogManager");
        log4j2Exist = isAllClassExist("org.apache.logging.log4j.Logger", "org.apache.logging.log4j.Level", "org.apache.logging.log4j.core.config.Configurator");
        logbackExist = isAllClassExist("ch.qos.logback.classic.Logger", "ch.qos.logback.classic.Level", "org.slf4j.LoggerFactory", "ch.qos.logback.classic.LoggerContext");
        if (log4jExist) {
            System.out.println("监测到log4j1.x存在");
        }
        if (log4j2Exist) {
            System.out.println("监测到log4j2.x存在");
        }
        if (logbackExist) {
            System.out.println("监测到logback存在");
        }
    }

    public static void startMonitor(String classPathFile) {
        PropertiesChangeMonitor.monitor(classPathFile, LogLevelChangeMonitor::change);
    }

    private static void change(String loggerName, String levelName) {
        try {
            if (log4jExist) {
                System.out.println("log4j change loggerName:[" + loggerName + "],levelName:[" + levelName + "]");
                LogLevelChangeLog4j.change(loggerName, levelName);
            }
            if (log4j2Exist) {
                System.out.println("log4j2 change loggerName:[" + loggerName + "],levelName:[" + levelName + "]");
                LogLevelChangeLog4j2.change(loggerName, levelName);
            }
            if (logbackExist) {
                System.out.println("logbak change loggerName:[" + loggerName + "],levelName:[" + levelName + "]");
                LogChangeLogback.change(loggerName, levelName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isAllClassExist(String... className) {
        if (className == null || className.length < 1) {
            return false;
        }
        try {
            for (String s : className) {
                Class.forName(s);
            }
            return true;
        } catch (Exception e) {
            //忽略异常
        }
        return false;
    }

}
