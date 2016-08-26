package org.btlas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanglikun on 2016/8/26.
 */
public class Main {

    private final Logger logger = LoggerFactory.getLogger(Main.class);

    public void save() {
        logger.error("保存用户,姓名:{},年龄:{}", "张三", 30);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.save();
    }
}
