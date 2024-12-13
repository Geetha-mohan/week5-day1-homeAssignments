package week5.day1.homeassignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class NewLegalEntity extends ProjectBaseMethods {


	@Test
	public void createNewLegalEntity() throws InterruptedException {

		//create new legal entity
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(2000);

		//enter username and click save
		driver.findElement(By.xpath("//label[text()='Legal Entity Name']/following::div")).sendKeys("Salesforce Automation by GeethaMohan");
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		//verify the legal name displaying
		String legalName = driver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-text")).getText();
		System.out.println("Legal name "+legalName);


	}
}