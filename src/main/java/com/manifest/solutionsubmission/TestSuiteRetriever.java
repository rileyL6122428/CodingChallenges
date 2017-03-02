package com.manifest.solutionsubmission;

import java.util.Map;

import com.manifest.solutionsubmission.testsuites.SolutionTestSuite;

public class TestSuiteRetriever {
	private Map<String, Class<?>> testSuites;
	
	public TestSuiteRetriever(Map<String, Class<?>> map) {
		this.testSuites = map;
	}
	
	public void addSuite(Class<?> suiteClass) {
		try {
			String challengeName;
			challengeName = (String)suiteClass.getField("CHALLENGE_NAME").get(null);
			testSuites.put(challengeName, suiteClass);
			
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}

	public Class<?> get(String challengeName) {
		return testSuites.get(challengeName);
	}
	
	
}
