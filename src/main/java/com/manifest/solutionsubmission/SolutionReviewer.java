package com.manifest.solutionsubmission;

public class SolutionReviewer {
	public static SolutionGrade processSolution(ReviewData reviewData) {
		Grader grader = new Grader(reviewData.challengeName);
		
		SolutionProxy solutionProxy = new SolutionProxyBuilder().build(reviewData);
		TestRunner runner = new TestRunner(solutionProxy);
		
		grader.setTestRunner(runner);
		
		return grader.grade();
	}
	
	public static class ReviewData {
		public String sourceCode;
		public String challengeName;
		public String methodName;
		public Class<?>[] parameterTypes;
	}
}
