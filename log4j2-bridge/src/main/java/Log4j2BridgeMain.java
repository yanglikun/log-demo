import com.github.yanglikun.jcl.MyAppJCL;
import com.github.yanglikun.jul.MyAppJUL;
import com.github.yanglikun.log4j.MyAppLog4j;
import com.github.yanglikun.slf4j.MyAppSlf4j;

/**
 * Created by yanglikun on 2017/8/3.
 */
public class Log4j2BridgeMain {

    static {
        //jul需要额外配置
        System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
    }

    public static void main(String[] args) {
        MyAppJCL.print();
        MyAppLog4j.print();
        MyAppJUL.print();
        MyAppSlf4j.print();
    }

}
