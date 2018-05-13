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

import com.thoughtworks.selenium.webdriven.commands.Open;

import commons.CommonFunctions;

public class TOPIC_8 extends CommonFunctions{
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();

	}

	@Test()
	public void TC_01() throws Exception {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
//		driver.get("http://live.guru99.com/");
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		openURL(driver, "http://live.guru99.com/");
		
		
//		String domain = js.executeScript("return document.domain;").toString();
		
		Assert.assertEquals("live.guru99.com", javaScriptGetDomain(driver));
		
//		String URL = js.executeScript("return document.URL").toString();
		Assert.assertEquals("http://live.guru99.com/", javaScriptGetUrl(driver));
		
//		WebElement mobileButton = driver.findElement(By.xpath("//*[@id='nav']//*[text()='Mobile']"));
//		js.executeScript("arguments[0].click();", mobileButton);
		JavaScriptclickElements(driver, "//*[@id='nav']//*[text()='Mobile']");
		JavaScriptclickElements(driver, "//*[@title='Samsung Galaxy']//following-sibling::div//*[@class='button btn-cart']");
		Assert.assertTrue(getInnerTextJavascript(driver).contains("Samsung Galaxy was added to your shopping cart."), "Samsung Galaxy was added to your shopping cart.");
		JavaScriptclickElements(driver, "*//a[contains(text(),'Privacy Policy')]");
		Assert.assertEquals("Privacy Policy", getTitleJavascript(driver));
		scrollToBottomPage(driver);
		// Assert.assertEquals("The number of items in your Wishlist.", driver.findElement(By.xpath("*//th[contains(text(),'WISHLIST_CNT')]//following-sibling::td [contains(text(),'The number of items in your Wishlist.')]")).toString());;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.location = 'http://demo.guru99.com/v4/'");
		Assert.assertEquals("http://demo.guru99.com/v4/", javaScriptGetDomain(driver));
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
