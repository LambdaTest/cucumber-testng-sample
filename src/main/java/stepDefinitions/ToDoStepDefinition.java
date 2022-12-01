package stepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import MyRunner.TestRunner;


public class ToDoStepDefinition extends TestRunner {

	public RemoteWebDriver driver = this.connection;

	
	@Given("^user is on home Page$")
	public void user_already_on_home_page() throws InterruptedException {
		System.out.println(driver.getCapabilities());
		driver.get("https://lambdatest.github.io/sample-todo-app/");
		Thread.sleep(5000);
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
		text.clear();
		driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
		Thread.sleep(1000);
		driver.findElement(By.id("addbutton")).click();
		Thread.sleep(2000);
	}

	@Then("^verify added item$")
	public void verify_added_item() {
		String item = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText();
		Assert.assertTrue(item.contains("Yey, Let's add it to list"), "Expected : Yey, Let's add it to list Actual : " + item);
	}

	

}
