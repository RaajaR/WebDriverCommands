package gmail;

	import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class gmailTest {
		public static WebDriver driver;

		{

		}
		static
		{
		System.setProperty("webdriver.chrome.driver", "./DriverPath/chromedriver.exe");

		}

		@Test(priority=1)
		public  void ReadData()throws InterruptedException
		{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement username = driver.findElement(By.xpath("//input[@type='email']"));
		username.sendKeys("raaja8500@gmail.com");

		//  driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		       driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();        

		WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
		Thread.sleep(1000);

		pwd.sendKeys("M@r3145893");

		//  driver.findElement(By.xpath("//span[.='Next']")).click();
		       driver.findElement(By.xpath("//*[@id=\'passwordNext\']/div/button/div[2]")).click();

		Thread.sleep(500);

		//  driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		//inbox
		// driver.findElement(By.xpath("//*[@id=\':ks\']/div/div[2]/span/a")).click();
		driver.findElement(By.linkText("Inbox")).click();

		List<WebElement> unreademail = driver.findElements(By.className("zE"));



		System.out.println("Total No. of Unread Mails: " + unreademail.size());

		// real logic starts here

		for(int i=0;i<unreademail.size();i++){

		System.out.println(unreademail.get(i).getText());

		}

		unreademail.get(0).click();

		Thread.sleep(3000);
		Thread.sleep(4000);
		 /* Compose email */
		 driver.findElement(By.xpath("//div[@class='z0']/div")).click();

		 /* Enter email details */
		 Thread.sleep(3000);
		driver.findElement(By.xpath("//td//img[2]")).click();
		 driver.findElement(By.className("vO")).sendKeys("bidtester7@gmail.com");
		 driver.findElement(By.className("aoT")).sendKeys("This is Subject Line");
		 
//	driver.findElement(By.xpath("/html/body/div[23]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[1]/div[2]/div[1]/div/table/tbody/tr/td[2]/div[2]/div")).click(); 

		
		driver.findElement(By.xpath("//*[@id=\":se\"]")).sendKeys("This is body");
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@tabindex='1']")));

		 
		/*
		* driver.switchTo().frame(driver.findElement(By.
		* className("Am Al editable LW-avf tS-tW")));
		* driver.findElement(By.id(":u7")).sendKeys("Hi"); WebElement printbody =
		* driver.switchTo().activeElement(); Thread.sleep(3000);
		* printbody.sendKeys("Hi,This is the Assignmnet");
		* driver.switchTo().defaultContent();
		*/
		// driver.findElement(By.xpath("//div[text()='Send']")).click();
		//driver.findElement(By.xpath("//*[@id=\':ro\']")).click();
		 
		/*
		 * WebElement body =
		 * driver.findElement(By.className("Am Al editable LW-avf tS-tW"));
		 * body.sendKeys("hi welcome");
		 */
		  Thread.sleep(2000);
		//  driver.findElement(By.xpath("//div[@text()='send']")).click();
		    
		// driver.findElement(By.xpath( "//*[@id=\'gb\']/div[2]/div[3]/div[1]/div[2]/div/a/img")).click(); // To
		
		//  click the sign out button
		  
		 // driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click(); // To click the
		
		  // flyout menu
		  driver.findElement(By.xpath("/html/body/div[31]/div/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[1]/div/div[2]/div[1]")).click();
		  
		  Thread.sleep(500);
		 
		 
		 driver.findElement(By.xpath("//*[@id=\'gb\']/div[2]/div[3]/div[1]/div[2]/div/a/img")).click();
		 driver.findElement(By.linkText("Sign out")).click();
		driver.close();
		
		}  

	}



