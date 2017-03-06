package com.manifest.solutionsubmission;

import com.manifest.server.dataobjects.SolutionSubmission;


public class Grader {
//	private String challengeName;
	private TestSuiteRetriever suiteRetreiver;
	private TestRunner testRunner;
	
	public Grader() {
		this.suiteRetreiver = new TestSuiteRetriever();
		this.testRunner = new TestRunner();
	}
	
	public SolutionGrade grade(SolutionSubmission submission) {
		SolutionProxy solutionProxy =  new SolutionProxyBuilder().build(submission);
		TestSuite testSuite = suiteRetreiver.getSuite(submission.getChallengeName());
		SolutionGrade solutionGrade = testRunner.runTests(testSuite, solutionProxy);
		return solutionGrade;
	}
	
	

	public void setTestSuiteRetriever(TestSuiteRetriever suiteRetreiver) {
		this.suiteRetreiver = suiteRetreiver;
	}
	
	public void setTestRunner(TestRunner testRunner) {
		this.testRunner = testRunner;
	}
	
}

