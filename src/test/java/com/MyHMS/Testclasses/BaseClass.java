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
	String browser1= readconfig.getbrowser1();
	String browser2=readconfig.getbrowser2();
	String browser3=readconfig.getbrowser3();
	
	@BeforeClass
	public void setup() {
		if(browser1.toLowerCase()=="chrome") {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-notifications");
			WebDriver driver=new ChromeDriver(option);
			driver.manage().window().maximize();
		}
		else if(browser2.toLowerCase()=="firefox") {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions option=new FirefoxOptions();
			option.addArguments("--disable-notifications");
			WebDriver driver=new FirefoxDriver(option);
			driver.manage().window().maximize();
		}
		else if(browser3.toLowerCase()=="msedge") {
			WebDriverManager.edgedriver().setup();
			EdgeOptions option=new EdgeOptions();
			option.addArguments("--disable-notifications");
			WebDriver driver=new EdgeDriver(option);
			driver.manage().window().maximize();
	}else {
		
	}

		//implicite wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	@AfterClass
	public void teardown() {
		driver.close();
	}
}