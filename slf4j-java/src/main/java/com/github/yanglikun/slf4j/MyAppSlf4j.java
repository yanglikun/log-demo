package com.github.yanglikun.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanglikun on 2017/7/30.
 */
public class MyAppSlf4j {

    static Logger logger = LoggerFactory.getLogger(MyAppSlf4j.class);

    public static void main(String[] args) {
        logger.info("logContent:{}", "slf4j-main");
        print();
    }

    public static void print() {
        logger.info("logContent:{}", "slf4j-print");
    }
}
