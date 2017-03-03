package com.manifest.solutionsubmission;

import com.manifest.service.SolutionService.SolutionSubmission;
import com.manifest.solutionsubmission.SolutionReviewer.ReviewCriteria;

public class SolutionProxyBuilder {
	private String sourceCode;
	private String methodName;
	private Class<?>[] parameterTypes;
	public SolutionProxyBuilder setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
		return this;
	}
	public SolutionProxyBuilder setMethodName(String methodName) {
		this.methodName = methodName;
		return this;
	}
	public SolutionProxyBuilder setParameterTypes(Class<?>[] parameterTypes) {
		this.parameterTypes = parameterTypes;
		return this;
	}
	public SolutionProxy build() {
		return new SolutionProxy(sourceCode, methodName, parameterTypes);
	}
	
	public SolutionProxy build(ReviewCriteria details) {
		this.setSourceCode(details.sourceCode)
			.setParameterTypes(details.parameterTypes)
			.setMethodName(details.methodName);
		
		return build();
	}
	
	public SolutionProxy build(SolutionSubmission submission) {
		this.setSourceCode(submission.sourceCode)
			.setParameterTypes(submission.parameterClasses)
			.setMethodName(submission.methodName);
		
		return build();
	}
}
