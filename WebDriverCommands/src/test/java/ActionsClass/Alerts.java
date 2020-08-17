package ActionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	
	
	public static WebDriver driver;

	//https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html
	
	@BeforeMethod
	
	public void setup() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");
		Thread.sleep(2000);
		
	}


	@Test(priority=1)

	
	public void simpleAlert() throws Exception
	{
		driver.findElement(By.id("simpleAlert")).click();
		
		Alert alert = driver.switchTo().alert();
		//String alerttext=alert.getText();
		//System.out.println(alerttext);
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);

	}

 
	@Test(priority=2)
	
	public void ConfirmationAlert() throws Exception
	{
		driver.findElement(By.id("confirmationAlert")).click();
		Alert alert1 = driver.switchTo().alert();
		
		String value1 = alert1.getText();
		 System.out.println(value1);
			Thread.sleep(2000);

		alert1.dismiss();
		Thread.sleep(2000);
       


	}
	
	@Test(priority = 3)

	
	public static boolean checkAlertExistsorNot() throws InterruptedException
	{
		try 
		{
		driver.findElement(By.id("confirmationAlert")).click();
		Alert alert1 = driver.switchTo().alert();
		
		String value2 = alert1.getText();
		 System.out.println(value2);
			Thread.sleep(2000);

		alert1.accept();
		Thread.sleep(2000);
		
	   }
	
		catch(NoAlertPresentException e)
		{
			e.getMessage();
		}
		return false;
	}
	
	
	@Test(priority = 4)

	
	public void promptAlert() throws Exception
	{
		driver.findElement(By.id("promptAlert")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);

		alert.sendKeys("Yes");
		Thread.sleep(2000);

		alert.accept();
		Thread.sleep(2000);

		
	}
	
	@AfterMethod

public void teardown() throws Exception
{
	driver.close();
	
	Thread.sleep(2000);

}



}
