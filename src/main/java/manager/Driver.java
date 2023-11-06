package manager;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class Driver {
  private Driver() {
  }

  public static void initDriver(RemoteWebDriver driver) throws Exception {

    if (Objects.isNull(DriverManager.getDriver())) {
      try {
        DriverManager.setDriver(driver);
      } catch (Exception e) {
        throw new Exception("Please check the capabilities of browser");
      }
      DriverManager.getDriver().manage().window().maximize();
      DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
  }

  public static void quitDriver() {
    if (Objects.nonNull(DriverManager.getDriver())) {
      DriverManager.getDriver().quit();
      DriverManager.unload();
    }
  }

}
