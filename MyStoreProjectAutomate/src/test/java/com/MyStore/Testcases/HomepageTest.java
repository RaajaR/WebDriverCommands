package com.MyStore.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.BaseClass.BaseClass;
import com.MyStore.PageObjects.Homepage;
import com.MyStore.PageObjects.Indexpage;
import com.MyStore.PageObjects.Loginpage;

public class HomepageTest extends BaseClass {
	
	
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
   public void verifyWhishlistTest()
   {
	   indexpage = new Indexpage();
	   loginpage= indexpage.clickOnSignIn();
	   homepage=  loginpage.login(prop.getProperty("username"), "password");
	   boolean result=homepage.validatemyWishlist();
	   Assert.assertTrue(result);
	   
	   
   }
   
   @Test
   public void verifyOrderHistoryTest()
   {
	   indexpage = new Indexpage();
	   loginpage= indexpage.clickOnSignIn();
	   homepage=  loginpage.login(prop.getProperty("username"), "password");
	   boolean result=homepage.validatemyorderHistory();
	   Assert.assertTrue(result);
	  
	   
   }

}
