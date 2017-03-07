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
			grade = tryTestSolution(submission);
		} catch(ClassFormatError classFormatError) {
			grade = failingGrade(classFormatError);
		} catch(NoSuchMethodException noSuchMethodException) {
			grade = failingGrade(noSuchMethodException);
		} catch (Throwable throwable) {
			grade = null;
			throwable.printStackTrace();
		}
		
		return grade;
	}
	
	private SolutionGrade tryTestSolution(SolutionSubmission submission) throws Exception {
		SolutionProxy solutionProxy = solutionProxyFactory.tryNewSolutionProxy(submission);
		TestSuite testSuite = suiteRetreiver.getSuite(submission);
		SolutionGrade grade = testRunner.runTests(testSuite, solutionProxy); 
		return grade;
	}
	
	private SolutionGrade failingGrade(ClassFormatError classFormatError) {
		SolutionCompilationException compilationException = SolutionCompilationException.newException(classFormatError);
		return SolutionGrade.failingGrade(compilationException);
	}
	
	private SolutionGrade failingGrade(NoSuchMethodException noSuchMethodException) {
		TargetMethodMissingException targetMissingException = TargetMethodMissingException.newException(noSuchMethodException);
		return SolutionGrade.failingGrade(targetMissingException);
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

