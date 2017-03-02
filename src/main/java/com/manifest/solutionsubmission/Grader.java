package com.manifest.solutionsubmission;


public class Grader {
	private String challengeName;
	private TestSuiteRetriever suiteRetreiver;
	private TestRunner runner;
	
	public Grader(String challengeName) {
		this.challengeName = challengeName;
	}
	
	public TestSuite.SuiteTestResult grade() {
		return runner.runSuite(suiteRetreiver.getSuite(challengeName));
	}

	public void setTestSuiteRetriever(TestSuiteRetriever suiteRetreiver) {
		this.suiteRetreiver = suiteRetreiver;
	}
	
	public void setTestRunner(TestRunner testRunner) {
		this.runner = testRunner;
	}
	
}

