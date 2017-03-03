package com.manifest.solutionsubmission;

import com.manifest.solutionsubmission.SolutionTest.TestResult;

public class TestRunner {
	
	private SolutionProxy solutionProxy;
	
	TestRunner(SolutionProxy solutionProxy) {
		this.solutionProxy = solutionProxy;
	}

	public SolutionGrade runSuite(TestSuite suite) {
		SolutionGrade grade = new SolutionGrade();
		grade.setPassesTests(true);
		suite.forEachTest((test) -> failIfTestFails(test, grade));
		return grade;
	}
	
	private void failIfTestFails(SolutionTest test, SolutionGrade grade) {
		TestResult testResult = test.execute(solutionProxy);
		if(!testResult.passedTest) grade.setPassesTests(false);
	}
	
	public void setSolutionProxy(SolutionProxy solutionProxy) {
		this.solutionProxy = solutionProxy;
	}
}
