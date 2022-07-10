package com.simolaw.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.simolaw.base.BaseClass;
import com.simolaw.utilities.TestUtil;

public class CreateAccountPage extends BaseClass {
	
	 TestUtil testUtil = new TestUtil() ;
	 Actions action = new Actions(driver);
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	
	 @FindBy(xpath="//input[@id='username']")WebElement Newemail;
	 @FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/form[1]/div[5]/div[1]/input[1]")WebElement Fname;
	 @FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/form[1]/div[6]/div[1]/input[1]")WebElement Lname;
	 @FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/form[1]/div[7]/div[1]/input[1]")WebElement PhoneNum;
	 @FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/form[1]/div[10]/div[1]/input[1]")WebElement Pwd;
	 @FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/form[1]/div[11]/div[1]/input[1]")WebElement ConfirmPwd;
	 @FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/form[1]/div[14]/input[1]")WebElement CreateCustBTN;
	 @FindBy(xpath="//input[@id='checkUsername']")WebElement CheckAvaiUserName; 
	 @FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/form[1]/div[8]/div[1]/select[1]")WebElement UserTypeDrDwn; 
	 @FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/form[1]/div[9]/div[1]/select[1]")WebElement LawFirmDrDwn; 
	 @FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/form[1]/div[3]/font[1]")WebElement UserCreated;
	 
	 public CreateAccountPage() {
		   
		   PageFactory.initElements(driver,this);
		   
	   }
	 
	public void X () throws InterruptedException {
		   
		    Newemail.sendKeys("wtc@gmail.com");
		    //action.moveToElement(CheckAvaiUserName).build().perform();
		    js.executeScript("arguments[0].click();",  CheckAvaiUserName);
		    //CheckAvaiUserName.click();
	    	
             
	    	Thread.sleep(3000);
	    
			action.moveToElement(Fname).build().perform();
			 //js.executeScript("arguments[0].click();",  Fname);
		    Fname.sendKeys("ki");

		
	}
	 
	   
	   public void CreateNewAccount(String FName,String LName,String PHoneNum,String PWD) throws InterruptedException {
		   
		   
		   Thread.sleep(2000);
		   action.moveToElement(Newemail).build().perform();
		   Thread.sleep(3000);
		   Newemail.sendKeys("wc23@gmail.com");
		   Thread.sleep(2000);
		   action.moveToElement(CheckAvaiUserName).build().perform();
		  // js.executeScript("arguments[0].click();",  CheckAvaiUserName);
		    CheckAvaiUserName.click();
		  //  action.moveToElement(Fname).build().perform();
		   Thread.sleep(3000);
		   Fname.sendKeys(FName);
		   action.moveToElement(Lname).build().perform();
		   Lname.sendKeys(LName);
		   action.moveToElement(PhoneNum).build().perform();
		   PhoneNum.sendKeys(PHoneNum);
		   testUtil.SelectOptionsFromDrDwn(UserTypeDrDwn,"Agent");
		   testUtil.SelectOptionsFromDrDwn(LawFirmDrDwn, "Jdida Law");
		   Pwd.sendKeys(PWD);
		   ConfirmPwd.sendKeys(PWD);
		   CreateCustBTN.click();
		   Thread.sleep(2000);
		   action.moveToElement(UserCreated).build().perform();
		   }
	  
	   public String UserCreated() {
		  
		  
		   return UserCreated.getText();
		   
	   }
	   

}
 