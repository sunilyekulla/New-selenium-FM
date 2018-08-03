package xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Browser.Invokebrowser;
import Main.Methods;
import commands.Customcommands;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xls_reader {
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
	public static  String tpRunflag;
	public static  String tpBrowser;
	
	public static  String Runflag1;
	public static  String Testcasename;
	public static  String Testscriptname;
	
	public static String tsrsheet;
	public static  String command;
	public static  String object;
	public static  String xpath;
	public static  String TCname;
	public static String  sheet1;
	
	//Testplan description
	
		/*public static void testplan() throws IOException
		{
			
		      String testplanpath ="E:\\AutomationFailure\\FailFM\\ExcelFiles\\Testplan.xlsx";
		   
		            FileInputStream myInput = new FileInputStream(new File(testplanpath));

		            Workbook workBook = null;

		            workBook    = new XSSFWorkbook(myInput);

		            Sheet testplansheet = workBook.getSheetAt(0);


		            int rowcount  = testplansheet.getLastRowNum();

        for( int i = 1 ; i < rowcount+1 ; i++ )

            {
                 // = firstRow.getCell(i);
            tpRunflag=testplansheet.getRow(i).getCell(0).getStringCellValue(); 
            tpBrowser =testplansheet.getRow(i).getCell(1).getStringCellValue();   
        	System.out.println(tpRunflag + "   " +tpBrowser);
        	
            }*/
      
		 
        	
		//Testsuite description
	public static void testsuite() throws Exception 
	    {
		PropertyConfigurator.configure("Log4j.properties");
		
		String testsuitepath = "E:\\AutomationFailure\\FailFM\\ExcelFiles\\Testsuite.xlsx";
		    

		            FileInputStream myInput = new FileInputStream(new File(testsuitepath));

		            Workbook workBook = null;

		            workBook    = new XSSFWorkbook(myInput);

		            Sheet testsuitesheet = workBook.getSheetAt(0); 		            

		            int rowcount  = testsuitesheet.getLastRowNum()+1;
		            System.out.println(rowcount);

     for( int i = 1 ; i <rowcount ; i++ )

         {
           
       String  run = testsuitesheet.getRow(i).getCell(0).getStringCellValue(); 
      String   tcname=testsuitesheet.getRow(i).getCell(1).getStringCellValue();  
  
     	System.out.println( run);
     	System.out.println( tcname);
     	
     	Methods.testinput( run, tcname);
       }   
     
	     
}	

	
	public static void main(String[] args) throws Exception
	{
		//xls_reader.testplan();
		xls_reader.testsuite();
		
		
	}

}
