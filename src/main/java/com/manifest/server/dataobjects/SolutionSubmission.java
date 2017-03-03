package com.manifest.server.dataobjects;

public class SolutionSubmission {
	private String sourceCode;
	private Class<?>[] parameterClasses;
	private String methodName;
	private String challengeName;
	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	public Class<?>[] getParameterClasses() {
		return parameterClasses;
	}
	public void setParameterClasses(Class<?>[] parameterClasses) {
		this.parameterClasses = parameterClasses;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getChallengeName() {
		return challengeName;
	}
	public void setChallengeName(String challengeName) {
		this.challengeName = challengeName;
	}
}
