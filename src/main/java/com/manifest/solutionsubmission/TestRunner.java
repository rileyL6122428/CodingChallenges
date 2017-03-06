package com.manifest.solutionsubmission;

import com.manifest.solutionsubmission.SolutionTest.TestResult;

public class TestRunner {
	
	private SolutionProxy solutionProxy;
		
	//TODO REFACTOR AFTER TESTS ARE ADJUSTED
	public SolutionGrade runTests(TestSuite suite, SolutionProxy solutionProxy) {
		this.solutionProxy = solutionProxy;
		SolutionGrade grade = new SolutionGrade();
		grade.setPassesTests(true);
		suite.forEachTest((test) -> failIfTestFails(test, grade));
		return grade;
	}
	
	private void failIfTestFails(SolutionTest test, SolutionGrade grade) {
		TestResult testResult = test.execute(solutionProxy);
		if(!testResult.getPassedTest()) grade.setPassesTests(false);
	}
	
	public void setSolutionProxy(SolutionProxy solutionProxy) {
		this.solutionProxy = solutionProxy;
	}
}
