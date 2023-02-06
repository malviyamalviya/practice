package com.MyHMS.Testclasses;

import java.io.IOException;



import org.testng.Assert;
import org.testng.annotations.Test;
import com.MyHMS.PageObject.LoginPage;


public class TC01Clickonhomepage extends BaseClass{
@Test
	public void Login() {
	    logger.info("URL OPENED");
	    TC00 test1=new TC00();
	    test1.clickonHMS();
	    logger.info("CLICKED ON HMS");

		LoginPage page1=new LoginPage(driver);
		BaseClass h=new TC01Clickonhomepage();
		page1.EnteruserName(h.userName);
		logger.info("USER NAME ENTERED");
		page1.Enterpassword(h.passWord);
		logger.info("PASSWORD ENTERED");
		page1.ClickOnLogin();
		logger.info("CLICKED ON LOGIN");
		}
@Test
public void verifyLoginByURL() throws IOException {
	String AfterLoginexp="Master Page";
	String AfterLoginact=driver.getTitle();
     if(AfterLoginact.equals(AfterLoginexp)) {
    	 Assert.assertTrue(true);
     }else {
    	 capturescreenshot(driver, "verifyLoginByURL");
    		System.out.println("fail");
        	 Assert.assertTrue(false);
        	 
}
     logger.info("VERIFY PAGE TITLE");
}
}

