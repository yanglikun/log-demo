package com.github.yanglikun.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 异步输出，对于可变的对象没有问题，因为调用toString()是同步的。
 * 但是自己在扩展log4j2实现自己的event的时候要考虑参数的可变
 * Created by yanglikun on 2017/8/4.
 */
public class Log4jManMutable {

    static Logger logger = LogManager.getLogger(Log4jManMutable.class);

    public static void main(String[] args) {
        Order order = new Order();
        order.setId(11L);
        order.setState(0);

        logger.debug("开始下单,order:{}", order);
        order.setState(1);
        System.out.println("main exit");
    }


}
