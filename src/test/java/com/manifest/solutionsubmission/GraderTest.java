package com.manifest.solutionsubmission;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GraderTest {

	private Grader grader;
	private TestRunner runnerMock;
	TestSuiteRetriever suiteRetriever;
	
	@Before
	public void setup() {
		grader = new Grader("MOCK_CHALLENGE_NAME");
		
		runnerMock = Mockito.mock(TestRunner.class);
		grader.setTestRunner(runnerMock);
		
		suiteRetriever = Mockito.mock(TestSuiteRetriever.class);
		grader.setTestSuiteRetriever(suiteRetriever);
	}
	

	@Test
	public void grade__delegatesToTheRunnerAndSuiteRetriever() {
		TestSuite testSuite = new TestSuite();
		SuiteTestResult testResult = new SuiteTestResult();
		
		when(suiteRetriever.getSuite(anyString())).thenReturn(testSuite);
		when(runnerMock.runSuite(any())).thenReturn(testResult);
		
		SuiteTestResult returnedTestResult = grader.grade();
		
		verify(suiteRetriever).getSuite("MOCK_CHALLENGE_NAME");
		verify(runnerMock).runSuite(testSuite);
		assertEquals(testResult, returnedTestResult);
	}
	
	
}
