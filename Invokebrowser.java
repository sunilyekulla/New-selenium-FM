package Browser;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commands.Customcommands;
import xls.xls_reader;
//import xls.xls_reader;
public class Invokebrowser extends xls_reader {
	
	public static WebDriver d;
	
	public static  void chrome() throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\AutomationFailure\\FailFM\\Drivers\\chromedriver.exe");
		d= new ChromeDriver();		
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//d.get("http://automationpractice.com/index.php");
		//System.out.println(Runflag1);
	}	
		public static void Firefox() {
			System.setProperty("webdriver.gecko.driver", "E:\\AutomationFailure\\FailFM\\Drivers\\geckodriver.exe");
			d= new FirefoxDriver();
			d.manage().window().maximize();
			d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
	}

	/*public static void main(String[] args) {
		Invokebrowser.openbrowser();
	}*/