package com.manifest.solutionsubmission;

public class SolutionGrade {
	private boolean passesTests;
	
	public static SolutionGrade failingGrade() {
		SolutionGrade grade = new SolutionGrade();
		grade.setPassesTests(false);
		return grade;
	}

	public void setPassesTests(boolean passesTests) {
		this.passesTests = passesTests;
	}

	public boolean isPassesTests() {
		return passesTests;
	}
	
}
