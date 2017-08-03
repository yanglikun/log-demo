package com.github.yanglikun.log4j2;

/**
 * Created by yanglikun on 2017/8/3.
 */
public class Log4jManBasic {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyAppLog4j2.print();
        System.out.println("debug this line to see async");
    }

}
