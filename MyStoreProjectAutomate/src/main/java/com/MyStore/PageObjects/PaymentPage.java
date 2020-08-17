package com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.ActionDriver.Action;
import com.MyStore.BaseClass.BaseClass;

public class PaymentPage extends BaseClass {
	
	
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement payBybankWire;
	
	@FindBy(xpath="//a[@class='cheque']")
	WebElement payByCheque;

	
	public PaymentPage()
	{
		PageFactory.initElements(getDriver(), this);
	}

	public OrderSummary  clickonpaymentmethod()
	{
		Action.click(getDriver(), payBybankWire);
		return  new OrderSummary();
	} 
	
}
