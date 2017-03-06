package com.manifest.solutionsubmission;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import com.manifest.solutionsubmission.SolutionTest.TestResult;

import static org.mockito.Mockito.*;

public class SolutionTestTest {
	
	private SolutionTest<String> solutionTest;
	Object[] methodParameters;
	String expectedValue;
	
	private SolutionProxy solutionProxy;

	@Before
	public void setup() {
		methodParameters = new Object[]{ "ARG1" };
		expectedValue = "MOCK_EXPECTED_VALUE";
		solutionTest = new SolutionTest<String>(methodParameters, expectedValue);
		
		solutionProxy = Mockito.mock(SolutionProxy.class);
	}
	
	@Test
	public void execute_expectedMatchesActual_returnsPassingResult() throws Exception {
		when(solutionProxy.invokeSolution(any())).thenReturn(expectedValue);
		
		TestResult testResult = solutionTest.execute(solutionProxy);
		
		assertTrue(testResult.getPassedTest());
		assertFalse(testResult.isExceptionThrown());
	}
	
	@Test
	public void execute_expectedDoesNotMatchesActual_returnsFailingResult() throws Exception{
		when(solutionProxy.invokeSolution(any())).thenReturn("NOT THE EXPECTED VALUE");
		
		TestResult testResult = solutionTest.execute(solutionProxy);
		
		assertFalse(testResult.getPassedTest());
		assertFalse(testResult.isExceptionThrown());
	}
	
	@Test
	public void execute_solutionInvocationThrowsException_returnsFailingResult() throws Exception {
		when(solutionProxy.invokeSolution(any())).thenThrow(Exception.class);
		
		TestResult testResult = solutionTest.execute(solutionProxy);
		
		assertFalse(testResult.getPassedTest());
		assertTrue(testResult.isExceptionThrown());
	}
}
