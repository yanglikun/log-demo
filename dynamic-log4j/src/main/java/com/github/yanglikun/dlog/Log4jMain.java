package com.github.yanglikun.dlog;

import com.github.yanglikun.common.logger.LogLevelChangeMonitor;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Log4jMain {

    static Logger logger1 = Logger.getLogger("com.test.mylogger1");
    static Logger logger2 = Logger.getLogger("com.test.mylogger2");

    public static void main(String[] args) throws InterruptedException {
        LogLevelChangeMonitor.startMonitor("loglevel.properties");
        for (; ; ) {
            logger1.info("log4j1动态日志logger1.info");
            logger2.debug("log4j1动态日志logger2.debug");
            System.out.println("");
            TimeUnit.SECONDS.sleep(3);
        }
    }
}