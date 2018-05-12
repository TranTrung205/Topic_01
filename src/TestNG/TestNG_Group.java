package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_Group {
	WebDriver driver;

	@BeforeClass(groups = "group1")
	public void beforeClass() {
		driver = new ChromeDriver();
	}

	@Test(groups = "group1")
	public void TC_01() {
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement accountLink = driver.findElement(By.xpath("//*[@class='footer']//*[contains(text(),'My Account')]"));
		accountLink.click();

		WebElement buttonLogin = driver.findElement(By.xpath("//*[@id='send2']"));
		buttonLogin.click();

		WebElement errorMessageUsername = driver.findElement(By.xpath("//*[@id='advice-required-entry-email']"));
		String err = errorMessageUsername.getText();
		Assert.assertEquals("This is a required field.", err);

		WebElement errorMessagePassword = driver.findElement(By.xpath("//*[@id='advice-required-entry-pass']"));
		String err1 = errorMessagePassword.getText();
		Assert.assertEquals("This is a required field.", err1);
	}

	@Test() // Login with email invalid
	public void TC_02() {
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement accountLink = driver.findElement(By.xpath("//*[@class='footer']//*[contains(text(),'My Account')]"));
		accountLink.click();

		WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
		username.sendKeys("123434234@12312.123123");

		WebElement password = driver.findElement(By.xpath("//*[@id='pass']"));
		password.sendKeys("123456");

		WebElement buttonLogin = driver.findElement(By.xpath("//*[@id='send2']"));
		buttonLogin.click();

		WebElement errorMassageEmail = driver.findElement(By.xpath("//*[@id='advice-validate-email-email']"));
		String errEmail = errorMassageEmail.getText();
		Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.", errEmail);
	}

	@AfterClass(groups = "group1")
	public void afterClass() {
		driver.quit();
	}

}
