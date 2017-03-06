package com.manifest.solutionsubmission;

import com.manifest.server.dataobjects.SolutionSubmission;


public class Grader {
	private TestSuiteRetriever suiteRetreiver;
	private TestRunner testRunner;
	private SolutionProxyBuilder solutionProxyBuilder;
	

	public Grader() {
		this.suiteRetreiver = new TestSuiteRetriever();
		this.testRunner = new TestRunner();
		this.solutionProxyBuilder = new SolutionProxyBuilder();
	}
	
	public SolutionGrade grade(SolutionSubmission submission) {
		SolutionProxy solutionProxy =  solutionProxyBuilder.build(submission);
		TestSuite testSuite = suiteRetreiver.getSuite(submission);
		SolutionGrade solutionGrade = testRunner.runTests(testSuite, solutionProxy);
		return solutionGrade;
	}

	public void setTestSuiteRetriever(TestSuiteRetriever suiteRetreiver) {
		this.suiteRetreiver = suiteRetreiver;
	}
	
	public void setTestRunner(TestRunner testRunner) {
		this.testRunner = testRunner;
	}
	
	public void setSolutionProxyBuilder(SolutionProxyBuilder solutionProxyBuilder) {
		this.solutionProxyBuilder = solutionProxyBuilder;
	}
}

