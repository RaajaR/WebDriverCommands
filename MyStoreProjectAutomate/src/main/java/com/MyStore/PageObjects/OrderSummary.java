package com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.ActionDriver.Action;
import com.MyStore.BaseClass.BaseClass;

public class OrderSummary  extends BaseClass {
	
	
	@FindBy(xpath="//button/span[contains(text(),'I confirm my order')]")
	WebElement confirmmyorder;
	
	
	public OrderSummary()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickonconfirmmyorder()
	{
	    Action.click(getDriver(), confirmmyorder);
	    return new OrderConfirmationPage();
	}

}
