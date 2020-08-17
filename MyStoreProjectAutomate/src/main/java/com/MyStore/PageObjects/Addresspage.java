package com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.ActionDriver.Action;
import com.MyStore.BaseClass.BaseClass;

public class Addresspage extends BaseClass {
	
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedtocheckout;
	
	

	
	public Addresspage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	
	
	public Shippingpage clickoncheckout()
	{
		Action.click(getDriver(), proceedtocheckout);
		return new Shippingpage();
	}

	
 
} 
