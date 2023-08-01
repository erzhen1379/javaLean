package leaning.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试
 */
public class Slf4jTest {

    private static final Logger logger = LoggerFactory.getLogger(Slf4jTest.class);
    public static void main(String[] args) {
       logger.info("测试 :{},{}","info","defu");
    }
}
