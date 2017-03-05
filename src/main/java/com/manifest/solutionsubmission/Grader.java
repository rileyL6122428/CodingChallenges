package com.manifest.solutionsubmission;


public class Grader {
	private String challengeName;
	private TestSuiteRetriever suiteRetreiver;
	private TestRunner testRunner;
	
	public Grader(String challengeName) {
		this.challengeName = challengeName;
		this.suiteRetreiver = new TestSuiteRetriever();
	}
	
	public SolutionGrade grade() {
		TestSuite testSuite = suiteRetreiver.getSuite(challengeName);
		SolutionGrade solutionGrade = testRunner.runSuite(testSuite);
		return solutionGrade;
	}

	public void setTestSuiteRetriever(TestSuiteRetriever suiteRetreiver) {
		this.suiteRetreiver = suiteRetreiver;
	}
	
	public void setTestRunner(TestRunner testRunner) {
		this.testRunner = testRunner;
	}
	
}

