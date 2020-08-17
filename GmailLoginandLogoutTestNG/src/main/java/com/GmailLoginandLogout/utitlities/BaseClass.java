package com.GmailLoginandLogout.utitlities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.GmailLoginandLogout.utitlities.ExcelReadingMethods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	
	
	String appURL="";
	String inputfilename = "C:\\Users\\USER\\OneDrive\\Desktop\\Gmail\\GmailLoginandLogout\\Testdata\\LoginData.xlsx";
	String sheetname = "sheet1";
	
	// data provider will return username and password
	@Test(dataProvider = "userdata")
	
	public void toLogin(String username,String password ) throws Exception
	{
		System.out.println("login Method");
		System.out.println("username is :" + username);
		System.out.println("password is :" + password);
		driver.navigate().to("https://accounts.google.com/signin");
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(username);
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[2]")).click();
	//	driver.findElement(By.cssSelector("html body#yDmH0d.tQj5Y.ghyPEc.IqBfM.ecJEib.EWZcud.EIlDfe.cjGgHb.d8Etdd.LcUz9d c-wiz.yip5uc.SSPGKf c-wiz div.rTY96b.UeUy4d div.p9lFnc div.SJIPZc div div div.ZRg0lb.Kn8Efe div div.cdy0Yb div.yKBrKe div.U26fgb.O0WRkf.zZhnYe.C0oVfc.Zrq4w.NTcbm.RHAxtb.M9Bg4d div.ZFr60d.CeoRYc")).click();
		System.out.println("Alert flag is :" + alertExist());
		
		if(alertExist()==true)
		{
			System.out.println("alert is present");
			driver.switchTo().alert().accept();
	        Thread.sleep(3000);
	        System.out.println("alert is closed");
	        Assert.assertTrue(true);	
		}
		else
		{
			System.out.println("in Else");
	        Thread.sleep(3000);

	}

      	
	}
	
	
	public boolean alertExist()
	{
		boolean alertflag = false;
		try
		{
			driver.switchTo().alert();
			alertflag= true;
			
		}
		catch (NoAlertPresentException e) 
		{
			e.getMessage();
		}
		return alertflag;
	}
	
	@BeforeTest
	
	public void setup()
	{
		System.out.println("browser Launching method");
	
		//System.setProperty("webdriver.chrome.driver","");
		//Instantiate the driver
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		// maximize the driver
		driver.manage().window().maximize();
		//delete all cookies
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(appURL);
		
		
	}
	
	@AfterTest
	
	public String[][] teardown() throws Exception
	{
		System.out.println("in tera down Method");
		if(driver!=null)
		{
		driver.close();
		driver.quit();
	}

		//4 
	  getData();
	
	{
		System.out.println("In to get data method");
		int rowcount = ExcelReadingMethods.getrowcount(inputfilename, sheetname);
		System.out.println("Rowcount is :" + rowcount);
		
		
		int cellcount = ExcelReadingMethods.getcelldata(inputfilename, sheetname,0);
		System.out.println("Rowcount is :" + cellcount);
		
		// to store create 2 dimensioal string array
		
		String logindata[][] = new String[rowcount][cellcount];
		// Iterate rows
		
		for(int row=1;row<logindata.length;row++)
		{
			// Iterate columns
			for(int cell=0;cell<cellcount; cell++)
			{
				logindata [row-1][cell]=ExcelReadingMethods.getcelldata(inputfilename, sheetname, row, cell);
			}

		}
         
		   return logindata;
	}
}


	private void getData() {
		// TODO Auto-generated method stub
		
	}


	

	
}
