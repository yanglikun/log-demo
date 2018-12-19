import com.github.yanglikun.jcl.MyAppJCL;
import com.github.yanglikun.jul.MyAppJUL;
import com.github.yanglikun.log4j.MyAppLog4j;
import com.github.yanglikun.log4j2.MyAppLog4j2;
import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * Created by yanglikun on 2017/8/2.
 */
public class Slf4jBridgeMain {

    static {
        installSLF4JBridgeHandler();
    }

    /**
     * jul 需要显示安装 https://www.slf4j.org/api/org/slf4j/bridge/SLF4JBridgeHandler.html
     */
    private static void installSLF4JBridgeHandler() {
        //移除JUL rootLogger的所有Handlers
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        //安装桥接的Handler
        SLF4JBridgeHandler.install();
    }

    public static void main(String[] args) {
        MyAppJCL.print();
        MyAppJUL.print();
        MyAppLog4j.print();
        MyAppLog4j2.print();
    }


}
