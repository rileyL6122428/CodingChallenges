package com.manifest.solutionsubmission;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.manifest.solutionsubmission.SolutionTest.TestResult;

public class TestSuiteTest {
	
	private TestSuite testSuite;
	
	private List<SolutionTest> tests;
	
	@Before
	public void setup() {
		testSuite = new TestSuite();
		
		tests = Arrays.asList(
			mock(SolutionTest.class),
			mock(SolutionTest.class),
			mock(SolutionTest.class),
			mock(SolutionTest.class),
			mock(SolutionTest.class)
		);
		
		tests.stream().forEach(testSuite::addTest);
	}

	@Test
	public void forEachTest__callTheSuppliedConsumer() {
		SolutionProxy solutionProxy = mock(SolutionProxy.class);
		TestResult testResult = mock(TestResult.class);		
		tests.stream().forEach((test) -> when(test.execute(any())).thenReturn(testResult));
		
		testSuite.forEachTest((test) -> test.execute(solutionProxy));
		
		tests.stream().forEach((test) -> verify(test).execute(solutionProxy));
	}
}
