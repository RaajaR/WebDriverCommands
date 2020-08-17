package com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.ActionDriver.Action;
import com.MyStore.BaseClass.BaseClass;

public class SearchResultpage extends BaseClass{
	
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	WebElement productresult;
	
	 
	public SearchResultpage()
	{
		PageFactory.initElements(getDriver(), this);
	}

	
	
	public boolean isproductAvailable()
	{
		return Action.isDisplayed(getDriver(), productresult);
	}
	
	public AddToCartpage clickonProduct()
	{
		Action.click(getDriver(), productresult);
		return new AddToCartpage();
	}
	
	
}
