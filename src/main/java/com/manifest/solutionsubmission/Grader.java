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
		return testRunner.runSuite(suiteRetreiver.getSuite(challengeName));
	}

	public void setTestSuiteRetriever(TestSuiteRetriever suiteRetreiver) {
		this.suiteRetreiver = suiteRetreiver;
	}
	
	public Grader setTestRunner(TestRunner testRunner) {
		this.testRunner = testRunner;
		return this;
	}
	
}

