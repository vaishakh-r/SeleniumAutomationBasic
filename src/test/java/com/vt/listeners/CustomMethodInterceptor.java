package com.vt.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class CustomMethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("IMethodInterceptor intercept called");
		
		/*
		 *  map1 and  map2 are sample test results count data 
		 *  In Actual framework , for eg in keyword driven framework we take it from 
		 *  excel or other data soruce
		 *  
		 */
		Map<String, String> map1 = new HashMap<>();
		map1.put("testName", "test1Sample");
		map1.put("invocationCount", "1");

		Map<String, String> map2 = new HashMap<>();
		map2.put("testName", "test2Sample");
		map2.put("invocationCount", "1");
		
		
		List<Map<String, String>> testList = new ArrayList<Map<String, String>>();
		testList.add(map1);
		testList.add(map2);
		
		List<IMethodInstance> result = new ArrayList<>();
		for (int i=0; i< methods.size(); i++) {
			for (int j=0; j < testList.size(); j++) {
				if (testList.get(j).get("testName").equals(methods.get(i).getMethod().getMethodName())) {
					
					System.out.println("IMethodInterceptor: modifying parameters for test method -"+methods.get(i).getMethod().getMethodName());

					int invocationCount = Integer.parseInt((String)testList.get(j).get("invocationCount"));
					methods.get(i).getMethod().setInvocationCount(invocationCount);
					result.add(methods.get(i));
				}
			}
		}
		
		return result;
	}

}
