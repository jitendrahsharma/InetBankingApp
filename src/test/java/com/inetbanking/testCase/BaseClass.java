package com.inetbanking.testCase;
import java.io.File;
import java.io.IOException;
//import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.Utilities.ReadConfig;

	public class BaseClass
	{
		ReadConfig readconfig=new ReadConfig();
		public String baseURL=readconfig.getApplicationURL();
		public String username=readconfig.getUserName();
		public String password=readconfig.getPassword();
		public static WebDriver driver;
		public static Logger logger;
		
		@Parameters("browser")
		@BeforeClass
		public void setup(String br)
		{		 
			 logger=Logger.getLogger("ebanking");
			 PropertyConfigurator.configure("Log4j.properties");
			 
			 if(br.equals("chrome"))
			 {
			 System.setProperty("webdriver.chrome.driver", readconfig.getChromPath());
			 driver=new ChromeDriver();
			 }
			 else if(br.equals("firefox"))
			 {
				 System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
				driver=new FirefoxDriver();
			 }
			 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			 driver.get(baseURL);
			}
/*		@BeforeClass
		public void setup()
		{		 
			 logger=Logger.getLogger("ebanking");
			 PropertyConfigurator.configure("Log4j.properties");
			 
			System.setProperty("webdriver.chrome.driver", readconfig.getChromPath());
			 driver=new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			 driver.get(baseURL);
			}*/
		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}
		public void captureScreen(WebDriver driver,String tname) throws IOException 
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+System.currentTimeMillis() +".png");
			FileUtils.copyFile(source,target);
			System.out.println("Screenshot Taken");
		}
		public static void miximizePage()
		{
			driver.manage().window().maximize();
		}
		public static void deleteCookies()
		{
			driver.manage().deleteAllCookies();
		}
		public static String randomstring()
		{
			String generatedstring=RandomStringUtils.randomAlphabetic(5);
			return (generatedstring);
		}
		public static String randomNum()
		{
			String  generatedint=RandomStringUtils.randomNumeric(10);
			return (generatedint);
		}
	}

