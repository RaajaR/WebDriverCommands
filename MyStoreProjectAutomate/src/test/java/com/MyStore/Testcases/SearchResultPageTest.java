package com.MyStore.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.BaseClass.BaseClass;
import com.MyStore.PageObjects.Homepage;
import com.MyStore.PageObjects.Indexpage;
import com.MyStore.PageObjects.Loginpage;
import com.MyStore.PageObjects.SearchResultpage;

public class SearchResultPageTest extends BaseClass  {
	
	
	Indexpage indexpage;
	Loginpage loginpage;
	Homepage homepage;
	SearchResultpage searchresultpage;

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
   public void productAvailabilityTest() throws InterruptedException
   {
	   indexpage = new Indexpage();
	   searchresultpage= indexpage.searchProduct("t-shirt");
	   boolean result=searchresultpage.isproductAvailable();
	   Assert.assertTrue(result);
	    
   } 
}
