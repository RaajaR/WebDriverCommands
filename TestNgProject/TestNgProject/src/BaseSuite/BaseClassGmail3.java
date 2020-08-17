package BaseSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassGmail3 {
	
	public WebDriver driver;
	
	@Test
	public void setup() throws Exception
	{
		System.out.println("browser Launching method");
	
		//System.setProperty("webdriver.chrome.driver","");
		//Instantiate the driver
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();

         driver.manage().window().maximize();

         String url = "https://accounts.google.com/signin";

         driver.get(url);

         driver.findElement(By.id("identifierId")).sendKeys("umavaanukuri@gmail.com"); 

         //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);      

         WebDriverWait wait=new WebDriverWait(driver, 20);               

         driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();         

         driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);        

         driver.findElement(By.name("password")).sendKeys("7019525079");             

         driver.findElement(By.xpath("//*[@id=\'passwordNext\']/div/button/div[2]")).click();
         driver.findElement(By.xpath("//*[@id=\'gbwa\']/div/a/svg")).click();
         Thread.sleep(3000);
         driver.findElement(By.xpath("//*[@id=\'yDmH0d\']/c-wiz/div/div/c-wiz/div/div/ul[1]/li[7]/a/div[5]/span")).click();
         Thread.sleep(3000);

		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
}