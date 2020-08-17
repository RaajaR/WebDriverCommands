package com.MyStore.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.BaseClass.BaseClass;
import com.MyStore.PageObjects.AddToCartpage;
import com.MyStore.PageObjects.Addresspage;
import com.MyStore.PageObjects.Indexpage;
import com.MyStore.PageObjects.Loginpage;
import com.MyStore.PageObjects.OrderConfirmationPage;
import com.MyStore.PageObjects.OrderSummary;
import com.MyStore.PageObjects.Orderpage;
import com.MyStore.PageObjects.PaymentPage;
import com.MyStore.PageObjects.SearchResultpage;
import com.MyStore.PageObjects.Shippingpage;

public class EndToEndTest  extends BaseClass {
	
	

	Indexpage indexpage;
	SearchResultpage searchresultpage;
	AddToCartpage addtocarpage;
	Orderpage orderpage;
	Loginpage loginpage;
	Addresspage addresspage;
	Shippingpage shiipingpage;
	PaymentPage paymenpage;
	OrderSummary ordesummary;
	OrderConfirmationPage orderconfpage;
	
	
	
	
	
	
	
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
   public void EndtoEndTest() throws Exception
   {
	  
	   indexpage= new Indexpage();
	   searchresultpage= indexpage.searchProduct("t-shirt");
	   addtocarpage= searchresultpage.clickonProduct();
	   addtocarpage.enterQuantity("2");
	   addtocarpage.selectrsize("s");
	   addtocarpage.clickonAddtocart();
	   orderpage= addtocarpage.clickonproceedtocheckout(); 
	   loginpage=  orderpage.clickoncheckout();
	   addresspage = loginpage.login1(prop.getProperty("username"),prop.getProperty("password"));
	   shiipingpage= addresspage.clickoncheckout();
	   shiipingpage.clickonterms(); 
	   paymenpage=shiipingpage.clickonproceedtocheckoutShiipingpage();
	   ordesummary=   paymenpage.clickonpaymentmethod();
	   orderconfpage= ordesummary.clickonconfirmmyorder();
	   String actualmessage =orderconfpage.validateconfirmmessage();
	   String Expmessage=  "Your order on My Store is complete.";
	  Assert.assertEquals(actualmessage, Expmessage);
	   
	   
	   
   }
   
   
   
   
   
   
   
}
