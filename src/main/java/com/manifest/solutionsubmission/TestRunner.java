package com.manifest.solutionsubmission;

import java.util.ArrayList;
import java.util.List;

import com.manifest.solutionsubmission.SolutionTest.TestResult;

public class TestRunner {
	
	private SolutionProxy solutionProxy;
		
	public SolutionGrade runTests(TestSuite suite, SolutionProxy solutionProxy) {
		List<TestResult> testResults = new ArrayList<TestResult>();
		
		suite.forEachTest((test) -> {
			TestResult testResult = test.execute(solutionProxy);
			testResults.add(testResult);	
		});
		
		return new SolutionGrade(testResults);
	}
	
	
	public void setSolutionProxy(SolutionProxy solutionProxy) {
		this.solutionProxy = solutionProxy;
	}
}
