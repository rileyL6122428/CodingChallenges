package com.manifest.solutionsubmission;

import com.manifest.server.dataobjects.SolutionSubmission;


public class Grader {
	private TestSuiteRetriever suiteRetreiver;
	private TestRunner testRunner;
	private SolutionProxyFactory solutionProxyFactory;
	

	public Grader() {
		this.suiteRetreiver = new TestSuiteRetriever();
		this.testRunner = new TestRunner();
		this.solutionProxyFactory = new SolutionProxyFactory();
	}
	
	public SolutionGrade grade(SolutionSubmission submission) {
		try {
			SolutionProxy solutionProxy = solutionProxyFactory.tryNewSolutionProxy(submission);
			TestSuite testSuite = suiteRetreiver.getSuite(submission);
			SolutionGrade solutionGrade = testRunner.runTests(testSuite, solutionProxy);
			return solutionGrade;
			
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			return SolutionGrade.failingGrade(throwable);
		}
	}

	public void setTestSuiteRetriever(TestSuiteRetriever suiteRetreiver) {
		this.suiteRetreiver = suiteRetreiver;
	}
	
	public void setTestRunner(TestRunner testRunner) {
		this.testRunner = testRunner;
	}
	
	public void setSolutionProxyBuilder(SolutionProxyFactory solutionProxyBuilder) {
		this.solutionProxyFactory = solutionProxyBuilder;
	}
}

