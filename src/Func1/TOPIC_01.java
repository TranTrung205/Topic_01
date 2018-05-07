package Func1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TOPIC_01 {
	WebDriver driver;
	

	@BeforeClass
	public void beforeClass() {
	driver = new ChromeDriver();
	
	}

	@Test //Login Empty
	public void TC_01() {
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement accountLink = driver.findElement(By.xpath("//*[@class='footer']//*[contains(text(),'My Account')]"));
		accountLink.click();
		
		WebElement buttonLogin = driver.findElement(By.xpath("//*[@id='send2']"));
		buttonLogin.click();
		
		WebElement errorMessageUsername = driver.findElement(By.xpath("//*[@id='advice-required-entry-email']"));
		String err= errorMessageUsername.getText();
		Assert.assertEquals("This is a required field.", err);
		
		WebElement errorMessagePassword = driver.findElement(By.xpath("//*[@id='advice-required-entry-pass']"));
		String err1= errorMessagePassword.getText();
		Assert.assertEquals("This is a required field.", err1);
	}

	@Test  //Login with email invalid
	public void TC_02() {
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
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


	@Test //Login with Password incorrect
	public void TC_03() {
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement accountLink = driver.findElement(By.xpath("//*[@class='footer']//*[contains(text(),'My Account')]"));
		accountLink.click();
		
		WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
		username.sendKeys("automation@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("//*[@id='pass']"));
		password.sendKeys("123");
		
		WebElement buttonLogin = driver.findElement(By.xpath("//*[@id='send2']"));
		buttonLogin.click();
		
		WebElement messPassword = driver.findElement(By.xpath("//*[@id='advice-validate-password-pass']"));
		String errPassword = messPassword.getText();
		Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.", errPassword);
	}

	@Test //Create an account
	public void TC_04() {
	WebElement accountCreate = driver.findElement(By.xpath("//*[@title='Create an Account']"));
	accountCreate.click();
	
	WebElement firstName = driver.findElement(By.xpath("//*[@id='firstname']"));
	firstName.clear();
	firstName.sendKeys("A");
	
	WebElement middleName = driver.findElement(By.xpath("//*[@id='middlename']"));
	middleName.clear();
	middleName.sendKeys("Van");
	
	WebElement lastName = driver.findElement(By.xpath("//*[@id='lastname']"));
	lastName.clear();
	lastName.sendKeys("Tran");
	
	WebElement emailAddress = driver.findElement(By.xpath("//*[@id='email_address']"));
	emailAddress.clear();
	emailAddress.sendKeys("smartphone"+randomEmail()+"@gmail.com");
	
	WebElement newPassword = driver.findElement(By.xpath("//*[@id='password']"));
	newPassword.clear();
	newPassword.sendKeys("123456");
	
	WebElement confirmPassword = driver.findElement(By.xpath("//*[@id='confirmation']"));
	confirmPassword.clear();
	confirmPassword.sendKeys("123456");
	
	WebElement registerBtn = driver.findElement(By.xpath("//*[@id='form-validate']//*[@title='Register']"));
	registerBtn.click();
	
	WebElement thankyouMessage = driver.findElement(By.xpath("//*[contains(text(),'Thank you for registering with Main Website Store.')]"));
	String mess = thankyouMessage.getText();
	Assert.assertEquals("Thank you for registering with Main Website Store.", mess);
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
