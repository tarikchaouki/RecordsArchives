package com.simolaw.utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestUtil{

	public static long IMPLICIT_WAIT = 10;
	public static long PAGE_LOAD_TIMEOUT = 10;
	
	
	
	public static boolean Isdisplayed(WebElement ele) {
		 
		  boolean e = ele.isDisplayed();
		 
		  return e;
		
		}
	
	public static boolean IsEnabled(WebElement ele) { 
		 
		  boolean e = ele.isEnabled();
		  
		  return e;
		
		}
	
	public void SelectOptionsFromDrDwn(WebElement Ele,String Value) {
		
		Select Drp = new Select (Ele);
		List <WebElement> AllOptions = Drp.getOptions();
		
		for (WebElement Option : AllOptions) {
			if(Option.getText().equals(Value)) {
				Option.click();
				break;
			}
			
		}
		
	}
	
}
