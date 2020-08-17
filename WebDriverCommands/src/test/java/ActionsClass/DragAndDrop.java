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

public class DragAndDrop {
	
	
	public WebDriver driver;

	
	@BeforeMethod
		
		public void setup() throws Exception
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			driver.get("https://demoqa.com/droppable/");
			Thread.sleep(2000);
			
		}


	
	@AfterMethod

	public void teardown() throws Exception
	{
		driver.close();
		
		Thread.sleep(2000);

	}


	
	@Test
	
	public void draganddrop() throws Exception
	{
		WebElement from  =driver.findElement(By.id("draggable"));
		WebElement to  =driver.findElement(By.id("droppable"));

		Actions act = new Actions (driver);
		
		act.dragAndDrop(from, to).perform();
		Thread.sleep(2000);

		
	}
	
@Test
	
	public void draganddropby() throws Exception
	{
		WebElement from  =driver.findElement(By.id("draggable"));
		WebElement to  =driver.findElement(By.id("droppable"));

		Actions act = new Actions (driver);
		//act.dragAndDropBy(from, 135, 22).perform();
		act.clickAndHold(from)
		.moveToElement(to)
		.release()
		.build()
		.perform();
		
		WebElement message =driver.findElement(By.xpath("//div/p[text()='Dropped!']"));
		if(message.isDisplayed())
		{
			System.out.println("successfully dropped");
		}
		else
		{
			System.out.println("not succesfully dropped");
		}
		Thread.sleep(3000);

		
	}
	
}
