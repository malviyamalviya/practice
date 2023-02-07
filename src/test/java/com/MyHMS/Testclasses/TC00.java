package com.MyHMS.Testclasses;

import org.testng.annotations.Test;

import com.MyHMS.PageObject.IndexPage;

public class TC00 extends BaseClass{

	@Test
	public void clickonHMS() {
		
		
		IndexPage page1=new IndexPage(driver);
		page1.clickonHMS();
		logger.info("Clicked on HMS");

	}
	@Test
	public void verifypagetitle() {
		String exptitle="User Login Page";
		String acttitle=driver.getTitle();
		org.testng.Assert.assertEquals(exptitle, acttitle);
		
		logger.info("After new page verify for the same page title");

	}
}
