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
		
		try {
			result.setValues(expectedValue, actualValue(solutionProxy));
		} catch (Exception e) {
			result.setExceptionThrown(true);
		}
		
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
		
		public void setValues(ExpectedValueType expectedValue, ExpectedValueType actualValue) {
			this.expectedValue = expectedValue;
			this.actualValue = actualValue;
			
			this.passedTest = this.getActualValue().equals(this.expectedValue);
		}
		
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
			if(exceptionThrown) passedTest = false;
		}
		public boolean getPassedTest() {
			return passedTest;
		}
		public void setPassedTest(boolean passedTest) {
			this.passedTest = passedTest;
		}
	}
}
