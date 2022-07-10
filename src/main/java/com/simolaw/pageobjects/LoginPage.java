package com.simolaw.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.simolaw.base.BaseClass;
import com.simolaw.utilities.TestUtil;

public class LoginPage extends BaseClass{
	
	
	 TestUtil testUtil = new TestUtil() ;
	 // Actions action = new Actions(driver);
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	    
	@FindBy(xpath="//input[@id='tynamoLogin']")           WebElement username;
	@FindBy (xpath="//input[@id='tynamoPassword']")       WebElement password ;
	@FindBy (xpath="//input[@id='tynamoEnter']")          WebElement loginBtn;
	@FindBy(xpath="//label[contains(text(),'Login')]")    WebElement usernameLabel;
	@FindBy(xpath="//label[contains(text(),'Password')]") WebElement passwordLabel; 
	  
	
	     public LoginPage() {
	    	 
		    PageFactory.initElements(driver,this);
		    
	        }
	     
   
	public String validate_LoginPageTitle() {
    	      
		       return driver.getTitle();
		   
		    }
	
	public HomePage Login(String un,String pwd) throws InterruptedException {
		
	//	TestUtil.Isdisplayed(usernameLabel);
		Thread.sleep(2000);
		username.sendKeys(un);
	    TestUtil.Isdisplayed(passwordLabel);
		password.sendKeys(pwd);
		System.out.println(TestUtil.IsEnabled(loginBtn));
		Thread.sleep(2000);
		//action.moveToElement(loginBtn).build().perform();
		Thread.sleep(2000);
		//loginBtn.click();
    	 js.executeScript("arguments[0].click();", loginBtn);
		
    	
		return new HomePage();
	}
	
   
	
	
}




