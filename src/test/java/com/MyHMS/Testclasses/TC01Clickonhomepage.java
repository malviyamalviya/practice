package com.MyHMS.Testclasses;

import org.testng.annotations.Test;

import com.MyHMS.PageObject.IndexPage;

public class TC01Clickonhomepage extends BaseClass{
@Test
	public void clickonhome() {
	
	driver.get(url);
	
		
		IndexPage page1=new IndexPage(driver);
		page1.EnteruserName("Admin");
		page1.Enterpassword("admin123");
		page1.ClickOnLogin();
	}
	
}
