package Selenium;

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

import commons.CommonFunctions;

public class TOPIC_01 extends CommonFunctions {
	private static final int Seconds = 0;
	WebDriver driver;
	

	@BeforeClass
	public void beforeClass() {
	driver = new ChromeDriver();
	
	}

	@Test (enabled=false)  //Login Empty
	public void TC_01 () {
//		driver.get("http://live.guru99.com/");
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		
		openURL(driver, "http://live.guru99.com/");
		
//		WebElement accountLink = driver.findElement(By.xpath("//*[@class='footer']//*[contains(text(),'My Account')]"));
//		accountLink.click();
		
		clickToElements(driver, "//*[@class='footer']//*[contains(text(),'My Account')]");
		
//		WebElement buttonLogin = driver.findElement(By.xpath("//*[@id='send2']"));
//		buttonLogin.click();
		
		clickToElements(driver, "//*[@id='send2']");
		
//		WebElement errorMessageUsername = driver.findElement(By.xpath("//*[@id='advice-required-entry-email']"));
	
		String err= 	getTextElements(driver, "//*[@id='advice-required-entry-email']");
		Assert.assertEquals("This is a required field.", err);
		
//		WebElement errorMessagePassword = driver.findElement(By.xpath("//*[@id='advice-required-entry-pass']"));
		String err1= getTextElements(driver, "//*[@id='advice-required-entry-pass']");
		Assert.assertEquals("This is a required field.", err1);
	}

	@Test (enabled = false) //Login with email invalid
	public void TC_02() {
//		driver.get("http://live.guru99.com/");
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		openURL(driver, "http://live.guru99.com/");
		
//		WebElement accountLink = driver.findElement(By.xpath("//*[@class='footer']//*[contains(text(),'My Account')]"));
//		accountLink.click();
		
		clickToElements(driver, "//*[@class='footer']//*[contains(text(),'My Account')]");
		
		sendKeysToElement(driver, "//input[@id='email']", "123434234@12312.123123");
		sendKeysToElement(driver, "//*[@id='pass']", "123456");
//		WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
//		username.sendKeys("123434234@12312.123123");
		
//		WebElement password = driver.findElement(By.xpath());
//		password.sendKeys("123456");
		
		clickToElements(driver, "//*[@id='send2']");
//		WebElement buttonLogin = driver.findElement(By.xpath("//*[@id='send2']"));
//		buttonLogin.click();
		
		String errEmail = getTextElements(driver, "//*[@id='advice-validate-email-email']");
		Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.", errEmail);
	}


	@Test(enabled=false) //Login with Password incorrect
	public void TC_03() {
//		driver.get("http://live.guru99.com/");
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		openURL(driver, "http://live.guru99.com/");
		
//		WebElement accountLink = driver.findElement(By.xpath("//*[@class='footer']//*[contains(text(),'My Account')]"));
//		accountLink.click();
		clickToElements(driver, "//*[@class='footer']//*[contains(text(),'My Account')]");
		
//		WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
//		username.sendKeys("automation@gmail.com");
		sendKeysToElement(driver, "//input[@id='email']", "automation@gmail.com");
		
//		WebElement password = driver.findElement(By.xpath("//*[@id='pass']"));
//		password.sendKeys("123");
		sendKeysToElement(driver, "//*[@id='pass']", "123");
		
//		WebElement buttonLogin = driver.findElement(By.xpath("//*[@id='send2']"));
//		buttonLogin.click();
		clickToElements(driver, "//*[@id='send2']");
		
	//	WebElement messPassword = driver.findElement(By.xpath("//*[@id='advice-validate-password-pass']"));
		String errPassword = getTextElements(driver, "//*[@id='advice-validate-password-pass']");
		Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.", errPassword);
	}

	@Test (enabled = false) //Create an account
	public void TC_04() {
		openURL(driver, "http://live.guru99.com/index.php/customer/account/");
		
//	WebElement accountCreate = driver.findElement(By.xpath("//*[@title='Create an Account']"));
//	accountCreate.click();
		clickToElements(driver, "//*[@title='Create an Account']");
	
//	WebElement firstName = driver.findElement(By.xpath("//*[@id='firstname']"));
//	firstName.clear();
//	firstName.sendKeys("A");
		clearTextInElement(driver, "//*[@id='firstname']");
		sendKeysToElement(driver, "//*[@id='firstname']", "A");
//	
//	WebElement middleName = driver.findElement(By.xpath("//*[@id='middlename']"));
//	middleName.clear();
//	middleName.sendKeys("Van");
		clearTextInElement(driver, "//*[@id='middlename']");
		sendKeysToElement(driver, "//*[@id='middlename']", "Van");
	
//	WebElement lastName = driver.findElement(By.xpath("//*[@id='lastname']"));
//	lastName.clear();
//	lastName.sendKeys("Tran");
		clearTextInElement(driver, "//*[@id='lastname']");
		sendKeysToElement(driver, "//*[@id='lastname']", "Tran");
	
//	WebElement emailAddress = driver.findElement(By.xpath("//*[@id='email_address']"));
//	emailAddress.clear();
//	emailAddress.sendKeys("smartphone"+randomEmail()+"@gmail.com");
		clearTextInElement(driver,"//*[@id='email_address']");
		sendKeysToElement(driver, "//*[@id='email_address']", "smartphone"+randomEmail()+"@gmail.com");
		
//	WebElement newPassword = driver.findElement(By.xpath("//*[@id='password']"));
//	newPassword.clear();
//	newPassword.sendKeys("123456");
		clearTextInElement(driver, "//*[@id='password']");
		sendKeysToElement(driver, "//*[@id='password']", "123456");
	
//	WebElement confirmPassword = driver.findElement(By.xpath("//*[@id='confirmation']"));
//	confirmPassword.clear();
//	confirmPassword.sendKeys("123456");
		clearTextInElement(driver, "//*[@id='confirmation']");
		sendKeysToElement(driver, "//*[@id='confirmation']", "123456");
		
//	WebElement registerBtn = driver.findElement(By.xpath("//*[@id='form-validate']//*[@title='Register']"));
//	registerBtn.click();
		clickToElements(driver, "//*[@id='form-validate']//*[@title='Register']");
	
//	WebElement thankyouMessage = driver.findElement(By.xpath("//*[contains(text(),'Thank you for registering with Main Website Store.')]"));
//	String mess = thankyouMessage.getText();
	
	Assert.assertEquals("Thank you for registering with Main Website Store.", getTextElements(driver, "//*[contains(text(),'Thank you for registering with Main Website Store.')]"));
}
	
	@Test (enabled = true) //Order a product successfully
	public void TC_05() throws InterruptedException {
//		driver.get("http://live.guru99.com/index.php/customer/account/");
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		openURL(driver, "http://live.guru99.com/index.php/customer/account/");
		
//		WebElement accountLink = driver.findElement(By.xpath("//*[@class='footer']//*[contains(text(),'My Account')]"));
//		accountLink.click();
		clickToElements(driver, "//*[@class='footer']//*[contains(text(),'My Account')]");
		
//		WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
//		username.sendKeys("smartphone8888@gmail.com");
		sendKeysToElement(driver, "//input[@id='email']", "smartphone8888@gmail.com");
		
//		WebElement password = driver.findElement(By.xpath("//*[@id='pass']"));
//		password.sendKeys("123456");
		sendKeysToElement(driver, "//input[@id='email']", "smartphone8888@gmail.com");
		
//		WebElement buttonLogin = driver.findElement(By.xpath("//*[@id='send2']"));
//		buttonLogin.click();
		clickToElements(driver, "//*[@id='send2']");
		
//		WebElement mobileButton = driver.findElement(By.xpath("//*[@id='nav']//*[text()='Mobile']"));
//		mobileButton.click();
		clickToElements(driver, "//*[@id='nav']//*[text()='Mobile']");
		
//		WebElement addtoCartSSGalaxy = driver.findElement(By.xpath("//*[@title='Samsung Galaxy']//following-sibling::div//*[@class='button btn-cart']"));
//		addtoCartSSGalaxy.click();
		clickToElements(driver, "//*[@title='Samsung Galaxy']//following-sibling::div//*[@class='button btn-cart']");
		
//		WebElement messageSSGalaxy = driver.findElement(By.xpath("//*[@class='success-msg']//*[contains(text(),'Samsung Galaxy was added to your shopping cart.')]"));
//		String mess1 = messageSSGalaxy.getText() ;
		Assert.assertEquals("Samsung Galaxy was added to your shopping cart.", getTextElements(driver, "//*[@class='success-msg']//*[contains(text(),'Samsung Galaxy was added to your shopping cart.')]"));
				
//		WebElement discountCode = driver.findElement(By.xpath("//*[@id='coupon_code']"));
//		discountCode.sendKeys("GURU50");
		sendKeysToElement(driver, "//*[@id='coupon_code']", "GURU50");
		
//		WebElement applyButton = driver.findElement(By.xpath("//*[@title='Apply']"));
//		applyButton.click();
		clickToElements(driver, "//*[@title='Apply']");
		
//		WebElement messageGuru = driver.findElement(By.xpath("//*[@class='success-msg']//*[contains(text(),'Coupon code \"GURU50\" was applied')]"));
//		String mess2 = messageGuru.getText() ;
		Assert.assertEquals("Coupon code \"GURU50\" was applied.", getTextElements(driver, "//*[@class='success-msg']//*[contains(text(),'Coupon code \"GURU50\" was applied')]"));
		
//		WebElement grandTotal = driver.findElement(By.xpath("//*[@class='price']"));
//		String total = grandTotal.getText();
		Assert.assertEquals("$130.00", getTextElements(driver, "//*[@id='shopping-cart-totals-table']//tfoot//span[@class='price']"));
		
//		WebElement numberOfItem = driver.findElement(By.xpath("//*[@id='shopping-cart-table']/input"));
//		String item = numberOfItem.getText();
		Assert.assertEquals("1", getTextElements(driver, "[//input[contains(@title,'Qty')]"));
		Thread.sleep(3000);
//		WebElement emptyCart = driver.findElement(By.xpath("//*[@id='empty_cart_button']"));
//		emptyCart.click();
		clickToElements(driver, "//*[@id='empty_cart_button']");
	}
	
	@Test (enabled=false)
	public void TC_06() {
		//precondition TC_04
		openURL(driver, "http://live.guru99.com/index.php/customer/account/");
		clickToElements(driver, "//*[@title='Create an Account']");
		clearTextInElement(driver, "//*[@id='firstname']");
		sendKeysToElement(driver, "//*[@id='firstname']", "A");
		clearTextInElement(driver, "//*[@id='middlename']");
		sendKeysToElement(driver, "//*[@id='middlename']", "Van");
		clearTextInElement(driver, "//*[@id='lastname']");
		sendKeysToElement(driver, "//*[@id='lastname']", "Tran");
		clearTextInElement(driver,"//*[@id='email_address']");
		sendKeysToElement(driver, "//*[@id='email_address']", "smartphone"+randomEmail()+"@gmail.com");
		clearTextInElement(driver, "//*[@id='password']");
		sendKeysToElement(driver, "//*[@id='password']", "123456");
		clearTextInElement(driver, "//*[@id='confirmation']");
		sendKeysToElement(driver, "//*[@id='confirmation']", "123456");
		clickToElements(driver, "//*[@id='form-validate']//*[@title='Register']");
		Assert.assertEquals("Thank you for registering with Main Website Store.", getTextElements(driver, "//*[contains(text(),'Thank you for registering with Main Website Store.')]"));
		//TC_06
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
