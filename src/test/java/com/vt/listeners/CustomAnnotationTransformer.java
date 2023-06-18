package com.vt.listeners;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class CustomAnnotationTransformer implements IAnnotationTransformer{
	
	

	  @Override
	  public void transform(
		      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		  
		  /*
		   *  annotation (@Test) can be modified using this Transformer Annotation. 
		   *  You can run the test based on some logic that you have added here 
		   *  RETRY ANALYZER is also set here 
		   */
	
		  if (testMethod.getName().equalsIgnoreCase("expected_test_case_name")) {
			  annotation.setEnabled(false);
		  }
		  
		  /*
		   *  RETRY ANALYZER
		   */
		  annotation.setRetryAnalyzer(CustomRetry.class);
		  
	  }

}
