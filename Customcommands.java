package commands;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.junit.experimental.theories.Theories.TheoryAnchor;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Browser.Invokebrowser;
import Main.Methods;
import xls.xls_reader;

public class Customcommands  extends Invokebrowser 
   {
	
	public static Logger logger =  Logger.getLogger("Customcommands");
	
	//public static WebDriver d;
	public static String screenshotName = "snapshot";
	public static void Screencapture() throws IOException {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		System.out.println(df);
		Date date = new Date();
		
		TakesScreenshot ts=(TakesScreenshot)d;
		  
		 File source=ts.getScreenshotAs(OutputType.FILE);
		  
		 FileUtils.copyFile(source, new File("E:\\AutomationFailure\\FailFM\\FailureSnapshots\\"+screenshotName+"-"+df.format(date) +".png"));
		  
		 System.out.println("Screenshot taken");
	}
	
	
	
	public static void testplan() throws IOException
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
    	
        }
	}
	
	public static void open(String cmd, String obj, String xpath,String input) throws IOException
	{
            logger.info("Invoking browser");
            
		System.out.println("HIIIIIIIIIIIII  " +xpath);
		
		Invokebrowser.chrome();
		d.get(xpath);
		
	}
	
	public static void click(String cmd, String obj, String xpath,String input) throws IOException
	{

             logger.info("..........Clicking element");
		try {
			System.out.println("*************"+xpath);
			d.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Screencapture();
			
		}
	}
	
	public static void type(String cmd, String obj, String xpath,String input) throws IOException
	{

                logger.info(".........Providing input");
		try {
			System.out.println("*************"+xpath);
			WebElement str = d.findElement(By.xpath(xpath));
			str.sendKeys(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Screencapture();
		}
	}
}