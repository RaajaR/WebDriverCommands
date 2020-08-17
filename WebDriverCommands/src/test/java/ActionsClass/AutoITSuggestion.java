 package ActionsClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITSuggestion {
	
	public WebDriver driver;

	
	@BeforeMethod
		
		public void setup() throws Exception
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			driver.get("https://www.google.co.in/");
			Thread.sleep(2000);
			
		}


	
	@AfterMethod

	public void teardown() throws Exception
	{
		driver.close();
		
		Thread.sleep(2000);

	}


	@Test
	
	public void tooltip() throws Exception
	{
       
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(2000);
		List<WebElement>list = driver.findElements(By.xpath("//ul/li[@class='sbct']"));
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			String search =list.get(i).getText();
			if(search.equals("selenium download"))
			{
				list.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}
	

}
