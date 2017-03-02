package com.manifest.solutionsubmission;

import java.lang.reflect.InvocationTargetException;

public class SolutionTest<ExpectedValueType> {
	
	private Object[] methodParameters;
	private ExpectedValueType expectedValue;
	
	public SolutionTest(Object[] methodParameters, ExpectedValueType expectedValue) {
		this.methodParameters = methodParameters;
		this.expectedValue = expectedValue;
	}
	
	public TestResult execute(SolutionProxy solutionProxy) {
		TestResult result = new TestResult();
		result.expected = expectedValue; 
		
		try {
			ExpectedValueType actualValue = (ExpectedValueType)solutionProxy.invokeMethod(methodParameters);
			result.passed = actualValue.equals(expectedValue);
			
		} catch (Exception e) {
			result.passed = false;
			result.exceptionThrown = true;
		}
		
		return result;
	}
	
	class TestResult {
		public boolean passed;
		public ExpectedValueType actual;
		public ExpectedValueType expected;
		public boolean exceptionThrown;
	}
}
