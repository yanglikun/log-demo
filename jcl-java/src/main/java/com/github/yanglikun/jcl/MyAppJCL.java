package com.github.yanglikun.jcl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 选择具体的日志实现类在： {@link org.apache.commons.logging.impl.LogFactoryImpl#discoverLogImplementation(java.lang.String)}
 */
public class MyAppJCL {


    static Log logger;

    static {
        //诊断开关,可以查看选择LogFactory和Log实现的过程
        System.setProperty("org.apache.commons.logging.diagnostics.dest", "STDOUT");
        logger = LogFactory.getLog(MyAppJCL.class);
    }

    public static void main(String[] args) {
        logger.info("logContent:jcl-main");
        print();
    }

    public static void print() {
        logger.info("logContent:jcl-print");
    }
}