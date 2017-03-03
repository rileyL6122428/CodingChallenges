package com.manifest.solutionsubmission;

import java.util.Map;

public class TestSuiteRetriever {
	
	private Map<String, TestSuite> testSuites;

	public TestSuite getSuite(String challengeName) {
		return testSuites.get(challengeName);
	}

	public void setTestSuites(Map<String, TestSuite> testSuites) {
		this.testSuites = testSuites;
	}
}
