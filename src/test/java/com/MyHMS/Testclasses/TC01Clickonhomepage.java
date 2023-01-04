package com.MyHMS.Testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
@Test
public void verifyLoginByURL() {
	String AfterLoginexp="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	String AfterLoginact=driver.getCurrentUrl();
      
Assert.assertEquals(AfterLoginact, AfterLoginexp);
	System.out.println("Pass");
}
	
}
