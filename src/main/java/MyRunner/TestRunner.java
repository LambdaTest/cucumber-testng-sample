package MyRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import manager.Driver;
import manager.DriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.URL;

@CucumberOptions(
	features = "src/main/java/Features/todo.feature",
	glue = {"stepDefinitions"},
	plugin = "json:target/cucumber-reports/CucumberTestReport.json")

public final class TestRunner extends AbstractTestNGCucumberTests {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpCucumber() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "version", "platform" })
    public void setUpClass(String browser, String version, String platform) throws Exception {

        String username = System.getenv("LT_USERNAME") == null ? "YOUR_LT_USERNAME" : System.getenv("LT_USERNAME");
        String accesskey = System.getenv("LT_ACCESS_KEY") == null ? "YOUR_LT_ACCESS_KEY" : System.getenv("LT_ACCESS_KEY");

        MutableCapabilities ltOptions = new MutableCapabilities();
        ltOptions.setCapability("build", "Cucumber Sample Build");
        ltOptions.setCapability("project", "Cucumber TestNG Selenium Sample");
        ltOptions.setCapability("selenium_version", "latest");
//        ltOptions.setCapability("console", true);
//        ltOptions.setCapability("network", true);
//        ltOptions.setCapability("visual", true);
//        ltOptions.setCapability("video", true);

        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
        capabilities.setCapability(CapabilityType.BROWSER_VERSION, version);
        capabilities.setCapability("platformName", platform);
        capabilities.setCapability("LT:Options", ltOptions);

        String gridURL = "https://" + username + ":" + accesskey + "@hub.lambdatest.com/wd/hub";

        System.out.println("Connecting to: " + gridURL);
        System.out.println("Capabilities: " + capabilities);

        RemoteWebDriver driver = new RemoteWebDriver(new URL(gridURL), capabilities);

        Driver.initDriver(driver);
        System.out.println("Session ID: " + DriverManager.getDriver().getSessionId());
    }

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		testNGCucumberRunner.finish();
	}
}