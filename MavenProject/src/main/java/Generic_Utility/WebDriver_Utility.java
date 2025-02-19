package Generic_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//WebDriver Utility Libraries
//
//	WebdriverUtility  is a Generic class , which contains webdriver specific reusable actions like
//	waitForPageToLoad()
//	waitForElement()
//	select()
//	accpetAlert()
//	cancelAlert()  .Etc


public class WebDriver_Utility {
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void waitForVisibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}
	
	public void switchToAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void moveToElement(WebDriver driver, WebElement ele) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement ele) {
		Actions act=new Actions(driver);
		act.doubleClick(ele).perform();
	}
	
	public void select(WebElement ele, int index) {
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}
	
	public void select(WebElement ele, String Value) {
		Select sel = new Select(ele);
		sel.selectByValue(Value);
	}
	
	public void select(String VisibleText, WebElement ele) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(VisibleText);
	}
	
	public void takeScreenshotOfWebPage(WebDriver driver, 
			String ssName) throws IOException { 
			  TakesScreenshot tks= (TakesScreenshot) driver; 
			  File src = tks.getScreenshotAs(OutputType.FILE); 
			  File dest= new 
			File("./errorShots/"+ssName+".png"); 
			  FileHandler.copy(src, dest);
			 } 
	
	//switching windows
	
	public void switchingWindows(WebDriver driver,String particalTitle)
	{
		Set<String> allWins1 = driver.getWindowHandles();
		Iterator<String> it1 = allWins1.iterator();

		while (it1.hasNext()) {
			String win1 = it1.next();
			driver.switchTo().window(win1);
			String title1 = driver.getTitle();
			if (title1.contains(particalTitle)) {
				break;
			}
		}
	}

	public void maximizingWindow1(WebDriver driver) {
		driver.manage().window().maximize();
		
	
	} 
}
