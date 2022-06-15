package generic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


public class WebDriverCommonLib extends BaseTest {
	public String getTheTitleOfWebPage() {
		
		String titleOfTheWebPage = driver.getTitle();
		return titleOfTheWebPage;
	}
	
	public void verifyThePageTitle(String expectedTitle,String pageName)
	{
	String actualTitle = driver.getTitle();
	if(expectedTitle.equals(actualTitle))
	{
		System.out.println(pageName+"is verified");
	}
	else
	{
		System.out.println(pageName+"is not verified");
	}
	
	}
	//mouse actions 
	public void mouseHover(WebElement target)

	{
		Actions act = new Actions (driver);
		act.moveToElement(target).perform();
	}
	
	public void rightClick(WebElement target)

	{
		Actions act = new Actions (driver);
		act.contextClick(target).perform();
	}
	

	public void doubleClick(WebElement target)

	{
		Actions act = new Actions (driver);
		act.doubleClick(target).perform();
	}
	
	public void dragAndDrop(WebElement src,WebElement  target)

	{
		Actions act = new Actions (driver);
		act.dragAndDrop(src,target).perform();
	}
	//handle the frame
	
	public void switchToFrame(int index)
	{ 
		driver.switchTo().frame(index);
		
	}
	
	public void switchToFrame(String nameOrld)
	{ 
		driver.switchTo().frame(nameOrld);
		
	}

	
	public void switchToFrame(WebElement frameElement) 
	{
		driver.switchTo().frame(frameElement);
	}


	//handling dropdown

	public void selectTheOption(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}


	public void selectTheOption(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void selectTheOption(String visibleText,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByValue(visibleText);
	}


	public void getAllOptionsOfDropdown(WebElement element)
	{
		Select sel = new Select(element);
		List<WebElement> ops = sel.getOptions();

		for(WebElement option:ops)
		{
			String text = option.getText();
			System.out.println(text);
		}

	}


	public void explicitlyWait(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.titleContains(title));
	}

	//To perform Scroll Operations

	public void scrollRight(int pixels)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+pixels+",0)");
	}


	public void scrollLeft(int pixels)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+-pixels+",0)");
	}


	public void scrollDown(int pixels)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+pixels+")");
	}

	public void scrollUp(int pixels)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+-pixels+")");
	}


	public void scrollTillPerticularWebELement(WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Point point = element.getLocation();
		int xaxis = point.getX();
		int yaxis = point.getY();

		jse.executeScript("window.scrollBy("+xaxis+","+yaxis+")");
	}
	
	
	//To take the screenshot
	
	public void takeTheScreensHotOfWebpage(String fileName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(SCREENSHOT_PATH+fileName+".png");
		Files.copy(src, dest);
	}
	
	
	//accep the alert popup
	
	public void acceptAlertPopup()
	{
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	
	public void acceptConfirmationPopup()
	{
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	
	public void dismissConfirmationPopup()
	{
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}
	
	public String getTheWindowHandle()
	{
		String parentHandle = driver.getWindowHandle();
		return parentHandle;
		
	}
	
	public void getTheWindowHandles()
	{
		Set<String> handles = driver.getWindowHandles();
		
		for(String h:handles)
		{
			System.out.println(h);
			
		}
			
	}
	
	public void refreshTheBrowser()
	{
		driver.navigate().refresh();
	}

}
	

