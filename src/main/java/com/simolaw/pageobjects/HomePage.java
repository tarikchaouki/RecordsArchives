package com.simolaw.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.simolaw.base.BaseClass;
import com.simolaw.utilities.TestUtil;

public class HomePage extends BaseClass{
	
	             TestUtil testUtil = new TestUtil() ;
	             JavascriptExecutor js = (JavascriptExecutor)driver;
	      
	             @FindBy(linkText="Home")    WebElement HomeLink;
	             @FindBy(xpath="//a[contains(text(),'Maintain Users')]")WebElement MaintainUsers;
	
	      
	      //constructor
	      public HomePage() {
	    	  
	    	  PageFactory.initElements(driver,this);
	      }
	       
	      
	       
	      public String validate_HomePageTitle() {
	     	 
	    	  return driver.getTitle();
		     
	      }
         
	      public void ValidateHomeLink() {
	    	  
	    	  TestUtil.Isdisplayed(HomeLink);
	    	  
	       }
	     
	      public CreateAccountPage MaintainUserTab()  {
	    	 
	    	   TestUtil.Isdisplayed(MaintainUsers);
	           js.executeScript("arguments[0].click();",  MaintainUsers);
	    	   return new CreateAccountPage();
	     }
}
