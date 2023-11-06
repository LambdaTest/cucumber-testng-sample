package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ToDoStepDefinition {

	public RemoteWebDriver driver = DriverManager.getDriver();

	@Given("^user is on home Page$")
	public void user_already_on_home_page() throws InterruptedException {
		System.out.println(driver.getCapabilities());
		DriverManager.getDriver().get("https://lambdatest.github.io/sample-todo-app/");
	}

	@When("^select First Item$")
	public void select_first_item() {
		WebElement li = driver.findElement(By.name("li1"));
		li.click();
	}

	@Then("^select second item$")
	public void select_second_item() {
		WebElement li = driver.findElement(By.name("li2"));
		li.click();
	}

	@Then("^add new item$")
	public void add_new_item() throws InterruptedException {
		WebElement text = driver.findElement(By.id("sampletodotext"));
		text.sendKeys("Yey, Let's add it to list");
		driver.findElement(By.id("addbutton")).click();
	}

	@Then("^verify added item$")
	public void verify_added_item() {
		String item = driver.findElement(By.xpath("//input[@name='li6']/following-sibling::span")).getText();
		Assert.assertTrue(item.contains("Yey, Let's add it to list"),
			"Expected : Yey, Let's add it to list Actual : " + item);
	}
}