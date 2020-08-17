package com.GmailLoginandLogout.utitlities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingMethods {
	
	
	public static FileInputStream fileinputstream;
	public static FileOutputStream fileonputstream;
     public static XSSFWorkbook Workbook;
     public static XSSFRow row;
     public static XSSFSheet sheet;
     public static XSSFCell cell;
     
     // get rowcount  data of excel

   public static int  getrowcount(String filename,String sheetname) throws Exception
  
   {
	    fileinputstream = new FileInputStream(filename);
	    Workbook = new  XSSFWorkbook (fileinputstream);
	    sheet = Workbook.getSheet(sheetname);
        int rowcount =  sheet.getLastRowNum();
        Workbook.close();
        fileinputstream.close();
        return rowcount;
}

//get cell data 
   public static int  getcelldata(String filename,String sheetname,int rownum) throws Exception
   {
	   fileinputstream = new FileInputStream(filename);
	   Workbook = new  XSSFWorkbook (fileinputstream);
	   sheet = Workbook.getSheet(sheetname);
       int cellcount =  row.getLastCellNum();
       Workbook.close();
       fileinputstream.close();
       return cellcount;
   }
   
   //get cell data
   public static String getcelldata(String filename,String sheetname,int rownum,int colnum ) throws Exception
   {
	   fileinputstream = new FileInputStream(filename);
	   Workbook = new  XSSFWorkbook (fileinputstream);
	   sheet = Workbook.getSheet(sheetname);
       row=sheet.getRow(rownum);
       cell = row.getCell(colnum);
       
       
       String data;
       try
       {
    	   DataFormatter dataformatter = new DataFormatter();
    	   String celldata = dataformatter.formatCellValue(cell);
    	   return celldata;
       }
       catch (Exception e)
       {
    	   data = "";
       }
       Workbook.close();
       fileinputstream.close();
       return data;
   }
   
   

	

}
