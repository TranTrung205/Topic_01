package Selenium;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.CommonFunctions;

public class TOPIC_5_Alert extends CommonFunctions {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();

	}

	@Test (enabled = false)
	public void TC_01() throws Exception {
		driver.navigate().to("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement jsAlertButton = driver.findElement(By.xpath("//*[contains(text(),'Click for JS Alert')]"));
		jsAlertButton.click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("I am a JS Alert", alert.getText());
		alert.accept();
		WebElement jsAlertMess = driver.findElement(By.xpath("//*[@id='result']"));

		Assert.assertEquals("You clicked an alert successfully", jsAlertMess.getText());
	}

	@Test (enabled = false)
	public void TC_02() throws Exception {
		driver.navigate().to("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement jsAlertButton = driver.findElement(By.xpath("//*[contains(text(),'Click for JS Confirm')]"));
		jsAlertButton.click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("I am a JS Confirm", alert.getText());
		alert.dismiss();	
		WebElement jsAlertMess = driver.findElement(By.xpath("//*[@id='result']"));
		Assert.assertEquals("You clicked: Cancel", jsAlertMess.getText());
	}

@Test (enabled = false)
	public void TC_03() throws Exception {
	driver.navigate().to("http://daominhdam.890m.com/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();

	WebElement jsAlertButton = driver.findElement(By.xpath("//*[contains(text(),'Click for JS Prompt')]"));
	jsAlertButton.click();
	Alert alert = driver.switchTo().alert();

	Assert.assertEquals("I am a JS prompt", alert.getText());

	String name = "Trung";

	alert.sendKeys(name);

	WebElement jsAlertMess = driver.findElement(By.xpath("//*[@id='result']"));

	Assert.assertEquals("You clicked: Cancel", jsAlertMess.getText());
}
	
	@Test(enabled = false)
	public void TC_04() throws InterruptedException {
		openURL(driver, "http://daominhdam.890m.com/");
		clickToElements(driver, ".//*[contains( text(),'Click for JS Alert') ]");
		//switchToAlert(driver);
		Assert.assertEquals("I am a JS Alert", getTextAlert(driver));
		Thread.sleep(3000);
		acceptAlert(driver);
		Assert.assertEquals("You clicked an alert successfully", getTextElements(driver, "//*[@id='result']"));
		Thread.sleep(3000);
	}
	@Test(enabled = false)
	public void TC_05() throws InterruptedException {
		openURL(driver, "http://daominhdam.890m.com/");
		clickToElements(driver, "//*[contains(text(),'Click for JS Confirm')]");
		//switchToAlert(driver);
		Assert.assertEquals("I am a JS Confirm", getTextAlert(driver));
		Thread.sleep(3000);
		dissmissAlert(driver);
		Thread.sleep(3000);
		Assert.assertEquals("You clicked: Cancel", getTextElements(driver, "//*[@id='result']"));
	}
	
	@Test (enabled = true)
	public void TC_06() {
		openURL(driver, "http://daominhdam.890m.com/");
		clickToElements(driver, "//*[contains(text(),'Click for JS Prompt')]");
		Assert.assertEquals("I am a JS prompt", getTextAlert(driver));
		sendkeysToAlert(driver, "TRUNG");
		acceptAlert(driver);
		Assert.assertEquals("You entered: TRUNG" , getTextElements(driver, "//*[@id='result']"));
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
