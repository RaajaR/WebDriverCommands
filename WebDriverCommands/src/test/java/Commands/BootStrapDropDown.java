package Commands;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropDown {
	

	public WebDriver driver;

	
@BeforeMethod
	
	public void setup() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.get("https://www.automationtestinginsider.com/2019/12/bootstrap-dropdown-example_12.html");
		Thread.sleep(2000);
		
	}


   @AfterMethod

   public void teardown() throws Exception
   {
	driver.close();
	
	Thread.sleep(2000);

   }


    @Test

   public void Bootstrapdropdown() throws Exception

    {
    	
	driver.findElement(By.xpath("//button[@id='bootstrapmenu']")).click(); 
	List<WebElement>dropdowm =driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));
	Thread.sleep(2000);
	
	for(WebElement ele:dropdowm )
	{
		String value= ele.getText();
		System.out.println(value);
		
		if(value.equalsIgnoreCase("CONTACT US"))
		{
			ele.click();
			break;
		}
		
			
	}
}






}
