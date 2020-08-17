package Trivagotestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Trivago_Com.Basecalss;
import Trivago_Com.Loginpage;
public class Loginpagetetscase extends Basecalss {
	
	
	Loginpage obj = new Loginpage();
	
	@BeforeMethod
	
	public void launchapp() throws Exception
	{
		setup();
}
	
	@AfterMethod
	
	public void teradown()
	{
		driver.quit();
	}
	
	@Test
	public void enetrEmaildata() throws Throwable
	{
		
		obj.enetrEmail();
		
	}
	
	@Test
	public void clickonnextbutton() throws InterruptedException
	{
		obj.clcikenter();
	}
	
	@Test
	public void enetrthepassword() throws InterruptedException
	{
		obj.enetrpassword();
	}
	
	@Test
	public void enetrregisterbutton() throws InterruptedException
	{
		obj.clickregister();
	}
}
