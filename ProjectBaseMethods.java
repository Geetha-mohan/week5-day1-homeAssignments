package week5.day1.homeassignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectBaseMethods {

	public RemoteWebDriver driver;
	public EdgeOptions options;
	public JavascriptExecutor js;

	@BeforeMethod	
	public void preConditions() {
		options = new EdgeOptions();
		options.addArguments("--incognito");
		options.addArguments("--disable-notifications");

		driver = new EdgeDriver((EdgeOptions) options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//login
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("leaf@2024");
		driver.findElement(By.id("Login")).click();

		//app Launcher and click View All
		driver.findElement(By.xpath("//button[contains(@title,'App Launcher')]/div")).click();
		driver.findElement(By.xpath("//button[contains(@aria-label,'View All Applications')]")).click();

		// Locate the element you want to scroll to Legal Entities
		WebElement targetElement = driver.findElement(By.xpath("//p[text()='Legal Entities']"));

		// Use JavaScriptExecutor to scroll the element into view
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
		targetElement.click();

	}
	
	@AfterMethod
	public void postConditions() {
		driver.quit();
	}

}
