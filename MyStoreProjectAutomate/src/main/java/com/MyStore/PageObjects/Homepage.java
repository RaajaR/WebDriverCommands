package com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.ActionDriver.Action;
import com.MyStore.BaseClass.BaseClass;

public class Homepage extends BaseClass {
	
	
	
	@FindBy(xpath="//span[text()='My wishlists']")
	WebElement myWishlist;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement myorderHistory;
	
	public Homepage()
	{
		//PageFactory is a class
		PageFactory.initElements(getDriver(), this);
	}

	
	public boolean validatemyWishlist()
	{
		return Action.isDisplayed(getDriver(), myWishlist);
		
	}
	
     public boolean validatemyorderHistory()
     {
    	 return Action.isDisplayed(getDriver(), myorderHistory);
    	 
     }
     
     public String getcurrURL()
     {
    	 String homepageurl=getDriver().getCurrentUrl();
    	 return homepageurl;
     }
}
