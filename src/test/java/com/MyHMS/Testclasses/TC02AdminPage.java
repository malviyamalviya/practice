package com.MyHMS.Testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyHMS.PageObject.IndexPage;
import com.MyHMS.PageObject.LoginPage;
import com.MyHMS.PageObject.adminpage;

public class TC02AdminPage extends BaseClass{
	@Test
	public void clickonregis(){
		
	     
	     IndexPage page1=new IndexPage(driver);
	     page1.clickonHMS();
			logger.info("Clicked on HMS");
			
			LoginPage page2=new LoginPage(driver);
			BaseClass h=new TC01Clickonhomepage();
			page2.EnteruserName(h.userName);
			logger.info("USER NAME ENTERED");
			page2.Enterpassword(h.passWord);
			logger.info("PASSWORD ENTERED");
			page2.ClickOnLogin();
			logger.info("CLICKED ON LOGIN");
			
		
		
		adminpage page3=new adminpage(driver);
		page3.clickonRegistration();
	     logger.info("CLICKED ON REGISTRATIN");

	}
	
	@Test
	public void verifyLoginByURL() throws IOException {
		String exptitle="Permanent Registration";
		String act=driver.getTitle();
	     if(act.equals(exptitle)) {
	    	 Assert.assertTrue(true);
	     }else {
	    	 capturescreenshot(driver, "verifyLoginByURL");
	    		System.out.println("fail");
	        	 Assert.assertTrue(false);
	        	 
	}
	     logger.info("VERIFY registration PAGE TITLE");
	}
	
}
