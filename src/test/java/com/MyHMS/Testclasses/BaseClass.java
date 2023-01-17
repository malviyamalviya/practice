package com.MyHMS.Testclasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.MyHMS.Utilites.ReadConfigproperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

public WebDriver driver;
	
	ReadConfigproperties readconfig=new ReadConfigproperties();
	
	String url=readconfig.getUrl();
	String browser= readconfig.getbrowser1();
	String userName=readconfig.getusername();
	String passWord=readconfig.getpassword();

	public static Logger logger;
	@BeforeClass
	public void setup() {
		
	switch(browser.toLowerCase()) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		break;
	case "msedge":
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
		default:
		driver=null;
		break;
	}
		
		

		//implicite wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//for logging
		logger=LogManager.getLogger("Myhms");
		
		}
	@AfterClass
	public void teardown() {
		driver.close();
	}
	
	public void capturescreenshot(WebDriver driver,String testname) throws IOException {
		
		TakesScreenshot schshot = ((TakesScreenshot)driver);
		//step2
		File src = schshot.getScreenshotAs(OutputType.FILE);
	    
	File dest=new File(System.getProperty("D:\\my pen drive\\Myhms\\screenshots\\"+testname+".png"));
	
	FileUtils.copyFile(src,dest);
	}
	
}