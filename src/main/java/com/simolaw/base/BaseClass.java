package com.simolaw.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.simolaw.utilities.ExtentManager;
import com.simolaw.utilities.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	 
    
	public static  WebDriver driver;
	public static Properties prop ;
    
	
	  
	  
	
     @BeforeSuite
    public static void Base() {
            
    	   // ExtentManager.setExtent();
    
       try {
	  
	    prop = new Properties();
		String propertiesPath = System.getProperty("user.dir")+"\\src\\main\\java\\com\\simolaw\\properties\\data.properties";
		FileInputStream fis = new FileInputStream(propertiesPath);
		prop.load(fis);
       }catch (FileNotFoundException e){
    	   e.printStackTrace();
       }catch (IOException e){
    	  e.printStackTrace(); 
       }
       
       }   
    
   
       
	    
		public static void  initializeBrowser() throws IOException {
		       
		  String browserName = prop.getProperty("browser");
		
		  if(browserName.equalsIgnoreCase ("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		    }else if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		   }else if(browserName.equalsIgnoreCase("ie")) {
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		   }
			driver.manage().window().maximize();
			//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
		    }
		
		    public static String screenShot(WebDriver driver,String filename) {
			 
		      String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			  TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			  File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			  String destination = System.getProperty("user.dir")+"\\ScreenShot\\"+filename+"_"+dateName+".png";
			  File finalDestination= new File(destination);
			  try {
			   FileUtils.copyFile(source, finalDestination);
			  } catch (Exception e) {
			  
			   e.getMessage();
			  }
			  return destination;
			 }
			 
			 public static String getCurrentTime() {  
			     String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());  
			     return currentDate;  
			 }  
			 
			 
			      @AfterSuite
			    public void AfterSuite() {
			    // ExtentManager.endReport();
			      driver.quit();
			    }
}
