package Trivago_Com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Loginpage extends Basecalss {
	
	
	
	

@FindBy(id="check_email")
WebElement Email;
	
@FindBy(id="login_email_submit")
WebElement nextbutton;

@FindBy(id="register_password")
WebElement password;                               

@FindBy(id="register_email_submit")
WebElement registeremail; 



public Loginpage()
{
	PageFactory.initElements(driver, this);
}

public  void  enetrEmail() throws Throwable
{
	Actionclasss.selectBysendkeys(Email, System.getProperty("username"));
	Thread.sleep(2000);
}


public void clcikenter() throws InterruptedException
{
	Actionclasss.click(driver, nextbutton);
	Thread.sleep(2000);

}


public void enetrpassword() throws InterruptedException
{
	Actionclasss.selectBysendkeys(password, System.getProperty("password"));
	Thread.sleep(2000);

}

public void  clickregister() throws InterruptedException
{
	Actionclasss.click(driver, registeremail);
	Thread.sleep(2000);

}


}


