package com.vt.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class CustomRetry implements IRetryAnalyzer{

	final static int finalRetryCount = 2;
	int counter = 0;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (counter < finalRetryCount) {
			counter++;
			return true;
		}
		return false;
	}
	
}
