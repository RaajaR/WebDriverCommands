package com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.ActionDriver.Action;
import com.MyStore.BaseClass.BaseClass;

public class AccountCreationpage extends BaseClass {
	
	
	@FindBy(xpath="//h1[@class='page-heading']")
	WebElement formTitle;
	
	
	public AccountCreationpage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyAccountcreationpage()
	{
		return Action.isDisplayed(getDriver(), formTitle);
		
		
	}

}
