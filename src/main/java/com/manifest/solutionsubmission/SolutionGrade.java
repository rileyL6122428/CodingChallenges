package com.manifest.solutionsubmission;

import java.util.List;

import com.manifest.solutionsubmission.SolutionTest.TestResult;

public class SolutionGrade {
	private boolean passing;
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
				passing = false;
				errorMessage = result.getErrorMessage();
				return;
			}
		}
		
		passing = true;
	}

	private void setPassesTests(boolean passesTests) {
		this.passing = passesTests;
	}

	public boolean isPassing() {
		return passing;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}
	
	public void setErrorMessage(String message) {
		this.errorMessage = message;
	}
}
