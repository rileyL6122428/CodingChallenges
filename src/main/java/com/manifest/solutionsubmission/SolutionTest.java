package com.manifest.solutionsubmission;

import java.lang.reflect.InvocationTargetException;

import com.google.common.base.Joiner;


public class SolutionTest<ExpectedValueType> {
	
	private Object[] methodParameters;
	private ExpectedValueType expectedValue;
	
	public SolutionTest(Object[] methodParameters, ExpectedValueType expectedValue) {
		this.methodParameters = methodParameters;
		this.expectedValue = expectedValue;
	}
	
	public TestResult execute(SolutionProxy solutionProxy) {
		try {
			return new TestResult(actualValue(solutionProxy));
		} catch (Exception exception) {
			return new TestResult(exception);
		}
	}
	
	private ExpectedValueType actualValue(SolutionProxy solutionProxy) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return (ExpectedValueType)solutionProxy.invokeSolution(methodParameters);
	}
	
	class TestResult {
		private boolean solutionPasses;
		private ExpectedValueType actualValue;
		private String errorMessage;
		
		TestResult() {}
		
		TestResult(ExpectedValueType actualValue) {
			this.actualValue = actualValue;
			this.solutionPasses = this.actualValue.equals(expectedValue);
			if(!solutionPasses) setErrorMessage();
		}
		
		private void setErrorMessage() {
			this.errorMessage = "Test failed. \n" + 
			"Expected value: " + expectedValue + "\n" +
			"Actual value: " + this.actualValue + "\n" +
			"Inputs: " + Joiner.on(", ").join(methodParameters);
		}
		
		TestResult(Throwable throwable) {
			this.errorMessage = throwable.getMessage();
			this.solutionPasses = false;
		}
		
		public ExpectedValueType getActualValue() {
			return actualValue;
		}
		
		public ExpectedValueType getExpectedValue() {
			return expectedValue;
		}
		
		public boolean getSolutionPasses() {
			return solutionPasses;
		}
		
		public String getErrorMessage() {
			return this.errorMessage;
		}
	}
}
