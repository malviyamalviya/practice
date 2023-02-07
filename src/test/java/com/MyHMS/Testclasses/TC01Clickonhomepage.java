package com.MyHMS.Testclasses;

import java.io.IOException;



import org.testng.Assert;
import org.testng.annotations.Test;
import com.MyHMS.PageObject.LoginPage;


public class TC01Clickonhomepage extends BaseClass{
@Test
	public void Login() {
	   
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
public void verifyLoginBytitle() throws IOException {
	String AfterLoginexp="Master Page1";
	String AfterLoginact=driver.getTitle();
     if(AfterLoginact.equals(AfterLoginexp)) {
    	 logger.info("verifying page title");
    	
    	 Assert.assertTrue(true);
     }else {
    	 logger.info("verifying failed");
    	 capturescreenshot(driver, "verifyLoginBytitle");
    		 Assert.assertTrue(false);
        	 
}
     
}
}

