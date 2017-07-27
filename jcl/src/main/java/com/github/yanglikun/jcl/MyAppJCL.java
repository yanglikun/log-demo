package com.github.yanglikun.jcl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyAppJCL {


    static Log logger;

    static {
        //诊断开关
        System.setProperty("org.apache.commons.logging.diagnostics.dest", "STDOUT");
        logger = LogFactory.getLog(MyAppJCL.class);
    }

    public static void main(String[] args) {
        logger.info("jcl-main");
        print();
    }

    public static void print() {
        logger.info("jcl-print");
    }
}