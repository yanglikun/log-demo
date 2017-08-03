package com.github.yanglikun.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by yanglikun on 2017/8/2.
 */
public class MyAppLog4j2 {

    static Logger logger = LogManager.getLogger(MyAppLog4j2.class);

    public static void main(String[] args) {
        logger.info("logContent:{}", "log4j2-main");
        print();
    }

    public static void print() {
        logger.info("logContent:{}", "log4j2-print");
    }

}
