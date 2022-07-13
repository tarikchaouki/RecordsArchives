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

public class LoginTest extends BaseClass{
	       
	     LoginPage loginPage ;
	     HomePage homePage ;
	     Logger log =  LogManager.getLogger(LoginTest.class.getName());
	    
	  
    @BeforeMethod
	public void SecondSetUp() throws IOException {
     
		 initializeBrowser();
	         log.info("browser got launched");
		 System.out.println("test1");
		
		 System.out.println("hey there");
               }
   
        
    @Test
    public void loginPageTitleVald() {
    	
        String Title = driver.getTitle();
        Assert.assertEquals(Title,"Login page");
        log.info("get the right title ");
    	
        }
    
    @Test
    public void loginTest () throws InterruptedException {
    	   loginPage = new LoginPage();
    	   homePage = loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
    	   log.info("Clicked on Enter button");
    	  
    	   String ActualTitle = driver.getTitle();
      	   String ExpectedTitle = "Index";
        	   
        	   if(ActualTitle.equals(ExpectedTitle)) {
        		   Assert.assertTrue(true);
        		   log.info("User logged in successufully");}
     }
    

	
     
}
