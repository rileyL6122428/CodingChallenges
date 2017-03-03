package com.manifest.solutionsubmission;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.manifest.solutionsubmission.testsuites.FizzBuzzSuite;

public class TestSuiteRetriever {
	
	private Map<String, TestSuite> testSuites;
	
	{
		testSuites = new HashMap<String, TestSuite>();
		
		Arrays.asList(new FizzBuzzSuite())
				.stream()
				.forEach(this::addSuite);
	}
	
	private void addSuite(TestSuite testSuite) {
		testSuites.put(testSuite.CHALLENGE_NAME, testSuite);
	}

	public TestSuite getSuite(String challengeName) {
		return testSuites.get(challengeName);
	}

	public void setTestSuites(Map<String, TestSuite> testSuites) {
		this.testSuites = testSuites;
	}
}
