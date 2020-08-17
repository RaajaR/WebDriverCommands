package BaseSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseSuite {
	
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeSuite
	public void setUp(String browserType)
	{
		System.out.println("** Before Suite ***");
		String path = System.getProperty("user.dir");
		if(browserType.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver",path+"//Lib//chromedriver");
			this.driver = new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("Firefox") ){
			System.setProperty("webdriver.firefox.driver",path+"//Lib//geckodriver");
			this.driver = new FirefoxDriver();
		}
		
	
		this.driver.get("https://www.timeanddate.com");
		this.driver.manage().window().maximize();
		System.out.println("** End of Before Test ***");
	}
	
	@AfterSuite
	public void close(){
		System.out.println("*** After Suite ***");
		driver.quit();
	}
	
	
	
}
