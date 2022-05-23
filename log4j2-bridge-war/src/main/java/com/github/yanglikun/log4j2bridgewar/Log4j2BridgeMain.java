package com.github.yanglikun.log4j2bridgewar;

import com.github.yanglikun.jcl.MyAppJCL;
import com.github.yanglikun.jul.MyAppJUL;
import com.github.yanglikun.log4j.MyAppLog4j;
import com.github.yanglikun.slf4j.MyAppSlf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.jul.Log4jBridgeHandler;

/**
 * Created by yanglikun on 2017/8/3.
 * https://logging.apache.org/log4j/2.0/log4j-jul/index.html
 */
public class Log4j2BridgeMain {

    private static Logger logger4J2 = LogManager.getLogger(Log4j2BridgeMain.class);

    static {
        //tomcat 会自己加载 logging.properties，不需要进行Log4jBridgeHandler.install
        //handle1();
        //handle2();
    }


    public static void main(String[] args) {
        logger4J2.info("logger4j2的api");
        MyAppJCL.print();
        MyAppJUL.print();
        MyAppLog4j.print();
        MyAppSlf4j.print();
    }

    /**
     * adapter
     * JUL需要单独设置
     * Using System.setProperty() before any calls are made to LogManager or Logger.
     */
    private static void handle1() {
        System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
    }

    private static void handle2() {
        Log4jBridgeHandler.install(true, null, true);
    }

}
