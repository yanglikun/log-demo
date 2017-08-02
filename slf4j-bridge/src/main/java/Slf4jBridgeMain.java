import com.github.yanglikun.jcl.MyAppJCL;
import com.github.yanglikun.jul.MyAppJUL;
import com.github.yanglikun.log4j.MyAppLog4j;
import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * Created by yanglikun on 2017/8/2.
 */
public class Slf4jBridgeMain {

    static {
        //jul 需要显示安装 https://www.slf4j.org/api/org/slf4j/bridge/SLF4JBridgeHandler.html
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    public static void main(String[] args) {
        MyAppJCL.print();
        MyAppJUL.print();
        MyAppLog4j.print();
    }


}
