package com.manifest.solutionsubmission;

import java.util.List;

import com.manifest.solutionsubmission.SolutionTest.TestResult;

public class SolutionGrade {
	private boolean passesTests;
	private String errorMessage;
	
	public static SolutionGrade failingGrade(Throwable throwable) {
		SolutionGrade grade = new SolutionGrade();
		grade.setPassesTests(false);
		grade.setErrorMessage(throwable.getMessage());
		return grade;
	}
	
	public SolutionGrade() {}
	
	public SolutionGrade(List<TestResult> testResults) {
		for(TestResult result: testResults) {
			if(!result.getSolutionPasses()) {
				passesTests = false;
				errorMessage = result.getErrorMessage();
				break;
			}
		}
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
