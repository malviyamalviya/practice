package com.MyHMS.Testclasses;

import java.io.IOException;



import org.testng.Assert;
import org.testng.annotations.Test;
import com.MyHMS.PageObject.LoginPage;


public class TC01Clickonhomepage extends BaseClass{
@Test
	public void Login() throws IOException {
	   
	    TC00 test1=new TC00();
	    test1.clickonHMS();
	    logger.info("CLICKED ON HMS");

		LoginPage page1=new LoginPage(driver);
		
		page1.EnteruserName("admin");
		logger.info("USER NAME ENTERED");
		page1.Enterpassword("admin");
		logger.info("PASSWORD ENTERED");
		page1.ClickOnLogin();
		logger.info("CLICKED ON LOGIN");
		
		
		
		String AfterLoginexp="Master Page";
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

