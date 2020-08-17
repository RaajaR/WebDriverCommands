package com.MyStore.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.BaseClass.BaseClass;
import com.MyStore.PageObjects.AddToCartpage;
import com.MyStore.PageObjects.Indexpage;
import com.MyStore.PageObjects.SearchResultpage;

public class AddToCartpageTest extends BaseClass {
	
	
	Indexpage indexpage;
	SearchResultpage searchresultpage;
	AddToCartpage addtocarpage;
	
	
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
   public void addtocartpage() throws InterruptedException
   {
	   indexpage = new Indexpage();
	   searchresultpage= indexpage.searchProduct("t-shirt");
	   addtocarpage= searchresultpage.clickonProduct();
	   addtocarpage.enterQuantity("2");
	   addtocarpage.selectrsize("s");
	   addtocarpage.clickonAddtocart();
	  boolean result = addtocarpage.validateAddtocart();
	  Assert.assertTrue(result);
   }
}
