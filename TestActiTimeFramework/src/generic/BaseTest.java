package generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;



public class BaseTest	implements IAutoConstant {
		protected WebDriver driver;
		//BeforeMethod
		public void setup() throws IOException
		{
			Flib flib = new Flib();
			
			String browserValue = flib.readPropertyFile(PROP_PATH,"browser");
			String url = flib.readPropertyFile(PROP_PATH, "url");
			if(browserValue.equalsIgnoreCase("chrome"))
			{
				System.setProperty(CHROME_KEY,CHROME_VALUE);
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);	
				driver.get(url);
			}

			else if(browserValue.equalsIgnoreCase("firefox"))
			{
				System.setProperty(GECKO_KEY,GECKO_VALUE);
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);	
				driver.get(url);
			}

			else
			{
				System.out.println("enter the correct choice");
			}


		}

	@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}


		
}
