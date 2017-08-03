package com.github.yanglikun.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAppLogback {

    static Logger logger = LoggerFactory.getLogger(MyAppLogback.class);

    public static void main(String[] args) {
        logger.info("logContent:{}","logback-main");
        print();
    }

    public static void print() {
        logger.info("logContent:{}","logback-print");
    }
}