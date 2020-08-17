package ActionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {
	
	
public WebDriver driver;

	
	@BeforeMethod
		
		public void setup() throws Exception
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
			Thread.sleep(2000);
			
		}


	
	@AfterMethod

	public void teardown() throws Exception
	{
		driver.close();
		
		Thread.sleep(2000);

	}

	
	@Test
	
	public void mousehover() throws Exception
	{
		driver.findElement(By.id("user_login")).sendKeys("opensourcecms");
		driver.findElement(By.id("user_pass")).sendKeys("opensourcecms");
        driver.findElement(By.id("wp-submit")).click();
		
        Actions act = new Actions(driver);
		WebElement mouse =driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a"));
		act.moveToElement(mouse).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='wp-admin-bar-logout']/a")).click();
		
	}
	
	
	
	

}
