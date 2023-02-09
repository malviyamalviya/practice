package com.MyHMS.Utilites;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListnerner implements ITestListener{
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;
	
	
	public void configureReport() {
		ReadConfigproperties readconfig=new ReadConfigproperties();
		String timestamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportname="MyhmsTestReport-"+timestamp+".html";
		htmlreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+reportname);
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);

		//add details
		reports.setSystemInfo("Machine", "testPC1");
		reports.setSystemInfo("OS", "Window11");
		reports.setSystemInfo("User", "Sourabh");
		reports.setSystemInfo("Browser", readconfig.getbrowser1());


		//look and fill configuration
		htmlreporter.config().setDocumentTitle("ExtentReportDemo");
		htmlreporter.config().setReportName("Test Report");
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("ONstartMethod invoke..........");
		configureReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("ONFinishMethod invoke..........");
		reports.flush();
// to log the message
	} 
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("name of test failure: "+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Fail", ExtentColor.RED));
		test.fail(result.getThrowable());
		
		String screenshotpath=System.getProperty("user.dir")+"\\screenshot\\"+result.getName()+".png";
		File screenshotfile=new File(screenshotpath);
		if(screenshotfile.exists()) {
			test.fail("capture screenshot as below"+test.addScreenCaptureFromPath(screenshotpath));
		
		
		
		
		
		}
     }

	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("name of test Skipped: "+result.getName());
		test=reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" skipped", ExtentColor.YELLOW));
		test.pass(result.getThrowable());

	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("name of test executing: "+result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("name of test Passed: "+result.getName());
		test=reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Pass", ExtentColor.GREEN));
	}

	
	

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	

	
	
	
}
