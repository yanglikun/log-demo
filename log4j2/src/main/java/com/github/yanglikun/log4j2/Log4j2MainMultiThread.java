package com.github.yanglikun.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.UUID;

/**
 * Created by yanglikun on 2017/8/3.
 */
public class Log4j2MainMultiThread {

    static Logger logger = LogManager.getLogger(Log4j2MainMultiThread.class);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            final int threadIndex = i;
            new Thread("t-" + threadIndex) {
                public void run() {
                    String uuid = getUUID();
                    ThreadContext.put("traceNO", uuid);
                    logger.info("logContent:t-" + threadIndex + "-" + uuid);
                }
            }.start();
        }
        System.out.println("debug this line to see async");
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
