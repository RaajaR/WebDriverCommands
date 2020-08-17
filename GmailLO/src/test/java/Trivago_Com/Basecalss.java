package Trivago_Com;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basecalss {
	
	public static Properties prop;
	public static WebDriver driver;
	
	
@BeforeTest

public static void loadconfig() throws Exception
{
	prop = new Properties();
	System.out.println("properties invoked");
	String filepath="C:\\Users\\USER\\OneDrive\\Desktop\\Gmail\\GmailLO\\configurations\\config.properties";
	FileInputStream file = new FileInputStream(filepath);
	prop.load(file);
}


	public  static void setup() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
	
		{
			
			WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
	     }
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.chromedriver().setup();

			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("IE"))
		{
			WebDriverManager.chromedriver().setup();

			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("please check ur browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get("https://access.trivago.com/oauth/en-IN/login");		
	}	
		}	



