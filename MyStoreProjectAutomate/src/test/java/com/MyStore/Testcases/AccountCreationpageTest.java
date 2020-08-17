package com.MyStore.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.BaseClass.BaseClass;
import com.MyStore.PageObjects.AccountCreationpage;
import com.MyStore.PageObjects.Indexpage;
import com.MyStore.PageObjects.Loginpage;

public class AccountCreationpageTest extends BaseClass {
	
	Indexpage indexpage ;
	Loginpage loginpage;
	
	AccountCreationpage accountcreationpage;
	
	
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
   public void verifyVerifyCreateanAccount()
   {
	   indexpage = new Indexpage();
	   loginpage= indexpage.clickOnSignIn();
	   accountcreationpage = loginpage.createnewAccount("raaja888333@gmail.com");
	  boolean result= accountcreationpage.verifyAccountcreationpage();
	  Assert.assertTrue(result);
   }
   
   
   
   
   
}
