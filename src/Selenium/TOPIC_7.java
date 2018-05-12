package Selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.CommonFunctions;

public class TOPIC_7 extends CommonFunctions {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();

	}

	@Test(enabled=false)
	public void TC_01() throws Exception {
//		driver.navigate().to("https://www.hdfcbank.com/");
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		openURL(driver,"https://www.hdfcbank.com/");
		
//		WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@id,'viz_iframe')]"));
//		driver.switchTo().frame(iframe);
		switchToiFrame(driver, "//iframe[contains(@id,'viz_iframe')]");

//		WebElement textMsg = driver.findElement(By.xpath("//*[@id='messageText']"));
		AssertJUnit.assertEquals("What are you looking for?", getTextElements(driver, "//*[@id='messageText']"));
		
		driver.switchTo().defaultContent();
		
//		WebElement textSearch = driver.findElement(By.xpath("//*[@placeholder='Search']"));
//		textSearch.sendKeys("123123123");
		sendKeysToElement(driver, "//*[@placeholder='Search']", "123123123");	
}
	
	@Test (enabled=false)
	public void TC_02() throws Exception {
		//		driver.get("http://daominhdam.890m.com/");
		//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//		driver.manage().window().maximize();
		openURL(driver, "http://daominhdam.890m.com/");

		//		WebElement windowClick = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
		//		windowClick.click();

		clickToElements(driver, "//a[contains(text(),'Click Here')]");

		//			String parentWindow = driver.getWindowHandle();
		parentWindowID(driver);
		switchToWindowByTitle(driver, "Google");
		AssertJUnit.assertEquals("Google", driver.getTitle());

		Thread.sleep(3000);
		closeAllWithoutParentWindows(driver, "http://daominhdam.890m.com/");


	}
	
	
	 @Test (enabled = true)
	 public void TC_03() throws InterruptedException {
		 openURL(driver, "http://www.hdfcbank.com/");
		 Thread.sleep(5000);
//		 switchToDefaultContent(driver);
		 parentWindowID(driver);
		 clickToElements(driver, "*//a[@href='/htdocs/common/agri/index.html']");
		 switchToWindowByTitle(driver, "HDFC Bank Kisan Dhan Vikas e-Kendra");
		Thread.sleep(5000);
		 clickToElements(driver, "//*[contains(text(),'Account Details')]");
		 switchToWindowByTitle(driver, "Welcome to HDFC Bank NetBanking");
		 switchToiFrame(driver, "//frame[@name='footer']");
		 clickToElements(driver, "*//a[contains(text(),'Privacy Policy')]");
		 switchToWindowByTitle(driver, "HD Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan");
		 clickToElements(driver, "*//a[@title='Corporate Social Responsibility']");
	 }
	 
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	public int randomEmail() {
		Random rand = new Random();
		int value = rand.nextInt(99999999);
		return value;
	}

}
