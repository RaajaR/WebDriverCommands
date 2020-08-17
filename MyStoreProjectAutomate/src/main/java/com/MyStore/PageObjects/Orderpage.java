package com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.ActionDriver.Action;
import com.MyStore.BaseClass.BaseClass;

public class Orderpage extends BaseClass {
	
	
	
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	WebElement unitprice;
	
	@FindBy(xpath=" //span[@id='total_price']")
	WebElement totalprice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedtocheckout;
	
	public Orderpage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	
	public double  getunitprice()
	{
		String unitprice1=unitprice.getText();
		String unit=unitprice1.replaceAll("[^a-zA-z0-9]","");
		double finalunitprice=Double.parseDouble(unit);
		return finalunitprice/100;
		
	}
	
	public double  gettotalprice()
	{
		String totalprice1=totalprice.getText();
		String toatl=totalprice1.replaceAll("[^a-zA-z0-9]","");
		double fianltoatlprice =Double.parseDouble(toatl);
		return fianltoatlprice/100;
		
	}	
	public Loginpage clickoncheckout()
	{
		Action.click(getDriver(), proceedtocheckout);
		return new Loginpage();
	}

	
	
}
