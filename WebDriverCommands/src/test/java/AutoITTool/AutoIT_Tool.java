package AutoITTool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoIT_Tool {
	
	

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
		driver.get("http://the-internet.herokuapp.com/basic_auth");
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\USER\\OneDrive\\Desktop\\auto it\\authenticate.exe");
		Thread.sleep(2000);
		
	}

	
	@Test
	
	public void autoittool() throws Exception
	{
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\USER\\OneDrive\\Desktop\\auto it\\authenticate.exe");
		Thread.sleep(2000);
		
	}
	
@Test
	
	public void autoittool_otherway() throws Exception
	{
		Thread.sleep(2000);
		//Sysntax:
		//driver.get("http://username:password@testthe-internet.herokuapp.com/basic_auth");
		driver.get("http://admin:admin@testthe-internet.herokuapp.com/basic_auth");

		Thread.sleep(2000);
		
	}
	
	@AfterMethod

	public void teardown() throws Exception
	{
		driver.close();
		
		Thread.sleep(4000);

	}
	
	
	
}
