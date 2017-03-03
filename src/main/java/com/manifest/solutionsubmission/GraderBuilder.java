package com.manifest.solutionsubmission;

import com.manifest.server.dataobjects.SolutionSubmission;


public class GraderBuilder {
	public Grader buildGrader(SolutionSubmission solutionSubmission) {
		SolutionProxy solutionProxy = new SolutionProxyBuilder().build(solutionSubmission);
		TestRunner testRunner = new TestRunner(solutionProxy);
		
		Grader grader = new Grader(solutionSubmission.getChallengeName());
		grader.setTestRunner(testRunner);
		
		return grader;
	}
}
