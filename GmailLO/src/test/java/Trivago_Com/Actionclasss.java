package Trivago_Com;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Actionclasss extends Basecalss{
	
	public static void scrollByvisibiltyofEleemnt(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argumnerts[0].scrollIntoview();",element );
	}
	
	public static void click(WebDriver idriver, WebElement locatorName)
	{
		Actions act = new Actions(idriver);
		act.moveToElement(locatorName).click().build().perform();
	}
	
	public static boolean findElement(WebDriver idriver,WebElement ele)
	{
		boolean flag = false;
		try
		{
			ele.isDisplayed();
			flag=true;
		}
		catch(Exception e)
		{
			flag=false;
			e.getMessage();
		}
		finally
		{
			if(flag)
			{
				System.out.println("succesfully find element at:");
			}
			else
			{
				System.out.println("unable to  find  element ");
			}
		}
		return flag;
	}
	
	
	
	public static  boolean isDisplayed(WebDriver idriver,WebElement ele)
	{
		boolean flag = false;
		if(flag)
		{
			flag =ele.isDisplayed();
			if(flag)
			{
				System.out.println("the element is displayed");
			}
			else
			{
				System.out.println("the element is not  displayed");
			}
		}
		else
		{
			System.out.println("not displayed");
		}
			return flag;	
	}
	
	
	public static boolean isSelected(WebDriver idriver,WebElement ele)
	{
		boolean flag = false;
		if(flag)
		{
			flag =findElement(idriver,ele);
			if(flag)
			{
			     flag= ele.isSelected();
			      if(flag)
			      {
			    	  System.out.println("ele is selected");
			      }
			      else
			      {
			    	  System.out.println("ele is not selected");
			      }
			}
			
			return flag;	
	}
		return flag;
	}
	
	public boolean isEnabled(WebDriver idriver,WebElement ele)
	{
		boolean flag = false;
		flag =findElement(idriver,ele);
		if(flag)
		{
		     flag= ele.isEnabled();
		      if(flag)
		      {
		    	  System.out.println("ele is Enabled");
		      }
		      else
		      {
		    	  System.out.println("ele is not Enabled");
		      }
		}

		else
		{
			System.out.println("Not Enabled");
		}

		return flag;
	}
	
	
	public static boolean type(WebElement ele,String text)
	{
		boolean flag = false;
		try
		{
			flag =ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
		}
		catch(Exception e)
		{
			flag=false;
			e.getMessage();
			System.out.println("location not found");
		}
		finally
		{
			if(flag)
			{
				System.out.println("succesfully entered value");
			}
			else
			{
				System.out.println("unable to enter the value");
			}
		}
		return flag;

	}
	
	
	public static boolean selectBysendkeys(WebElement ele,String value)
	{
		boolean flag = false;
		
		try
		{
			ele.sendKeys(value);
			flag=true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}

		finally
		{
			if(flag)
			{
				System.out.println("select value from dropdown");
			}
			else
			{
				System.out.println("Not select value from dropdown");
			}
		}
	}
	
	
	public static boolean selectByIndex(WebElement element,int index)
	{
		boolean flag = false;
		try
		{
			Select s = new Select(element);
			s.selectByIndex(index);
			flag=true;
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag)
			{
				System.out.println("option selcted by Index");
			}
			else
			{
				System.out.println("option  not selcted by Index");

			}
		}
	}
		
	public static boolean selectByvalue(WebElement element,String value)
	{
		boolean flag = false;
		try
		{
			Select s = new Select(element);
			s.selectByValue(value);
			flag=true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag)
			{
				System.out.println("option not selcted by vlaue");
			}
			else
			{
				System.out.println("option selcted by Index");
			}
		}

	}
	
	public static boolean selectByvisisbleText(String visibletext ,WebElement ele)
	{
		boolean flag = false;
		try
		{
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag=true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}

		finally
		{
			if(flag)
			{
			System.out.println(" option selected by visisble text");
		}
			else
			{
				System.out.println(" option  notselected by visisble text");

			}
	}
		
	}

	
	
	
	
	}
	


