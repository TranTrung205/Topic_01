package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Parameter {
	WebDriver driver;

	@Parameters({ "browser" })
	@BeforeClass
	public void setup(String browser) {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", ".\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browser.equals("firefox"))
			driver = new FirefoxDriver();
	}

	@Test(enabled = false)
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

	@Parameters({ "username", "password" })
	@Test() // Login with email invalid
	public void TC_02(String username, String password) {
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement accountLink = driver.findElement(By.xpath("//*[@class='footer']//*[contains(text(),'My Account')]"));
		accountLink.click();

		WebElement usernametxt = driver.findElement(By.xpath("//input[@id='email']"));
		usernametxt.sendKeys(username);

		WebElement passwordtxt = driver.findElement(By.xpath("//*[@id='pass']"));
		passwordtxt.sendKeys(password);

	}

	@AfterClass()
	public void afterClass() {
		driver.quit();
	}

}
