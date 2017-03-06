package com.manifest.solutionsubmission;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.mdkt.compiler.InMemoryJavaCompiler;

import com.manifest.server.dataobjects.SolutionSubmission;

public class SolutionProxy {
	
	private Object solutionInstance;
	private Method targetedMethod;
	
	public Object invokeSolution(Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return targetedMethod.invoke(solutionInstance, args);
	}

	public void setSolutionInstance(Object solutionInstance) {
		this.solutionInstance = solutionInstance;
	}

	public void setTargetedMethod(Method targetedMethod) {
		this.targetedMethod = targetedMethod;
	}
}
