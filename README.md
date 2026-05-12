# Run Selenium Tests With Cucumber — TestMu AI (Formerly LambdaTest)

![image](https://user-images.githubusercontent.com/70570645/171435902-8e87c640-dc42-4d01-a322-f39ffe1867d1.png)

<p align="center">
  <a href="https://www.testmuai.com/blog/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample" target="_bank">Blog</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmuai.com/support/docs/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample" target="_bank">Docs</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmuai.com/learning-hub/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample" target="_bank">Learning Hub</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmuai.com/newsletter/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample" target="_bank">Newsletter</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmuai.com/certifications/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample" target="_bank">Certifications</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.youtube.com/@TestMuAI" target="_bank">YouTube</a>
</p>
&emsp;
&emsp;
&emsp;

*Learn how to use Cucumber framework to configure and run your Java automation testing scripts on the TestMu AI platform.*

[<img height="58" width="200" src="https://user-images.githubusercontent.com/70570645/171866795-52c11b49-0728-4229-b073-4b704209ddde.png">](https://accounts.lambdatest.com/register?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample)


## Table Of Contents

* [Pre-requisites](#pre-requisites)
* [Run Your First Test](#run-your-first-test)
* [Local Testing With Cucumber](#testing-locally-hosted-or-privately-hosted-projects)


## Pre-requisites

Before you can start performing Selenium automation testing with Cucumber, you would need to:

- Install the latest **Java development environment** i.e. **JDK 8** or higher. We recommend using the **<jdk11** version.

- Download the latest **Selenium Client** and its **WebDriver bindings** from the [official website](https://www.selenium.dev/downloads/). Latest versions of Selenium Client and WebDriver are ideal for running your automation script on TestMu AI Selenium cloud grid.

- Install **Maven**. It can be downloaded and installed following the steps from [the official website](https://maven.apache.org/). Maven can also be installed easily on **Linux/MacOS** using [Homebrew](https://brew.sh/) package manager.

### Cloning Repo And Installing Dependencies

**Step 1:** Clone the TestMu AI’s Cucumber-TestNG-Sample repository and navigate to the code directory as shown below:

```bash
git clone https://github.com/LambdaTest/cucumber-testng-sample
cd cucumber-testng-sample
```

You may also want to run the command below to check for outdated dependencies.

```bash
mvn versions:display-dependency-updates
```

### Setting Up Your Authentication

Make sure you have your TestMu AI credentials with you to run test automation scripts. You can obtain these credentials from the [TestMu AI Automation Dashboard](https://automation.lambdatest.com/build?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample) or by your [TestMu AI Profile](https://accounts.lambdatest.com/login?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample).

**Step 2:** Set TestMu AI **Username** and **Access Key** in environment variables.

* For **Linux/macOS**:
  
  ```bash
  export LT_USERNAME="YOUR_USERNAME" 
  export LT_ACCESS_KEY="YOUR ACCESS KEY"
  ```
* For **Windows**:
  ```bash
  set LT_USERNAME="YOUR_USERNAME" 
  set LT_ACCESS_KEY="YOUR ACCESS KEY"
  ```


## Run Your First Test

>**Test Scenario**: Here is the sample feature file for Cucumber that shows a scenario to test a sample to-do list app by marking couple items as done, adding a new item to the list and finally displaying the count of pending items as output.


```bash
Feature: Add new item to ToDO list

Scenario: TestMu AI ToDO Scenario

Given user is on home Page
When select First Item
Then select second item
Then add new item
Then verify added item
```

Check out the [TestRunner.java](https://github.com/LambdaTest/cucumber-testng-sample/blob/master/src/main/java/MyRunner/TestRunner.java) file to automate our feature file through Selenium using Cucumber-TestNG.

### Configuring Your Test Capabilities

**Step 3:** In the test script, you need to update your test capabilities. In this code, we are passing browser, browser version, and operating system information, along with TestMu AI Selenium grid capabilities via capabilities object. The capabilities object in the above code are defined as:

```java
DesiredCapabilities capability = new DesiredCapabilities();
            capability.setCapability(CapabilityType.BROWSER_NAME, browser);
            capability.setCapability(CapabilityType.VERSION,version);
            capability.setCapability(CapabilityType.PLATFORM, platform);
            capability.setCapability("build", "Your Build Name");
```

You can generate capabilities for your test requirements with the help of [Desired Capability Generator](https://www.testmuai.com/capabilities-generator/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample).

### Executing The Test

**Step 4:** The tests can be executed in the terminal using the following command:

```bash
mvn test
```

Your test results would be displayed on the test console (or command-line interface if you are using terminal/cmd) and on TestMu AI Automation Dashboard. TestMu AI Automation Dashboard will help you view all your text logs, screenshots and video recording for your entire automation tests.


## Testing Locally Hosted Or Privately Hosted Projects

You can test your locally hosted or privately hosted projects with TestMu AI Selenium grid using TestMu AI Tunnel. All you would have to do is set up an SSH tunnel using tunnel and pass toggle `tunnel = True` via desired capabilities. TestMu AI Tunnel establishes a secure SSH protocol based tunnel that allows you in testing your locally hosted or privately hosted pages, even before they are live.

Refer our [TestMu AI Tunnel documentation](https://www.testmuai.com/support/docs/testing-locally-hosted-pages/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample) for more information.

Here’s how you can establish TestMu AI Tunnel.

Download the binary file of:
* [TestMu AI Tunnel for Windows](https://downloads.lambdatest.com/tunnel/v3/windows/64bit/LT_Windows.zip)
* [TestMu AI Tunnel for macOS](https://downloads.lambdatest.com/tunnel/v3/mac/64bit/LT_Mac.zip)
* [TestMu AI Tunnel for Linux](https://downloads.lambdatest.com/tunnel/v3/linux/64bit/LT_Linux.zip)


Open command prompt and navigate to the binary folder.

Run the following command:

```bash
LT -user {user’s login email} -key {user’s access key}
```
So if your user name is lambdatest@example.com and key is 123456, the command would be:

```bash
LT -user lambdatest@example.com -key 123456
```
Once you are able to connect **TestMu AI Tunnel** successfully, you would just have to pass on tunnel capabilities in the code shown below :

**Tunnel Capability**

```java
DesiredCapabilities capabilities = new DesiredCapabilities();        
        capabilities.setCapability("tunnel", true);
```


## Additional Links

- [Advanced Configuration for Capabilities](https://www.testmuai.com/support/docs/selenium-automation-capabilities/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample)
- [How To Test Locally Hosted Apps](https://www.testmuai.com/support/docs/testing-locally-hosted-pages/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample)
- [How To Integrate TestMu AI With CI/CD](https://www.testmuai.com/support/docs/integrations-with-ci-cd-tools/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample)


## Tutorials 📙

Check out our latest tutorials on JUnit automation testing 👇

* [Configure Cucumber Setup In Eclipse And IntelliJ [Tutorial]](https://www.testmuai.com/blog/configure-cucumber-setup-in-eclipse-and-intellij/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample)
* [How To Use Annotations In Cucumber Framework [Tutorial]](https://www.testmuai.com/blog/cucumber-annotations-hooks-tutorial/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample)
* [Automation Testing With Selenium, Cucumber & TestNG](https://www.testmuai.com/blog/automation-testing-with-selenium-cucumber-testng/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample)
* [How To Integrate Cucumber With Jenkins?](https://www.testmuai.com/blog/cucumber-with-jenkins-integration/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample)
* [Top 5 Cucumber Best Practices For Selenium Automation](https://www.testmuai.com/blog/cucumber-best-practices/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample)



## Documentation & Resources :books:

      
Visit the following links to learn more about TestMu AI's features, setup and tutorials around test automation, mobile app testing, responsive testing, and manual testing.

* [TestMu AI Documentation](https://www.testmuai.com/support/docs/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample)
* [TestMu AI Blog](https://www.testmuai.com/blog/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample)
* [TestMu AI Learning Hub](https://www.testmuai.com/learning-hub/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample)    


## TestMu AI Community :busts_in_silhouette:

The [TestMu AI Community](https://community.testmuai.com/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample) allows people to interact with tech enthusiasts. Connect, ask questions, and learn from tech-savvy people. Discuss best practises in web development, testing, and DevOps with professionals from across the globe 🌎


## What's New At TestMu AI ❓

To stay updated with the latest features and product add-ons, visit [Changelog](https://changelog.testmuai.com/) 
      

## 🚀 [LambdaTest is Now TestMu AI](https://www.testmuai.com/lambdatest-is-now-testmuai/)

👋 Welcome to TestMu AI, the next evolution of LambdaTest. As of January 2026, LambdaTest has officially rebranded to TestMu AI. We have evolved from a cross-browser testing cloud into a unified, AI-native quality engineering platform designed for the modern DevOps era.

Whether you have been part of the LambdaTest community for years or are just discovering TestMu AI, our mission remains the same: to help you ship faster with high-scale test execution, autonomous testing, and deep quality analytics.

**🔄 Our Rebrand Journey**

We chose the name TestMu AI to reflect our shift towards intelligent, autonomous testing. While our identity has changed, our core technology and commitment to the testing community stay the same.

**✨ Specialties**

- 🤖 AI-Native Test Execution (Formerly LambdaTest)
- ⚡ Autonomous Test Automation
- 🌐 Cross-Browser & Mobile Testing
- 📊 Unified Quality Intelligence

👉 Find [LambdaTest's New Home](https://www.testmuai.com/).

## We are here to help you :headphones:

* Got a query? we are available 24x7 to help. [Contact Us](mailto:support@testmuai.com)
* For more info, visit - [TestMu AI](https://www.testmuai.com/?utm_source=github&utm_medium=repo&utm_campaign=cucumber-testng-sample)
