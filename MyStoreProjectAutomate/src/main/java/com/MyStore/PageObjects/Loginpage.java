/**
 * 
 */
package com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.ActionDriver.Action;
import com.MyStore.BaseClass.BaseClass;

/**
 * @author Raaja
 *
 */
public class Loginpage  extends BaseClass{
	
	//username for sigin
	
	@FindBy(id="email")
	WebElement 	username1;
	
	//Password for sigin

	@FindBy(name="passwd")
	WebElement 	password1;

	//signinbutton  for sigin

	@FindBy(id="SubmitLogin")
	WebElement siginbutton;
	
	//Email button for registration
	
	@FindBy(name="email_create")
	WebElement emailForNewAccount;
	
	//create an account button

	@FindBy(id="SubmitCreate")
	WebElement CreateanAccountbutton;
	
	
	
	public Loginpage()
	{
		//PageFactory is a class
		PageFactory.initElements(getDriver(), this);
	}

	
	
	public Homepage login(String uname,String pwd)
	{
		Action.type(username1, uname);
		Action.type(password1, pwd);
        Action.click(getDriver(), siginbutton);
        return new  Homepage();
	}
	
	public Addresspage login1(String UName,String PWD)
	{
		Action.type(username1, UName);
		Action.type(password1, PWD);
		Action.click(getDriver(), siginbutton);
		return new Addresspage();
	}
	public AccountCreationpage createnewAccount(String newEmail)
	{
		Action.type(emailForNewAccount, newEmail);
		Action.click(getDriver(), CreateanAccountbutton);
		return new AccountCreationpage();
	}
	

	 
}
