package com.manifest.solutionsubmission;

import com.manifest.server.service.SolutionService.SolutionSubmission;

public class SolutionProxyBuilder {	
	public SolutionProxy build(SolutionSubmission submission) {
		String sourceCode = submission.getSourceCode();
		Class<?>[] parameterClasses = submission.getParameterClasses();
		String methodName = submission.getMethodName();
		
		return new SolutionProxy(sourceCode, methodName, parameterClasses);
	}
}
