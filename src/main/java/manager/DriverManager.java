package manager;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;

public class DriverManager {
  private DriverManager() {
  }

  private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

  public static RemoteWebDriver getDriver() {
    return driver.get();
  }

  static void setDriver(RemoteWebDriver driverref) {
    if (Objects.nonNull(driverref)) {
      driver.set(driverref);
    }
  }

  static void unload() {
    driver.remove();
  }
}
