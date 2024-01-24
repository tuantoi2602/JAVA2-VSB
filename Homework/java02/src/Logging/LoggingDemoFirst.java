package Logging;
import org.apache.logging.log4j.*;

public class LoggingDemoFirst {
	private static Logger loggerDemo = LogManager.getLogger(LoggingDemoFirst.class.getName());

	public static void main(String[] args) {
		System.out.println("hello world");
		loggerDemo.info("Click successful");
		loggerDemo.error("DB is fail");
		loggerDemo.debug("This is debug");
		loggerDemo.fatal("This is debug");

	}
}
