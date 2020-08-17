package com.MyStore.BaseClass;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.MyStore.ActionDriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//public static WebDriver driver;
	public static Properties prop;
	public static ThreadLocal<RemoteWebDriver>driver=new ThreadLocal<>();
	
	
	
	@BeforeSuite
	
	public void beforesuite()
	{
		DOMConfigurator.configure("log4j.xml");
		 
	}
	
	public static WebDriver getDriver()
	{
		// Get driver from ThreadLocal
		return driver.get();
	}
	
	
	@BeforeTest
	public  void loadConfig() 
	{
	
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Configurations\\config.properties");
			prop.load(ip);

		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static void launchApp()
	{
		String browserName =prop.getProperty("Browser");
	
		if (browserName.equalsIgnoreCase("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
		///driver=new ChromeDriver();
			driver.set(new ChromeDriver());
		} 
		else if (browserName.equalsIgnoreCase("FireFox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			driver.set(new FirefoxDriver());

		} 
		else if (browserName.equalsIgnoreCase("IE")) 
		{
			WebDriverManager.iedriver().setup();
			//driver=new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
     Action.implicitWait(getDriver(), 10);
     Action.pageLoadTimeOut(getDriver(), 30);
     getDriver().get(prop.getProperty("url"));
}
}
