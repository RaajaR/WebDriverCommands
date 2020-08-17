package Commands;


import java.util.ArrayList;
import java.util.Collections;
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

public class DropDrownList_2ndWay {
	
	public WebDriver driver;
	
	//https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
	
	//This is second way to check dropdown 
	@BeforeMethod
		
		public void setup() throws Exception
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
			Thread.sleep(2000);
}
	
	
	@Test
	
	public void Multidropdown() throws Exception
	{
		WebElement multiselect=driver.findElement(By.xpath("//select[@id='multi-select' and @name='States']"));
		Select selectmultiselect = new Select(multiselect);
		
		//System.out.println(selectmultiselect.getOptions());
		
		selectmultiselect.selectByIndex(0);
		
		selectmultiselect.selectByValue("Florida");
		Thread.sleep(3000);

		selectmultiselect.selectByVisibleText("New Jersey");
		Thread.sleep(3000);

	//	selectmultiselect.deselectAll();
	//	selectmultiselect.selectByVisibleText("New Jersey");
	//	Thread.sleep(3000);

		// comapre Actual and Expected list
		
				List<String> expList = new ArrayList<>();
				
				expList.add("California");
				
				expList.add("New Jersey");
				expList.add("Florida");
				
				List<String> ActList = new ArrayList<>();
				
		//How to get AllOptions
				
		List<WebElement> selectmultiselct= selectmultiselect.getAllSelectedOptions();
		
		for(WebElement ele : selectmultiselct)
		{
			ActList.add(ele.getText());
			System.out.println(ele.getText());
		}
		
		// to resolve the order change when comapred to actual and Expected
		
		Collections.sort(expList);
		Collections.sort(ActList);

		boolean result =ActList.equals(expList);
		System.out.println("the result of comparision is : " + result);
		
		
	}
	
	@AfterMethod

	public void teardown() throws Exception
	{
		driver.close();
		
		Thread.sleep(2000);

	}

}