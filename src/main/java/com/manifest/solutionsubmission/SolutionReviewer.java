package com.manifest.solutionsubmission;

import com.manifest.service.SolutionService.SolutionSubmission;


public class SolutionReviewer {
	
	public SolutionGrade reviewSubmission(SolutionSubmission solutionSubmission) {
		SolutionProxy solutionProxy = new SolutionProxyBuilder().build(solutionSubmission);
		Grader grader = new Grader(solutionSubmission.challengeName);
		TestRunner testRunner = new TestRunner(solutionProxy);
		grader.setTestRunner(testRunner);
		
		return grader.grade();
	}
	
}
