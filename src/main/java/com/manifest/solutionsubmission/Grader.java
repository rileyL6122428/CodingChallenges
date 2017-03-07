package com.manifest.solutionsubmission;

import com.manifest.server.dataobjects.SolutionSubmission;
import com.manifest.solutionsubmission.throwables.SolutionCompilationException;
import com.manifest.solutionsubmission.throwables.TargetMethodMissingException;


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
		SolutionGrade grade;
		
		try {
			SolutionProxy solutionProxy = solutionProxyFactory.tryNewSolutionProxy(submission);
			TestSuite testSuite = suiteRetreiver.getSuite(submission);
			grade = testRunner.runTests(testSuite, solutionProxy);
			
		} catch(ClassFormatError classFormatError) {
			SolutionCompilationException compilationException = SolutionCompilationException.newException(classFormatError);
			grade = SolutionGrade.failingGrade(compilationException);
		} catch(NoSuchMethodException noSuchMethodException) {
			TargetMethodMissingException targetMissingException = TargetMethodMissingException.newException(noSuchMethodException);
			grade = SolutionGrade.failingGrade(targetMissingException);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			grade = null;
		}
		
		return grade;
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

