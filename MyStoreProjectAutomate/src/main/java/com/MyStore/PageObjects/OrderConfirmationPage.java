package com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.ActionDriver.Action;
import com.MyStore.BaseClass.BaseClass;

public class OrderConfirmationPage  extends BaseClass {
	
	
	
	
	@FindBy(xpath="//div/p/strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement orderiscompletemessage;
	
	
	public OrderConfirmationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public String validateconfirmmessage()
	{
		String confirmmessage=orderiscompletemessage.getText();
		return confirmmessage;
	}

}
