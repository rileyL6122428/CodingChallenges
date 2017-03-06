package com.manifest.solutionsubmission;

import java.lang.reflect.Method;

import org.mdkt.compiler.InMemoryJavaCompiler;

import com.manifest.server.dataobjects.SolutionSubmission;

public class SolutionProxyFactory {
	public SolutionProxy tryNewSolutionProxy(SolutionSubmission submission) throws Exception {
		Class<?> solutionClass = InMemoryJavaCompiler.compile("Solution", submission.getSourceCode());
		Object solutionInstance = solutionClass.newInstance();
		Method targetedMethod = solutionClass.getMethod(submission.getMethodName(), submission.getParameterClasses());
		
		SolutionProxy solutionProxy = new SolutionProxy();
		solutionProxy.setSolutionInstance(solutionInstance);
		solutionProxy.setTargetedMethod(targetedMethod);
		
		return solutionProxy;
	}
}
