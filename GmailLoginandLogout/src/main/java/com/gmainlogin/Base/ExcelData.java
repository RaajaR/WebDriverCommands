package com.gmainlogin.Base;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelData {
	
	@Test
	 public void readExcel() throws Exception {
	  
	  String excelPath="C:\\Users\\USER\\OneDrive\\Desktop\\Gmail\\GmailLoginandLogout\\Testdata\\LoginData.xlsx";
	  String fileName="LoginData";
	  String sheetName="input";
	  //Create the object of File Class to get the excel path
	  File file= new File(excelPath);
	  //To read the file
	  FileInputStream fis= new FileInputStream(file);
	  XSSFWorkbook wb= new XSSFWorkbook(fis);
	  XSSFSheet sheet=wb.getSheet(sheetName);
	  //Get Total Rows in Excel Sheet
	  int rowCount=sheet.getLastRowNum();
	  System.out.println("Total Rows: "+(rowCount+1));
	  //Print a particular cell value
	  String data=sheet.getRow(0).getCell(1).getStringCellValue();
	  System.out.println("Particular cell value: "+data);
	  
	  //Loop to print all values of the excel sheet
	  for(int i=0; i<=rowCount;i++) {
	   Row row=sheet.getRow(i);
	   for(int j=0; j<row.getLastCellNum();j++) {
	    String data1=sheet.getRow(i).getCell(j).getStringCellValue();
	    System.out.print(data1+" ");
	   }
	   System.out.println();
	  }
	  wb.close();
	}
}
