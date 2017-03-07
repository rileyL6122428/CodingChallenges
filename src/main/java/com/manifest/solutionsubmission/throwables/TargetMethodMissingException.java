package com.manifest.solutionsubmission.throwables;

public class TargetMethodMissingException extends Throwable {
	public static TargetMethodMissingException newException(NoSuchMethodException noSuchMethodException) {
		String expectedTarget = noSuchMethodException.getMessage();
		
		String errorMessage = "Expected interface was not present in solution class. " +
							"Please implement a method with the following signature: " +
							expectedTarget;
		
		return new TargetMethodMissingException(errorMessage);
	}
	
	public TargetMethodMissingException(String errorMessage) {
		super(errorMessage);
	}
}
