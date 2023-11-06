package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import manager.Driver;
import manager.DriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Hook {
    public RemoteWebDriver driver = DriverManager.getDriver();

    @Before
    public void updateName(Scenario scenario) throws InterruptedException {
        driver.executeScript("lambda-name=" + scenario.getName());
    }

    @After
    public void close_the_browser(Scenario scenario) {
        driver.executeScript("lambda-status=" + (scenario.isFailed() ? "failed" : "passed"));
        System.out.println(driver.getSessionId());
        Driver.quitDriver();
    }

}