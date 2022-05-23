package com.github.yanglikun.jul;


import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyAppJUL {

    /**
     * 默认使用的日志格式化类：{@link SimpleFormatter}
     */
    static Logger logger = Logger.getLogger("myLogger");

    public static void main(String[] args) {
        logger.info("logContent:jul-main");
        print();
    }

    public static void print() {
        logger.info("logContent:jul-print");
    }

}
