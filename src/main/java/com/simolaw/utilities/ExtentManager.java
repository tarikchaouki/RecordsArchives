package com.simolaw.utilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.simolaw.base.BaseClass;

public class ExtentManager extends BaseClass{
	    
      ExtentReports extentReport;
	
      public static ExtentSparkReporter SparkReporter;
      public static ExtentReports extent; 
      public static ExtentTest test;
       
      public static void setExtent() throws IOException  {
       
      SparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
   
	  //SparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	
       SparkReporter.config().setDocumentTitle("Automation Test Report");
       SparkReporter.config().setReportName("Simo Law Test Automation Report");
       SparkReporter.config().setTheme(Theme.DARK);
       
       extent = new ExtentReports();
       extent.attachReporter(SparkReporter);
       
       extent.setSystemInfo("HostName", "MyHost");
       extent.setSystemInfo("ProjectName", "Simo Law");
       extent.setSystemInfo("Tester", "Tarik");
       extent.setSystemInfo("OS", "Win11");
       extent.setSystemInfo("Browser", "Chrome");
      }
      public static void endReport() {
       extent.flush();
      }


}
