 package ActionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tooltip_ATI {
	
	public WebDriver driver;

	
	@BeforeMethod
		
		public void setup() throws Exception
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			driver.get("https://www.automationtestinginsider.com/search/label/drag%20and%20drop%20in%20selenium");
			Thread.sleep(2000);
			
		}


	
	@AfterMethod

	public void teardown() throws Exception
	{
		driver.close();
		
		Thread.sleep(2000);

	}


	@Test
	
	public void tooltip()
	{
          WebElement searchbox = driver.findElement(By.xpath("//input[@class='gsc-input']"));
         String value = searchbox.getAttribute("title");
         System.out.println("Tooltip text is : " + value);
          
	}
	

}
