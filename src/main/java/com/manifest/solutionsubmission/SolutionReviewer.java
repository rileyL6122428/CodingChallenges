package com.manifest.solutionsubmission;

import com.manifest.server.dataobjects.SolutionSubmission;



public class SolutionReviewer {
	
	private GraderBuilder graderBuilder = new GraderBuilder();
	
	public SolutionGrade reviewSubmission(SolutionSubmission solutionSubmission) {
		Grader grader = graderBuilder.buildGrader(solutionSubmission);
		return grader.grade();
	}
	
}
