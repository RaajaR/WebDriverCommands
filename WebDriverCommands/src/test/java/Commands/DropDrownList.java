package Commands;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDrownList {
	
	public WebDriver driver;

	
@BeforeMethod
	
	public void setup() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.get("https://www.automationtestinginsider.com/2019/08/student-registration-form.html");
		Thread.sleep(2000);
		
	}

@Test

public void selctdropdown() throws Exception
{
	WebElement bday= driver.findElement(By.id("Birthday_Day"));
	WebElement bmnth= driver.findElement(By.id("Birthday_Month"));
	WebElement byear= driver.findElement(By.id("Birthday_Year"));
	
	Select selectbday = new Select(bday);
	Select selectbmnth = new Select(bmnth);
	Select selectbyear = new Select(byear);
	selectbday.selectByIndex(3);
	Thread.sleep(2000);

	selectbmnth.selectByValue("February");
	Thread.sleep(2000);

	selectbyear.selectByVisibleText("1993");
	Thread.sleep(2000);

	WebElement getbday=selectbday.getFirstSelectedOption();
	WebElement getbmnth=selectbmnth.getFirstSelectedOption();
	WebElement getbyear=selectbyear.getFirstSelectedOption();
	System.out.println(getbday.getText()+ "_" + getbmnth.getText() + "_" + getbyear.getText() );
	
	List<WebElement >dateall=selectbday.getOptions();
	System.out.println("total dates :" + dateall.size() );
	List<WebElement >monthall=selectbmnth.getOptions();
	System.out.println("total months :" + monthall.size());

	List<WebElement >yearall=selectbyear.getOptions();
	System.out.println("total years :" + yearall.size());

	for(WebElement ele:dateall )
	{
		System.out.println(ele.getText());
		
	}
	
		for(WebElement ele1:monthall)
		{
			
			System.out.println(ele1.getText());
			
		}
			
			
		for(WebElement ele2:yearall)
			
		{
				System.out.println(ele2.getText( ));
				
			}
		}
	
	


@AfterMethod

public void teardown() throws Exception
{
	driver.close();
	
	Thread.sleep(2000);

}

}
