package com.GmailLoginandLogout.utitlities;

import java.io.File;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassGmail2 {
	
	public WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		System.out.println("browser Launching method");
	
		//System.setProperty("webdriver.chrome.driver","");
		//Instantiate the driver
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		ChromeOptions options = new ChromeOptions();

		// maximize the driver
		driver.manage().window().maximize();
		//delete all cookies
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	driver.get("https://accounts.google.com/signin");
		driver.get("https://accounts.google.com/");
}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}