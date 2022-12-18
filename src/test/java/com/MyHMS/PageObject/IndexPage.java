package com.MyHMS.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
//webdriverobject
	public WebDriver driver;

//create constructor
	public IndexPage(WebDriver rdriver){
		driver=rdriver;
		PageFactory.initElements(driver,this);
	}

	//identify element
	@FindBy(xpath = "//a[@href='http://www.seleniumbymahesh.com/HMS/']")WebElement HMS;
	
	//action
	public void clickHMS() {
		HMS.click();
	}

}
