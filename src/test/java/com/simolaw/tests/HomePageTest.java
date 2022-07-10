package com.simolaw.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.simolaw.base.BaseClass;
import com.simolaw.pageobjects.HomePage;
import com.simolaw.pageobjects.LoginPage;

public class HomePageTest extends BaseClass{
	
	
	LoginPage loginPage;
    HomePage homePage = new HomePage(); 
    Logger log =  LogManager.getLogger(LoginTest.class.getName());
   
    
    @BeforeMethod
	public void SetUp() throws Throwable{
		
		 initializeBrowser();
	     loginPage = new LoginPage();
	     System.out.println("hello");
		
        }
    //  code test for home page title
	@Test
    public void HomePageTitleValid() throws InterruptedException  {
		
		// loginPage = new LoginPage();
		 homePage = loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		 System.out.println("test2");
	   String ActualTitle = homePage.validate_HomePageTitle();
  	   String ExpectedTitle = "Index";
    	   
    	   if(ActualTitle.equals(ExpectedTitle)) {
    		   Assert.assertTrue(true);
    		   log.info("User logged in successufully");}
    	 
    	
    }
	
	
	
   

}
