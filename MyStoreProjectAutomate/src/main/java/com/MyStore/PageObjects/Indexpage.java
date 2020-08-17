package com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.ActionDriver.Action;
import com.MyStore.BaseClass.BaseClass;

public class Indexpage extends BaseClass {
	
	//Signin button 
	
	@FindBy(xpath="//a[@class='login']")
	
	WebElement signInBtn;
	
   //logo 
	@FindBy(xpath="//img[@class='logo img-responsive']")
	
	WebElement MystoreLogo;
	
	
	//seaerchBoxTab
	
	@FindBy(id="search_query_top")
	WebElement searchproductBox;
	
	//searchBoxButton
	@FindBy(name="submit_search")
	WebElement searchButton;

	// constructor for Index page
	public Indexpage()
	{
		//PageFactory is a class
		PageFactory.initElements(getDriver(), this);
	}

	
	
	public Loginpage clickOnSignIn()
	{
		Action.click(getDriver(), signInBtn);
		return new Loginpage();
	}
	
	
	public boolean validatelogo()
	{
		return Action.isDisplayed(getDriver(), MystoreLogo);
	}
	
	public String getMystoreTitle()
	{
		String mystoretitle1= getDriver().getTitle();
		return mystoretitle1;
	}
		
	public SearchResultpage searchProduct(String productname) throws InterruptedException
	{
		Action.type(searchproductBox, productname);
		Action.click(getDriver(), searchButton);
		Thread.sleep(2000);
		return new SearchResultpage();
	}

}
