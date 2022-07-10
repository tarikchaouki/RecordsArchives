package com.simolaw.tests;



import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.simolaw.base.BaseClass;
import com.simolaw.pageobjects.CreateAccountPage;
import com.simolaw.pageobjects.HomePage;
import com.simolaw.pageobjects.LoginPage;
import com.simolaw.utilities.XcelUtility;

public class CreateAccountTest extends BaseClass{
	
	   
	LoginPage loginPage;
    HomePage homePage ;
    CreateAccountPage CreateAccPage ;
	
    @BeforeTest
	public void SetUp() throws IOException, InterruptedException{
    	
		 initializeBrowser();
		 
		 loginPage = new LoginPage();
		 homePage = loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		 CreateAccPage= new CreateAccountPage();
		 System.out.println("test3");
		 
        }
   //@Test
    public void ClickOnMaintianUser() throws InterruptedException {
    	
    	CreateAccPage= homePage.MaintainUserTab();
    	CreateAccPage.X(); 
    	
    }
    
    
  @Test(dataProvider="CreateAccount" ,dataProviderClass = XcelUtility.class)
    public  void CreateNewAccount(String FName,String LName,String PHoneNum,String PWD) throws Exception{
    	
    	CreateAccPage= homePage.MaintainUserTab(); 
    	CreateAccPage.CreateNewAccount(FName,LName,PHoneNum,PWD);
    
    	String ActualText= CreateAccPage.UserCreated();
    	System.out.println(ActualText);
    	
    	String ExpectText="UserCreated";
        if(ActualText.equals(ExpectText)) {
    		Assert.assertTrue(true);
    		              }
    	else {
    		Assert.assertTrue(false);
    	}
    	
    }
    
   @AfterTest
    public void Closure() {
    	driver.quit();
    }

}
