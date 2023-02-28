package com.MyHMS.Utilites;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnyalaysers implements IRetryAnalyzer {

	//counter to keep track of retry attempts
	
	int counterforRetryattempts=0;
	
	// set max limit for retry 
	
	int setMaxlimitforretry=2;
	@Override
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
			if(counterforRetryattempts<setMaxlimitforretry) {
				counterforRetryattempts++;
				return true;
			}
		}
		return false;
	}

	
}
