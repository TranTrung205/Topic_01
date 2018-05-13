package Selenium;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.CommonFunctions;


public class TOPIC_9 extends CommonFunctions {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();

	}

	@Test()
	public void TC_01() throws Exception {
//		driver.get("http://www.helloselenium.com/2015/03/how-to-upload-file-using-sendkeys.html");
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		openURL(driver, "http://www.helloselenium.com/2015/03/how-to-upload-file-using-sendkeys.html");

//		WebElement fileInput = driver.findElement(By.xpath("//*[@name='uploadFileInput']"));
//		fileInput.sendKeys("C:\\xpath.jpg");
		
//		WebElement uploadbutton = driver.findElement(By.xpath("//*[@name='uploadFileButton']"));
//		uploadbutton.click();
		uploadFileBySendkeys(driver, "//*[@name='uploadFileInput']", "C:\\xpath.jpg");
		clickToElements(driver, "//*[@name='uploadFileButton']");
		
	}
	@Test(enabled = false)
	public void TC_02() throws Exception {
//		driver.get("http://www.helloselenium.com/2015/03/how-to-upload-file-using-sendkeys.html");
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		openURL(driver, "http://www.helloselenium.com/2015/03/how-to-upload-file-using-sendkeys.html");
		
		uploadFileByRobot(driver, "C:\\xpath.jpg", "//*[@name='uploadFileInput']");
		//StringSelection select = new StringSelection("C:\\xpath.jpg");

		//Copy to clipboard
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		//Click
//		driver.findElement(By.xpath("//*[@name='uploadFileInput']")).click();
//
//		Robot robot = new Robot();
//		Thread.sleep(1000);
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_V);
//		Thread.sleep(1000);
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);


		
	}
	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

	public int randomEmail() {
		Random rand = new Random();
		int value = rand.nextInt(99999999);
		return value;
	}

}
