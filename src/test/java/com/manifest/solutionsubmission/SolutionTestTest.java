package com.manifest.solutionsubmission;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import com.google.common.base.Joiner;
import com.manifest.solutionsubmission.SolutionTest.TestResult;

import static org.mockito.Mockito.*;

public class SolutionTestTest {
	private final String EXPECTED_VALUE = "MOCK_EXPECTED_VALUE";
	private final String NOT_EXPECTED_VALUE = "NOT_EXPECTED_VALUE";
	
	private SolutionProxy solutionProxy;

	@Before
	public void setup() {		
		solutionProxy = Mockito.mock(SolutionProxy.class);
	}
	
	@Test
	public void execute_expectedMatchesActual_returnsPassingResult() throws Exception {
		Object[] methodParameters = new Object[]{ "ARG1" };
		SolutionTest<String> solutionTest = new SolutionTest<String>(methodParameters, EXPECTED_VALUE);
		when(solutionProxy.invokeSolution(any())).thenReturn(EXPECTED_VALUE);
		
		TestResult testResult = solutionTest.execute(solutionProxy);
		
		assertTrue(testResult.getSolutionPasses());
	}
	
	@Test
	public void execute_valuesDontMatchWithOneInput_returnsFailingResult() throws Exception{
		Object[] methodParameters = new Object[]{ "ARG1" };
		SolutionTest<String> solutionTest = new SolutionTest<String>(methodParameters, EXPECTED_VALUE);
		when(solutionProxy.invokeSolution(any())).thenReturn(NOT_EXPECTED_VALUE);
		String expectedErrorMessage = "Test failed. \n" + 
			"Expected value: " + EXPECTED_VALUE + "\n" +
			"Actual value: " + NOT_EXPECTED_VALUE + "\n" +
			"Inputs: " + Joiner.on(", ").join(methodParameters);
		
		TestResult testResult = solutionTest.execute(solutionProxy);
		
		assertFalse(testResult.getSolutionPasses());
		assertEquals(expectedErrorMessage, testResult.getErrorMessage());
	}
	
	@Test
	public void execute_valuesDontMatchWithMultiplsInputs_returnsFailingResult() throws Exception{
		Object[] methodParameters = new Object[]{ "ARG1", "ARG2" };
		SolutionTest<String> solutionTest = new SolutionTest<String>(methodParameters, EXPECTED_VALUE);
		when(solutionProxy.invokeSolution(any())).thenReturn(NOT_EXPECTED_VALUE);
		String expectedErrorMessage = "Test failed. \n" + 
			"Expected value: " + EXPECTED_VALUE + "\n" +
			"Actual value: " + NOT_EXPECTED_VALUE + "\n" +
			"Inputs: " + Joiner.on(", ").join(methodParameters);
		
		TestResult testResult = solutionTest.execute(solutionProxy);
		
		assertFalse(testResult.getSolutionPasses());
		assertEquals(expectedErrorMessage, testResult.getErrorMessage());
	}
	
	@Test
	public void execute_solutionInvocationThrowsException_returnsFailingResult() throws Exception {
		Object[] methodParameters = new Object[]{ "ARG1" };
		SolutionTest<String> solutionTest = new SolutionTest<String>(methodParameters, EXPECTED_VALUE);
		when(solutionProxy.invokeSolution(any())).thenThrow(new IllegalArgumentException("MOCK EXCEPTION MESSAGE"));
		
		TestResult testResult = solutionTest.execute(solutionProxy);
		
		assertFalse(testResult.getSolutionPasses());
		assertEquals("MOCK EXCEPTION MESSAGE", testResult.getErrorMessage());
	}
}
