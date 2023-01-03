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
@FindBy(xpath = "//input[@placeholder='Username']")WebElement username;

@FindBy(xpath = "//input[@placeholder='Password']")WebElement password;
@FindBy(xpath = "//button[@type='submit']")WebElement login;

	//action
	public void EnteruserName(String Username) {
		username.sendKeys(Username);
	}

	public void Enterpassword(String Password) {
		password.sendKeys(Password);
	}
	public void ClickOnLogin() {
		login.click();
	}
}
