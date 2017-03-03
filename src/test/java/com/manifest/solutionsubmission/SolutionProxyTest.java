package com.manifest.solutionsubmission;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.manifest.service.SolutionService.SolutionSubmission;

public class SolutionProxyTest {
	
	private SolutionProxy solutionProxy;
	
	private String sourceCode;
	private String methodName;
	private Class<?>[] parameterClasses;
	
	
	@Before
	public void setup() {
		methodName = "mockMethod";
		sourceCode = "public class Solution { public String " + methodName + "(Integer num){ return \"MOCK_RESULT\"; } }";
		parameterClasses = new Class<?>[]{ Integer.class };
		
		solutionProxy = new SolutionProxyBuilder().build(new SolutionSubmission(){{
													setSourceCode(sourceCode);
													setMethodName(methodName);
													setMethodName(methodName);
												}});
	}
	
	@Test
	public void invokeMethod_parametersMatch_returnsAValueOfTheExpectedType() throws Exception {
		String returnedResult = (String)solutionProxy.invokeSolution(new Object[] { 2 });
		assertEquals("MOCK_RESULT", returnedResult);
	}
	
	@Test(expected=Exception.class)
	public void invokeMethod_suppliedParametersDoNotMatchSolutionMethodSignature_throwsAnException() throws Exception {
		solutionProxy.invokeSolution(new Object[] {});
	}

}
