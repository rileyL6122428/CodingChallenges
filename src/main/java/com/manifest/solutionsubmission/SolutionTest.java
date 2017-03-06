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
		
		result.setExpectedValue(expectedValue); 
		
		try {
			result.setActualValue(actualValue(solutionProxy));
		} catch (Exception e) {
			result.setExceptionThrown(true);
		}
		
		//TODO logic Refactor into TestResultClass
		result.setPassedTest(!result.isExceptionThrown() && result.getActualValue().equals(expectedValue));
		
		return result;
	}
	
	private ExpectedValueType actualValue(SolutionProxy solutionProxy) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return (ExpectedValueType)solutionProxy.invokeSolution(methodParameters);
	}
	
	class TestResult {
		private boolean passedTest;
		private ExpectedValueType actualValue;
		private ExpectedValueType expectedValue;
		private boolean exceptionThrown;
		
		public ExpectedValueType getActualValue() {
			return actualValue;
		}
		public void setActualValue(ExpectedValueType actualValue) {
			this.actualValue = actualValue;
		}
		public ExpectedValueType getExpectedValue() {
			return expectedValue;
		}
		public void setExpectedValue(ExpectedValueType expectedValue) {
			this.expectedValue = expectedValue;
		}
		public boolean isExceptionThrown() {
			return exceptionThrown;
		}
		public void setExceptionThrown(boolean exceptionThrown) {
			this.exceptionThrown = exceptionThrown;
		}
		public boolean isPassedTest() {
			return passedTest;
		}
		public void setPassedTest(boolean passedTest) {
			this.passedTest = passedTest;
		}
	}
}
