package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import manager.Driver;
import manager.DriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.json.JSONObject;
import java.io.OutputStream;
import java.util.Base64;

public class Hook {
    public RemoteWebDriver driver = DriverManager.getDriver();

    @Before
    public void updateName(Scenario scenario) throws InterruptedException {
        driver.executeScript("lambda-name=" + scenario.getName());
    }

    @AfterStep
    public void captureDom() throws InterruptedException {
        driver.executeScript("return document.documentElement.outerHTML;");
    }

    @After
    public void close_the_browser(Scenario scenario) throws InterruptedException {
        driver.executeScript("lambda-status=" + (scenario.isFailed() ? "failed" : "passed"));

        String testId = driver.getSessionId().toString();
        System.out.println(testId);
        Thread.sleep(20000);
        downloadFiles(testId,System.getenv("LT_USERNAME"),System.getenv("LT_ACCESS_KEY"));
        Driver.quitDriver();
    }

    public static void downloadFiles(String testId, String username, String accessKey) {
        String directoryPath = "./" + testId;
        String apiUrl = "https://api.lambdatest.com/automation/api/v1/sessions/" + testId + "/results";

        // Encode username and access key
        String authValue = Base64.getEncoder().encodeToString((username + ":" + accessKey).getBytes());

        try {
            // Create directory for testId if it doesn't already exist
            Path directory = Paths.get(directoryPath);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            // Download ZIP file containing results
            downloadFile(apiUrl, authValue, Paths.get(directoryPath, testId + "_results.zip"));

            System.out.println("ZIP file downloaded successfully.");
        } catch (IOException e) {
            System.err.println("Error downloading the ZIP file: " + e.getMessage());
        }
    }

    private static void downloadFile(String fileUrl, String authValue, Path targetPath) throws IOException {
        URL url = new URL(fileUrl);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");
        httpConn.setRequestProperty("Authorization", "Basic " + authValue);

        // Check response code and handle input stream accordingly
        if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            try (InputStream in = httpConn.getInputStream();
                    OutputStream out = Files.newOutputStream(targetPath)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
        } else {
            throw new IOException("Server returned non-OK status: " + httpConn.getResponseCode());
        }

        httpConn.disconnect();
    }

}