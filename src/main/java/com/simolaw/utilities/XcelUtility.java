package com.simolaw.utilities;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.simolaw.base.BaseClass;

public class XcelUtility extends BaseClass{
	
	
	public FileInputStream fi; 
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public File excel;
	    
	       @DataProvider(name="CreateAccount")
	     public String[][] getData()throws Exception {
	    	 
	    	 excel = new File("./resources/SimoLawExcelSheets.xlsx");
	    	 fi=new FileInputStream(excel);
	 		 workbook=new XSSFWorkbook(fi);
	 		 sheet=workbook.getSheet("Sheet1");
	 		 int NumOfRow = sheet.getPhysicalNumberOfRows();
	 		 int NumOfCol = sheet.getRow(0).getLastCellNum();
	 		 
	 		 String [][] data = new String [NumOfRow-1][NumOfCol];
	 		  for (int i = 0; i < NumOfRow-1; i++) {
	 			  for  (int j = 0; j < NumOfCol; j++) {
	 				  DataFormatter df = new DataFormatter();
	 				  data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
					
				}
					
	           }
	 		  
	 		  workbook.close();
	 		  fi.close();
			return data;
		
			
	     }

}
