package Main;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ControlInput.Launcher;

public class Main {
  private static Logger loggerDemo = LogManager.getLogger(Main.class);
  public static void main(String[] args) throws IOException {
    new Launcher();
	loggerDemo.info("Game Start");
	loggerDemo.error("DB is fail");
	loggerDemo.debug("This is debug");
	loggerDemo.fatal("This is debug");
  }
}
