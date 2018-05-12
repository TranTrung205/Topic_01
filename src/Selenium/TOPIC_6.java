package Selenium;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TOPIC_6 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();

	}

	@Test (enabled = false)
	public void TC_01() throws Exception {
		driver.navigate().to("http://daominhdam.890m.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement hoverMeLink = driver.findElement(By.xpath("//*[contains(text(),'Hover over me')]"));
		Actions hover = new Actions(driver);
		hover.moveToElement(hoverMeLink).perform();
		Thread.sleep(3000);

		WebElement hooray = driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
		if (hooray.isDisplayed() == true)
			System.out.println("Hooray displayed" + hooray.getText());
		else
			System.out.println("Hooray undisplayed");

	}

	@Test
	public void TC_02() throws Exception {
		driver.navigate().to("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		List <WebElement> list = driver.findElements(By.xpath("//*[@id='selectable']/li"));
		Actions builder = new Actions(driver);
		builder.clickAndHold(list.get(0)).clickAndHold(list.get(11)).click().perform();

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
