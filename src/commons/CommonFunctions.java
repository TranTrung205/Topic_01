package commons;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class CommonFunctions {

	public void openURL(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void clearTextInElement (WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
	}

	public void sendKeysToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	public void clickToElements(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public String getTextElements(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public void selectToElement(WebDriver driver, String locator, String value) {
		Select element = new Select(driver.findElement(By.xpath(locator)));
		element.selectByVisibleText(value);
	}

	public String getFirstSelectedOption(WebDriver driver, String locator) {
		
		Select element = new Select(driver.findElement(By.xpath(locator)));
		return element.getFirstSelectedOption().getText();
	}
	
	public String getAtribute(WebDriver driver, String locator, String attribute) {
		  WebElement element = driver.findElement(By.xpath(locator));
		  return element.getAttribute(attribute);
		 }
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public boolean isSelected(WebDriver driver,String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}
	
	public boolean isEnabled(WebDriver driver,String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}
	
	public boolean isDisplayed(WebDriver driver,String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	/* ********************JAVASCRIPT******************** */
	
	public void JavaScriptclickElements(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public String javaScriptGetDomain(WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		return executor.executeScript("return document.domain").toString();
		
	}
	
	public String javaScriptGetUrl(WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		return executor.executeScript("return document.URL").toString();
	}
	
	public String getInnerTextJavascript(WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		return executor.executeScript("return document.documentElement.innerText").toString();
	}
	
	public String getTitleJavascript(WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		return  executor.executeScript("return document.title").toString();
	}
	
	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void navigateToAnothePageJavascript(WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.location = string ");
	}
	
	/* ********************Windows******************** */
	public void parentWindowID(WebDriver driver) {
		String parentID = driver.getWindowHandle();
	}
	
	public void switchToWindowByID(WebDriver driver, String parent) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
                    if (!runWindow.equals(parent)) {
                                driver.switchTo().window(runWindow);
                                break;
                    }
        }
	}
	
	public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
                    driver.switchTo().window(runWindows);
                    String currentWin = driver.getTitle();
                    if (currentWin.equals(title)) {
                                break;
                    }
        }
}
	
	 public boolean closeAllWithoutParentWindows(WebDriver driver,String parentWindow) {
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
	/* ********************iFRAME******************** */
	public void switchToiFrame(WebDriver driver, String locator) {
		WebElement element= driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
		
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/* ********************ALERT******************** */
	public void switchToAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
	}
	public String getTextAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void acceptAlert (WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void dissmissAlert (WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void sendkeysToAlert(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}
	/* ********************HOVER******************** */
	public void hoverMouse(WebDriver driver, String locator) {
	WebElement element = driver.findElement(By.xpath(locator));
	Actions hover = new Actions(driver);
	hover.moveToElement(element).perform();
	
	}
	/* ********************UPLOAD BY SENDKEY******************** */
	public void uploadFileBySendkeys(WebDriver driver, String locator,String pathFile) {
	WebElement element = driver.findElement(By.xpath(locator));
	element.sendKeys(pathFile);
	}
	/* ********************UPLOAD BY ROBOT******************** */
	public void uploadFileByRobot(WebDriver driver, String pathFile, String locator) throws AWTException {
		//Specify the file location with extension
		StringSelection select = new StringSelection(pathFile);

		//Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		//Click
		driver.findElement(By.className(locator)).click();

		Robot robot = new Robot();
	

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
/*

executeJavascriptToElement(WebDriver driver, String locator)

waitForControlPresence(WebDriver driver, String locator)

waitForControlVisible(WebDriver driver, String locator)

waitForControlClickable(WebDriver driver, String locator)

waitForControlInvisible(WebDriver driver, String locator)

waitForAlertPresence(WebDriver driver)





*/
	
	public void quit(WebDriver driver) {
		driver.quit();
	}
}
