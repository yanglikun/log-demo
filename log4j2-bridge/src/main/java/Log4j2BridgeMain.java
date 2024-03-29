import com.github.yanglikun.jcl.MyAppJCL;
import com.github.yanglikun.jul.MyAppJUL;
import com.github.yanglikun.log4j.MyAppLog4j;
import com.github.yanglikun.slf4j.MyAppSlf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.jul.Log4jBridgeHandler;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by yanglikun on 2017/8/3.
 * https://logging.apache.org/log4j/2.x/log4j-jul/index.html
 */
public class Log4j2BridgeMain {


    static {
        //handle1();
        handle2();
    }

    private static Logger logger4J2 = LogManager.getLogger(Log4j2BridgeMain.class);

    public static void main(String[] args) {
        logger4J2.info("logger4j2的api");
        MyAppJCL.print();
        MyAppJUL.print();
        MyAppLog4j.print();
        MyAppSlf4j.print();
    }

    /**
     * adapter，有两种方式
     * 1、编程式: System.setProperty() before any calls are made to LogManager or Logger.
     * 2、使用jvm启动参数:-Djava.util.logging.manager=org.apache.logging.log4j.jul.LogManager
     */
    private static void handle1() {
        System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
    }

    /**
     * bridge handler:也有两种方式
     * 1、编程式：Log4jBridgeHandler.install
     * 2、logging.properties 配置文件中配置
     */
    private static void handle2() {
        Log4jBridgeHandler.install(true, null, true);
    }


}
