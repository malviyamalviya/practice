package com.MyHMS.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//webdriverobject
	public WebDriver ldriver;

//create constructor
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	//identify element
@FindBy(xpath = "//input[@name='username']")WebElement username;

@FindBy(xpath = "//input[@name='password']")WebElement password;
@FindBy(xpath = "//input[@name='submit']")WebElement login;

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
