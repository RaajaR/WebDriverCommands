package com.MyStore.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.BaseClass.BaseClass;
import com.MyStore.PageObjects.Indexpage;

public class IndexpageTest extends BaseClass {
	
	Indexpage indexpage ;
	
	
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
   
   public void verifylogo()
   {
	   indexpage = new  Indexpage();
	  boolean result= indexpage.validatelogo();
	  Assert.assertTrue(result);
   }
   
  
   
}
