package com.github.yanglikun.dlog;

import com.github.yanglikun.common.logger.LogLevelChangeMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author yanglikun
 */
public class LogbackMain {

    static Logger logger1 = LoggerFactory.getLogger("com.test.mylogger1");
    static Logger logger2 = LoggerFactory.getLogger("com.test.mylogger2");

    public static void main(String[] args) throws InterruptedException {
        LogLevelChangeMonitor.startMonitor("loglevel.properties");
        for (; ; ) {
            logger1.info("logback动态日志logger1.info");
            logger2.debug("logback动态日志logger2.debug");
            System.out.println("");
            TimeUnit.SECONDS.sleep(3);
        }
    }

}
