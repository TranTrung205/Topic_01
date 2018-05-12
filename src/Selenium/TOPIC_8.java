package Selenium;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TOPIC_8 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();

	}

	@Test()
	public void TC_01() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		String domain = js.executeScript("return document.domain;").toString();
		Assert.assertEquals("live.guru99.com", domain);
		
		String URL = js.executeScript("return document.URL").toString();
		Assert.assertEquals("http://live.guru99.com/", URL);
		
		WebElement mobileButton = driver.findElement(By.xpath("//*[@id='nav']//*[text()='Mobile']"));
		js.executeScript("arguments[0].click();", mobileButton);
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomEmail() {
		Random rand = new Random();
		int value = rand.nextInt(99999999);
		return value;
	}

}
