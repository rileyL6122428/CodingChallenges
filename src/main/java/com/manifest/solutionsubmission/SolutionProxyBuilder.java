package com.manifest.solutionsubmission;

public class SolutionProxyBuilder {
	private String sourceCode;
	private String methodName;
	private Class<?>[] parameterTypes;
	public SolutionProxyBuilder setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
		return this;
	}
	public SolutionProxyBuilder setMethodName(String methodName) {
		this.methodName = methodName;
		return this;
	}
	public SolutionProxyBuilder setParameterTypes(Class<?>[] parameterTypes) {
		this.parameterTypes = parameterTypes;
		return this;
	}
	public SolutionProxy build() {
		return new SolutionProxy(sourceCode, methodName, parameterTypes);
	}
}
