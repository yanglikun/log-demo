package com.github.yanglikun.log4j;

import org.apache.log4j.Logger;

public class MyAppLog4j {

    static Logger logger = Logger.getLogger(MyAppLog4j.class);

    public static void main(String[] args) {
        logger.info("logContent:log4j-main");
        print();
    }

    public static void print() {
        logger.info("logContent:log4j-print");
    }
}