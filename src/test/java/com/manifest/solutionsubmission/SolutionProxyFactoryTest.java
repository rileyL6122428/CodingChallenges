package com.manifest.solutionsubmission;

import org.junit.Before;
import org.junit.Test;

import com.manifest.server.dataobjects.SolutionSubmission;

public class SolutionProxyFactoryTest {
	
	private SolutionProxyFactory solutionProxyFactory;
	
	@Before
	public void setup() {
		solutionProxyFactory = new SolutionProxyFactory();
	}

	@Test(expected=ClassFormatError.class)
	public void tryNewSolutionProxy_sourceCodeContainsCompilationErrors_throwsException() throws Exception {
		solutionProxyFactory.tryNewSolutionProxy(
			new SolutionSubmission(){{
				setSourceCode("ERROR_RIDDEN_SOURCE_CODE");
				setMethodName("fizzBuzz");
				setParameterClasses(new Class<?>[] { Integer.class });
			}}
		);
	}
	
	@Test(expected=NoSuchMethodException.class)
	public void tryNewSolutionProxy_sourceCodeDoesNotContainMethodName_throwsException() throws Exception {
		solutionProxyFactory.tryNewSolutionProxy(
			new SolutionSubmission(){{
				setSourceCode("public class Solution { public String fizzBuzz(Integer num){ return \"MOCK_RESULT\"; } }");
				setMethodName("NON_MATCHING_METHOD_NAME");
				setParameterClasses(new Class<?>[] { Integer.class });
			}}
		);
	}
}
