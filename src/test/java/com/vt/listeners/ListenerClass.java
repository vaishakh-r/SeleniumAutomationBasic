package com.vt.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener, ISuiteListener {
	
	  @Override
	  public void onTestStart(ITestResult result) {
		    // not implemented
		  System.out.println("On Test Start Called");
	  }
	  
	  @Override
	  public void onTestFailure(ITestResult result) {
		    // not implemented
		  System.out.println("On Test Failure Called: Attach Screenshots");

	  }
	  
	  @Override
	  public void onStart(ISuite suite) {
		    // not implemented
		  System.out.println("On onStart Called");
		}

	  
	  @Override
	  public void onFinish(ISuite suite) {
		    // not implemented
	  }

}
