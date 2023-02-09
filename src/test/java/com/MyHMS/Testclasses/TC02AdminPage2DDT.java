package com.MyHMS.Testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MyHMS.PageObject.IndexPage;
import com.MyHMS.PageObject.LoginPage;
import com.MyHMS.PageObject.adminpage;
import com.MyHMS.Utilites.ReadExcel;

public class TC02AdminPage2DDT extends BaseClass{
	@Test
	public void AclickHMS() {
		IndexPage page1=new IndexPage(driver);
        page1.clickonHMS();
		logger.info("Clicked on HMS");
	}
	
	
	@Test(dataProvider = "LoginDataprovider")
	public void clickonregis(String username,String Password)throws IOException{
		
			
			LoginPage page2=new LoginPage(driver);
			
			page2.EnteruserName(username);
			
			logger.info("USER NAME ENTERED");
			page2.Enterpassword(Password);
			
			logger.info("PASSWORD ENTERED");
			page2.ClickOnLogin();
			logger.info("CLICKED ON LOGIN");
		
		adminpage page3=new adminpage(driver);
		page3.clickonRegistration();
	     logger.info("CLICKED ON REGISTRATION");
	     String exptitle="Permanent Registration";
			String act=driver.getTitle();
		     if(act.equals(exptitle)) {
		    	 Assert.assertTrue(true);
		     }else {
		    	 capturescreenshot(driver, "verifyLoginByTITLE");
		    		System.out.println("fail");
		        	 Assert.assertTrue(false);
		        	 
		}
		     logger.info("VERIFY registration PAGE TITLE");
		     page3.clickonLogout();
	     logger.info("CLICKED ON logout");
	     

	}
	
	
	@DataProvider(name = "LoginDataprovider")
	public String[][] LoginDataprovidermethod() throws IOException{
		String filename="D:\\my pen drive\\Myhms\\TestData\\MyhmsExcelData.xlsx";
		String sheetname="LoginData";
		int totalrows=ReadExcel.getrowcount(filename, sheetname);
		int totalcell=ReadExcel.getcellcount(filename, sheetname);
		String data[][]=new String[totalrows-1][totalcell];
		
		for(int i=1;i<totalrows;i++) {
			for(int j=0;j<totalcell;j++) {
				 data[i-1][j]=ReadExcel.getcellvalue(filename, sheetname, i, j);
			}
		}
		
		
		return data;
		
		
	}
	
	
}
