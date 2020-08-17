package ActionsClass;

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

public class KeyboardOperations {
	
	public WebDriver driver;

	
	//https://www.automationtestinginsider.com/p/blog-page.html
	
@BeforeMethod
	
	public void setup() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		
	}


  @AfterMethod

public void teardown()
{
	driver.close();
}
  
  
  
  @Test
  
  public void keyboardActions() throws Exception
  {
	  
	  WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
	  
	  Actions act = new Actions(driver);
	 Action action= act.keyDown(search, Keys.SHIFT)
	  .sendKeys("selenium")
	  .keyUp(search, Keys.SHIFT)
	  .keyDown(search, Keys.CONTROL)
	  .sendKeys("a")
	  .keyUp(search, Keys.CONTROL)
	  .sendKeys("x")
	  .keyDown(search, Keys.CONTROL)
	  .sendKeys("v")
	  .build();
	  action.perform();
	  Thread.sleep(2000);
	  
  }
}
