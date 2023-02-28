package com.MyHMS.PageObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminpage {

	// create object for webdriver
			 WebDriver ldriver;
				
				public adminpage(WebDriver rdriver) {
			ldriver=rdriver;		
				
				PageFactory.initElements(rdriver, this);
				
				}
				
		@FindBy(linkText = "Registration")
		WebElement Registration;
		
		@FindBy(xpath = "//a[normalize-space()='Logout']")private WebElement logout;
		
		public void clickonRegistration() {
			Registration.click();
		}
		public void clickonLogout() {
			logout.click();
		}	
}
