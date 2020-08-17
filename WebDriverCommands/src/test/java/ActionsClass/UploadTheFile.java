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

public class UploadTheFile {
	
	

	public static WebDriver driver;

	//https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html
	
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

	
	@Test
	
	public void normalWay() throws Exception
	{
		Thread.sleep(2000);
		Actions act = new Actions(driver);

       WebElement choosefile =driver.findElement(By.id("fileupload1"));
		act.moveToElement(choosefile).perform();
		Thread.sleep(2000);
		choosefile.sendKeys("C:\\Users\\USER\\OneDrive\\Desktop\\New Text Document.txt");
		Thread.sleep(4000);


	}
	

	@AfterMethod

	public void teardown() throws Exception
	{
		driver.close();
		
		Thread.sleep(4000);

	}
	
	
	
}
