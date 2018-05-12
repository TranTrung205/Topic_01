package Selenium;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TOPIC_7 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();

	}

	@Test(enabled=false)
	public void TC_01() throws Exception {
		driver.navigate().to("https://www.hdfcbank.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@id,'viz_iframe')]"));
		driver.switchTo().frame(iframe);

		WebElement textMsg = driver.findElement(By.xpath("//*[@id='messageText']"));
		Assert.assertEquals("What are you looking for?", textMsg.getText());
		driver.switchTo().defaultContent();
		
		WebElement textSearch = driver.findElement(By.xpath("//*[@placeholder='Search']"));
		textSearch.sendKeys("123123123");
		

	}
	
	@Test
	public void TC_02() throws Exception {
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement windowClick = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
		windowClick.click();

			String parentWindow = driver.getWindowHandle();
			switchToWindowByTitle("Google");
			
			Assert.assertEquals("Google", driver.getTitle());
			
			Thread.sleep(3000);
			closeAllWithoutParentWindows(parentWindow);
		

	}
	public void switchToWindowByTitle(String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
                    driver.switchTo().window(runWindows);
                    String currentWin = driver.getTitle();
                    if (currentWin.equals(title)) {
                                break;
                    }
        }
}
	
	 public boolean closeAllWithoutParentWindows(String parentWindow) {
         Set<String> allWindows = driver.getWindowHandles();
         for (String runWindows : allWindows) {
                     if (!runWindows.equals(parentWindow)) {
                                 driver.switchTo().window(runWindows);
                                 driver.close();
                     }
         }
         driver.switchTo().window(parentWindow);
         if (driver.getWindowHandles().size() == 1)
                    return true;
         else
                    return false;
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
