package com.manifest.solutionsubmission.throwables;

public class SolutionCompilationException extends Throwable {
	public static SolutionCompilationException newException(ClassFormatError classFormatError) {
		String errorMessage = classFormatError.getMessage() + 
								": You solution may have failed to compile. Please check that your source code " +
								"contains a public Solution class and that no syntax errors are present.";
		
		return new SolutionCompilationException(errorMessage);
	}
	
	public SolutionCompilationException(String errorMessage) {
		super(errorMessage);
	}
}
