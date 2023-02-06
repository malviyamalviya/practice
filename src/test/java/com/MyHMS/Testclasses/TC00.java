package com.MyHMS.Testclasses;

import org.testng.annotations.Test;

import com.MyHMS.PageObject.IndexPage;

public class TC00 extends BaseClass{

	@Test
	public void clickonHMS() {
		
		driver.get(url);
		
		IndexPage page1=new IndexPage(driver);
		page1.clickonHMS();
	}
	@Test
	public void verifypagetitle() {
		String exptitle="User Login Page";
		String acttitle=driver.getTitle();
		org.testng.Assert.assertEquals(exptitle, acttitle);
		
	}
}
