package com.github.yanglikun.dlog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * @author yanglikun
 */
public class Log4j2Main {

    static Logger logger1 = LogManager.getLogger("com.test.mylogger1");
    static Logger logger2 = LogManager.getLogger("com.test.mylogger2");

    public static void main(String[] args) throws InterruptedException {
        LogLevelMonitor.start();
        for (; ; ) {
            logger1.info("log4j2动态日志logger1.info");
            logger2.debug("log4j2动态日志logger2.debug");
            System.out.println("");
            TimeUnit.SECONDS.sleep(3);
        }
    }

}
