package Commands;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton_CheckBox {
	
	public WebDriver driver;
	//  https://www.automationtestinginsider.com/2019/08/student-registration-form.html
	//  Student Registration Form
	
	//Radio button
	
	
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
	
	@Test(priority = 1)
	public void  radiobutton()throws Exception
	{
		WebElement radiobtn =driver.findElement(By.xpath("//input[@type='radio' and @value='Male']"));
		radiobtn.click();
		Thread.sleep(2000);
		boolean butnselect = radiobtn.isSelected();
		System.out.print(butnselect + "button is displayed ");

	}

	
	@Test (priority = 3)
	
	public void checkboxnormalWay() throws InterruptedException
	{
		WebElement chkbox = driver.findElement(By.xpath("//input[@type='checkbox' and @value='Drawing']"));
		chkbox.click();
		Thread.sleep(2000);

		boolean selectchkbox=chkbox.isSelected();
		System.out.print(selectchkbox );

		
	}
	
	
	@Test(priority = 2)
	
	public void checkboxdynamically() throws InterruptedException
	{
		List<WebElement> list = driver.findElements(By.xpath("//input[@type='checkbox' and @name='Hobby']"));
		for(int i=0;i<list.size();i++)
		{
			WebElement ele=list.get(i);
			String valuechkbox =ele.getAttribute("value");
			System.out.println("All the values are  : " + valuechkbox);
			if(valuechkbox.contains("Sketching"))
			{
				System.out.println(ele.getSize());
				ele.getText();
				ele.click();
				Thread.sleep(2000);
				break;
				
			}
			
		}
		

	}
	
	@AfterMethod
	
	public void teardown()
	{
		driver.close();
	}
}
