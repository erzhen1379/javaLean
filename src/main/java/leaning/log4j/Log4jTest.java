package leaning.log4j;


import org.apache.log4j.Logger;

/**
 *
 */
public class Log4jTest {

    public static void main(String[] args) {

        final Logger LOGGER = Logger.getLogger(Log4jTest.class);
        LOGGER.info("普通信息");
        LOGGER.error("普通错误");
        LOGGER.trace("堆栈信息");
        LOGGER.fatal("致命错误");
        LOGGER.warn("警告信息");
        LOGGER.debug("调试信息");

    }

}