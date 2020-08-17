package com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.ActionDriver.Action;
import com.MyStore.BaseClass.BaseClass;

public class Shippingpage extends BaseClass {
	
	
	@FindBy(id="cgv")
	WebElement terms;
	
	@FindBy(xpath="//*[@id=\"form\"]/p/button/span")
	WebElement proceedtocheckoutShiipingpage; 
	
	public Shippingpage()
	{
		PageFactory.initElements(getDriver(), this);
	}

	
	public void clickonterms()
	{
		Action.fluentWait(getDriver(), terms, 10);
		Action.click(getDriver(), terms);
	}
	
	public PaymentPage clickonproceedtocheckoutShiipingpage()
	{
		
		Action.fluentWait(getDriver(), proceedtocheckoutShiipingpage, 10);

		Action.rightclick(getDriver(), proceedtocheckoutShiipingpage);
		return new PaymentPage();
	}

}
