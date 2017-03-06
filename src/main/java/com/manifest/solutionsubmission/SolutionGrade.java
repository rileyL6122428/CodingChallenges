package com.manifest.solutionsubmission;

import java.util.Iterator;
import java.util.List;

import com.manifest.solutionsubmission.SolutionTest.TestResult;

public class SolutionGrade {
	private boolean passesTests;
	private String errorMessage;
	
	public static SolutionGrade failingGrade() {
		SolutionGrade grade = new SolutionGrade();
		grade.setPassesTests(false);
		return grade;
	}
	
	public static SolutionGrade failingGrade(Throwable throwable) {
		SolutionGrade grade = new SolutionGrade();
		grade.setPassesTests(false);
		grade.setErrorMessage(throwable.getMessage());
		return grade;
	}
	
	public SolutionGrade() {}
	
	public SolutionGrade(List<TestResult> testResults) {
		this.passesTests = allResultsPassing(testResults);
	}
	
	//TODO Add unit tests for this code (Currently, this method is implicitly tested by TestRunnerTest)
	private boolean allResultsPassing(List<TestResult> testResults) {
		Iterator<TestResult> resultsIterator = testResults.iterator();
		
		while(resultsIterator.hasNext()) {
			TestResult result = resultsIterator.next();
			if(!result.getPassedTest()) return false;
		}
		
		return true;
	}

	public void setPassesTests(boolean passesTests) {
		this.passesTests = passesTests;
	}

	public boolean passesTests() {
		return passesTests;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}
	
	public void setErrorMessage(String message) {
		this.errorMessage = message;
	}
}
