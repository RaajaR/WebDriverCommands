package com.MyStore.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.BaseClass.BaseClass;
import com.MyStore.PageObjects.Homepage;
import com.MyStore.PageObjects.Indexpage;
import com.MyStore.PageObjects.Loginpage;
import com.MyStore.utilities.Log;

public class LoginpageTest  extends BaseClass {
	
	Indexpage indexpage ;
	Loginpage loginpage;
	Homepage homepage;
	

	@BeforeMethod
	public void setup()
	{
	     
		
		launchApp();
	}
	
   @AfterMethod 
   public void teardown()
   {
	   getDriver().quit();
   }
	
   
   @Test
   
   public void logintest()
   {
	   Log.startTestCase("loginTest");
	   indexpage = new  Indexpage();
	   Log.info("user is going to click on signin");
	   loginpage = indexpage.clickOnSignIn();
	   Log.info("enter username and password to signin");
	   homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	    
	   String actualhomepageURL=homepage.getcurrURL();
	   String ExpectedhomepageURL="http://automationpractice.com/index.php?controller=my-account";
	   Log.info(" verify user is able login");
	  Assert.assertEquals(actualhomepageURL, ExpectedhomepageURL);
   }

}
