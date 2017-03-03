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
	
	public Object invokeMethod(Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return targetedMethod.invoke(solutionInstance, args);
	}
	
	public static void main(String[] args) {
		SolutionProxy fizzBuzzSolution = new SolutionProxyBuilder()
											.setMethodName("fizzBuzz")
											.setParameterTypes(new Class<?>[]{ Integer.class })
											.setSourceCode("public class Solution { public String fizzBuzz(Integer num){ return \"FIZZBUZZ\"; } }")
											.build();
		
		
		try {
			String output = (String)fizzBuzzSolution.invokeMethod(new Object[]{ 2 });
			System.out.println(output);
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}