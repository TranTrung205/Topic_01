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

import commons.CommonFunctions;

public class TOPIC_5 extends CommonFunctions {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();

	}

	@Test(enabled = true)
	public void TC_00_Combobox() throws Exception {
		// driver.navigate().to("http://daominhdam.890m.com/#");
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
		openURL(driver, "http://daominhdam.890m.com/#");

		// Select jobRolecombobox = new
		// Select(driver.findElement(By.xpath("//*[@id='job1']")));
		// jobRolecombobox.selectByVisibleText("Manual Tester");
		selectToElement(driver, "//*[@id='job1']", "Manual Tester");
		Thread.sleep(5000);
		// jobRolecombobox.selectByVisibleText("Mobile Tester");
		selectToElement(driver, "//*[@id='job1']", "Mobile Tester");
		Thread.sleep(2000);
		Assert.assertEquals("Mobile Tester", getFirstSelectedOption(driver, "//*[@id='job1']"));
	}

	@Test(enabled = false)
	public void TC_01() {
		driver.navigate().to("http://daominhdam.890m.com/#");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement enableButton = driver.findElement(By.xpath("//*[@id='button-enabled']"));
		enableButton.click();

		// String homePage = driver.getCurrentUrl();

		Assert.assertEquals("http://daominhdam.890m.com/#", getCurrentUrl(driver));

		driver.navigate().back();

	}

	@Test(enabled = false)
	public void TC_02() {
		driver.get("http://demos.telerik.com/kendo-ui/styling/checkboxes");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement dualCheckbox = driver.findElement(
				By.xpath("//*[contains(text(),'Dual-zone air conditioning')]/preceding-sibling::input[@id='eq5']"));
		// dualCheckbox.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", dualCheckbox);

		if (isSelected(driver,
				"//*[contains(text(),'Dual-zone air conditioning')]/preceding-sibling::input[@id='eq5']") == true)
			System.out.println("checkbox is checked");

		else
			System.out.println("checkbox is NOT checked");

		// dualCheckbox.click();
		executor.executeScript("arguments[0].click();", dualCheckbox);
		if (dualCheckbox.isSelected() == false)
			System.out.println("checkbox is unchecked");

		else
			System.out.println("checkbox is checked");
	}

	@Test(enabled = false)
	public void TC_03() throws InterruptedException {
		driver.get("http://demos.telerik.com/kendo-ui/styling/radios");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement carEngine = driver.findElement(By.xpath("//*[contains(text(),'2.0 Petrol, 147kW')]"));
		/*
		 * JavascriptExecutor executor = (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", carEngine);
		 */
		if (carEngine.isSelected() == false)
			carEngine.click();
		Thread.sleep(5000);
	}

	@AfterClass
	public void afterClass() {
		quit(driver);
	}

	public int randomEmail() {
		Random rand = new Random();
		int value = rand.nextInt(99999999);
		return value;
	}

}
