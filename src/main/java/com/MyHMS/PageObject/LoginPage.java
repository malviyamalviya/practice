package com.MyHMS.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
// create Webdriver object
	public WebDriver ldriver;

//create constructor
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	//identify element
@FindBy(xpath = "//input[@name='username']")WebElement UserName;

@FindBy(xpath = "//input[@name='password']")WebElement PassWord;
@FindBy(xpath = "//input[@name='submit']")WebElement login;
@FindBy(xpath = "//a[normalize-space()='Logout']")WebElement logout;	

//action
	public void EnteruserName(String Username) {
		UserName.sendKeys(Username);
	}

	public void Enterpassword(String Password) {
		PassWord.sendKeys(Password);
	}
	public void ClickOnLogin() {
		login.click();
	}
	public void clickonLogout() {
		logout.click();
	}
}
