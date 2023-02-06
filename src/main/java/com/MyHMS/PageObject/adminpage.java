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
		
		public void clickonRegistration() {
			Registration.click();
		}
				
}
