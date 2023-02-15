package com.MyHMS.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	//create the webdriver object
	
	public WebDriver ldriver;
	
	//create the constructor
	public IndexPage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	
	//find element
	
	@FindBy(xpath = "//a[@href='http://www.seleniumbymahesh.com/HMS/']")private
	WebElement HMS;
	
	
	//write the methods
	
	public void clickonHMS() {
		HMS.click();
	}
	
}
