package Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.RowIdLifetime;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import commands.Customcommands;
import xls.xls_reader;

public class Methods extends xls_reader{
	public static XSSFWorkbook wb;
	public  static XSSFSheet sheet;
	XSSFCell cell;
	public static String cmd;
	public static String obj;
	public static String xpath;
	public static String input;
	
	public static void testinput(String s1,String s2 ) throws Exception 
	{
		String	testsriptpath = "E:\\AutomationFailure\\FailFM\\ExcelFiles\\Testscript.xlsx";
		FileInputStream fi = new FileInputStream(testsriptpath);
		wb = new XSSFWorkbook(fi);
		//sheet =wb.getSheetAt(0);
		 for(int k=0;k<wb.getNumberOfSheets();k++) {
			 
				//System.out.println("*******");
			 
				 sheet = wb.getSheetAt(k);				
				String sheet1=wb.getSheetName(k);
				
				System.out.println("SHEETNAME***"+ wb.getSheetName(k));
				System.out.println("S1" + s1);
				System.out.println("S2" + s2);
				//System.out.println("Sheet1...." + sheet1);
				
				if(s1.equals("Y") && s2.equals(sheet1))
				{
					System.out.println("****If condition enter");	
					
					int rowcount = sheet.getLastRowNum()+1;
					System.out.println(rowcount);
			
				
		for(int j=1;j<rowcount;j++) 
		{
		 cmd =sheet.getRow(j).getCell(1).getStringCellValue();
		 obj =sheet.getRow(j).getCell(2).getStringCellValue();
		 xpath= sheet.getRow(j).getCell(3).getStringCellValue();
		 input=sheet.getRow(j).getCell(4).getStringCellValue();
		 
		 XSSFRow row = sheet.getRow(j);
		 List<Cell> cells = new ArrayList<Cell>();
		 int lastcoloumn = Math.max(row.getLastCellNum(), 5);
		 for(int cn=0;cn<lastcoloumn;cn++) {
			 Cell c=row.getCell(cn,MissingCellPolicy.RETURN_BLANK_AS_NULL);
			 cells.add(c);
		 }
		 
		 //XSSFCell c=sheet. 
		
		//if(cell=null && )
		 
		 if(cmd.equals("open"))
		 {
			 Customcommands.open(cmd, obj, xpath,input);
		 }
		 
		 else if(cmd.equals("click"))
		 {
			 
			 Customcommands.click(cmd, obj, xpath,input);
	     }
		 
		 else if(cmd.equals("type")) {
			 Customcommands.type(cmd, obj, xpath,input);
		 }
		
	}
		 }
	}
	     }
	}