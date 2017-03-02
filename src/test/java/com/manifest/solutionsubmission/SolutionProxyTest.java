package com.manifest.solutionsubmission;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SolutionProxyTest {
	
	private SolutionProxy solutionProxy;
	
	private String sourceCode;
	private String methodName;
	private Class<?>[] parameterTypes;
	
	
	@Before
	public void setup() {
		methodName = "mockMethod";
		sourceCode = "public class Solution { public String " + methodName + "(Integer num){ return \"MOCK_RESULT\"; } }";
		parameterTypes = new Class<?>[]{ Integer.class };
		
		solutionProxy = new SolutionProxyBuilder()
							.setMethodName(methodName)
							.setSourceCode(sourceCode)
							.setParameterTypes(parameterTypes)
							.build();
	}
	
	@Test
	public void invokeMethod_parametersMatch_returnsAValueOfTheExpectedType() throws Exception {
		String returnedResult = (String)solutionProxy.invokeMethod(new Object[] { 2 });
		assertEquals("MOCK_RESULT", returnedResult);
	}
	
	@Test(expected=Exception.class)
	public void invokeMethod_suppliedParametersDoNotMatchSolutionMethodSignature_throwsAnException() throws Exception {
		solutionProxy.invokeMethod(new Object[] {});
	}

}
