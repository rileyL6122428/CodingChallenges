package com.manifest.solutionsubmission;

import com.manifest.solutionsubmission.SolutionTest.TestResult;




public class TestRunner {
	
	private SolutionProxy solutionProxy;
	
	public TestRunner(SolutionProxy solutionProxy) {
		this.solutionProxy = solutionProxy;
	}
	
	public TestRunner() {}

	
	//DELETE METHOD
	public SolutionGrade runSuite(TestSuite suite) {
		SolutionGrade grade = new SolutionGrade();
		grade.setPassesTests(true);
		suite.forEachTest((test) -> failIfTestFails(test, grade));
		return grade;
	}
	
	//TODO REFACTOR AFTER TESTS
	public SolutionGrade runTests(TestSuite suite, SolutionProxy solutionProxy) {
		this.solutionProxy = solutionProxy;
		SolutionGrade grade = new SolutionGrade();
		grade.setPassesTests(true);
		suite.forEachTest((test) -> failIfTestFails(test, grade));
		return grade;
	}
	
	private void failIfTestFails(SolutionTest test, SolutionGrade grade) {
		TestResult testResult = test.execute(solutionProxy);
		if(!testResult.isPassedTest()) grade.setPassesTests(false);
	}
	
	public void setSolutionProxy(SolutionProxy solutionProxy) {
		this.solutionProxy = solutionProxy;
	}
}
