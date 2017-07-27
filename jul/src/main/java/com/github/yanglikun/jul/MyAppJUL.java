package com.github.yanglikun.jul;

import java.util.logging.Logger;

public class MyAppJUL {

    static Logger logger = Logger.getLogger("myLogger");

    public static void main(String[] args) {
        logger.info("jul-main");
        print();
    }

    public static void print() {
        logger.info("jul-print");
    }
}