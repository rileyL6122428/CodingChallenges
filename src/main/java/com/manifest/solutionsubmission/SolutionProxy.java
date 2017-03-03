package com.manifest.solutionsubmission;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.mdkt.compiler.InMemoryJavaCompiler;

public class SolutionProxy {
	
	private Object solutionInstance;
	private Method targetedMethod;
	
	public SolutionProxy(String sourceCode, String methodName, Class<?>[] parameterTypes) {
		try {
			Class<?> solutionClass = InMemoryJavaCompiler.compile("Solution", sourceCode);
			solutionInstance = solutionClass.newInstance();
			targetedMethod = solutionClass.getMethod(methodName, parameterTypes);
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	public Object invokeSolution(Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return targetedMethod.invoke(solutionInstance, args);
	}
}
