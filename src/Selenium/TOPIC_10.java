package Selenium;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TOPIC_10 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();

	}

	@Test()
	public void TC_01() throws Exception {

		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[contains(text(),'Start')]")).click();
		String text = driver.findElement(By.xpath("//div[@id='finish']//*[contains(text(),'Hello World!')]")).getText();
		Assert.assertEquals("Hello World!", text);
	}

	@Test
	public void Testscript02_explicitWait() throws Exception {

		driver.get(
				"http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@id='ctl00_ContentPlaceholder1_ctl00_ContentPlaceholder1_RadCalendar1Panel']")));
		WebElement textDayBefore = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_Label1']"));
		Assert.assertEquals("No Selected Dates to display.", textDayBefore.getText().trim());

		WebElement day = driver.findElement(By.xpath("//a[contains(text(),'12')]"));
		day.click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(@class,'rcSelected')]//a[text()='12']")));
		WebElement textDayAfter = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_Label1']"));
		Assert.assertEquals("Tuesday, December 12, 2017", textDayAfter.getText().trim());

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
