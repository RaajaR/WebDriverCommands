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

public class DoubleClick {
	
	public WebDriver driver;

	@BeforeMethod
	
	public void setup() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");
		Thread.sleep(2000);
		
	}

	@AfterMethod

	public void teardown() throws Exception
	{
		driver.close();
		
		Thread.sleep(2000);

	}

	@Test
	
	public void doubleclick() throws Exception
	{
	   WebElement doubleclickbtn =driver.findElement(By.id("doubleClickBtn"));
	   Actions act = new Actions(driver);
	   act.doubleClick(doubleclickbtn).perform();
	   System.out.println("double clicked ");
		Thread.sleep(2000); 
	   driver.switchTo().alert().accept();
		Thread.sleep(2000);

	   
	}

	
	@Test
	
	public void rightclick()throws Exception
	{
		WebElement rightclickbtn = driver.findElement(By.id("rightClickBtn"));
		
		Actions act = new Actions(driver);
		act.contextClick(rightclickbtn).perform();
		Thread.sleep(2000); 

	}
}
