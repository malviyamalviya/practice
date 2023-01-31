package com.MyHMS.Testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.MyHMS.PageObject.IndexPage;

public class TC01Clickonhomepage extends BaseClass{
@Test
	public void clickonhome() {
	driver.get(url);
	logger.info("url opened");
		
		IndexPage page1=new IndexPage(driver);
		BaseClass h=new TC01Clickonhomepage();
		page1.EnteruserName(h.userName);
		page1.Enterpassword(h.passWord);
		page1.ClickOnLogin();
		
		}
@Test
public void verifyLoginByURL() throws IOException {
	String AfterLoginexp="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	String AfterLoginact=driver.getCurrentUrl();
     if(AfterLoginact.equals(AfterLoginexp)) {
    	 Assert.assertTrue(true);
     }else {
    	 capturescreenshot(driver, "verifyLoginByURL");
    		System.out.println("fail");
        	 Assert.assertTrue(false);

}
}
}

