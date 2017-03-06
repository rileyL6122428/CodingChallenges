package com.manifest.solutionsubmission;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.manifest.server.dataobjects.SolutionSubmission;

public class SolutionProxyTest {
	
	private SolutionProxy solutionProxy;
	
	private String sourceCode;
	private String methodName;
	private Class<?>[] parameterClasses;	
	
	@Before
	public void setup() throws Exception {
		methodName = "mockMethod";
		sourceCode = "public class Solution { public String " + methodName + "(Integer num){ return \"MOCK_RESULT\"; } }";
		parameterClasses = new Class<?>[]{ Integer.class };
		
		solutionProxy = new SolutionProxyFactory().tryNewSolutionProxy(
			new SolutionSubmission(){{
				setSourceCode(sourceCode);
				setMethodName(methodName);
				setParameterClasses(parameterClasses);
			}}
		);
	}
	
	
	@Test
	public void invokeMethod_parametersMatch_returnsAValueOfTheExpectedType() throws Exception {
		String solutionResult = (String)solutionProxy.invokeSolution(new Object[] { 2 });
		assertEquals("MOCK_RESULT", solutionResult);
	}
	
	@Test(expected=Exception.class)
	public void invokeMethod_suppliedParametersDontMatchMethodSignature_throwsAnException() throws Exception {
		solutionProxy.invokeSolution(new Object[] {});
	}

}
