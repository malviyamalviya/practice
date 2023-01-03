package com.MyHMS.Testclasses;

import java.time.Duration;

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
		}
	@AfterClass
	public void teardown() {
		driver.close();
	}
}