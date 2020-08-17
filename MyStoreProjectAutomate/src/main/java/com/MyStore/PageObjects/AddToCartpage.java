package com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.ActionDriver.Action;
import com.MyStore.BaseClass.BaseClass;

public class AddToCartpage extends BaseClass{
	
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(name="group_1")
	WebElement size;
	
	@FindBy (xpath="//span[text()='Add to cart']")
	WebElement addtocatbutton;
	
	@FindBy(xpath=" //*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	WebElement Addtocartmessage;
	
	
	@FindBy(xpath="//span[contains (text(),'Proceed to checkout')]")
	WebElement proceedtocartbutton;
	
	
	
	public AddToCartpage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String quantity1 )
	{
		Action.type(quantity, quantity1);
	}
	
   public void selectrsize(String size1)
   {
	   Action.selectByVisibleText(size1, size);
   }
   
   
   public void clickonAddtocart()
   {
	   Action.click(getDriver(), addtocatbutton);
   }
   
   public boolean validateAddtocart()
   {
	   Action.fluentWait(getDriver(), Addtocartmessage, 10);
	   return Action.isDisplayed(getDriver(), Addtocartmessage);
   }
   
   public Orderpage clickonproceedtocheckout()
   {
	   Action.fluentWait(getDriver(), proceedtocartbutton, 10);
	   Action.JSClick(getDriver(), proceedtocartbutton);
	   return new Orderpage();
   }
   

   
}
