package com.manifest.solutionsubmission;

import com.manifest.service.SolutionService.SolutionSubmission;


public class SolutionReviewer {
	SolutionSubmissionAdapter submissionAdapter = new SolutionSubmissionAdapter();
	
	public SolutionGrade processSolution(SolutionSubmission solutionSubmission) {
		Grader grader = new Grader(solutionSubmission.challengeName);
		
		SolutionProxy solutionProxy = new SolutionProxyBuilder().build(solutionSubmission);
		TestRunner runner = new TestRunner(solutionProxy);
		
		grader.setTestRunner(runner);
		
		return grader.grade();
	}
	
	public static SolutionGrade processSolution(ReviewCriteria reviewCriteria) {
		Grader grader = new Grader(reviewCriteria.challengeName);
		
		SolutionProxy solutionProxy = new SolutionProxyBuilder().build(reviewCriteria);
		TestRunner runner = new TestRunner(solutionProxy);
		
		grader.setTestRunner(runner);
		
		return grader.grade();
	}
	
//	public SolutionGrade processSolution(SolutionSubmission solutionSubmission) {
//		try {
//			ReviewCriteria reviewCriteria = submissionAdapter.adaptSubmission(solutionSubmission);
//			Grader grader = new Grader(reviewCriteria.challengeName);
//			
//			SolutionProxy solutionProxy = new SolutionProxyBuilder().build(reviewCriteria);
//			TestRunner runner = new TestRunner(solutionProxy);
//			
//			grader.setTestRunner(runner);
//			
//			return grader.grade();
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	public static class ReviewCriteria {
		public String sourceCode;
		public String challengeName;
		public String methodName;
		public Class<?>[] parameterTypes;
	}
}
