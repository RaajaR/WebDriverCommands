package ActionsClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelectAction {
	
public WebDriver driver;

	
	@BeforeMethod
		
		public void setup() throws Exception
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			driver.get("https://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html");
			Thread.sleep(2000);
			
		}


	
	@AfterMethod

	public void teardown() throws Exception
	{
		driver.close();
		
		Thread.sleep(2000);

	}

	@Test
	
	public void multipleselection() throws Exception
	{
		
		List<WebElement>list =driver.findElements(By.xpath("//select[@class='form-control pickListSelect pickData']/option"));
		
		Actions act = new Actions(driver);
	Action action=act.keyDown(Keys.CONTROL)
		.click(list.get(0))
		.click(list.get(1))
		.click(list.get(2))
		.click(list.get(3))
		.click(list.get(4))
		.click(list.get(5))
		.click(list.get(6))
		.click(list.get(7))
		.click(list.get(8))
		.click(list.get(9))
		.keyUp(Keys.CONTROL)
		.build();
	action.perform();
		
	driver.findElement(By.xpath("//div/button[text()='Add']")).click();
	Thread.sleep(3000);
		
	}	

}
