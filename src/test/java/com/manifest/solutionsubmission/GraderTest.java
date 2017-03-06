package com.manifest.solutionsubmission;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.manifest.server.dataobjects.SolutionSubmission;

public class GraderTest {

	private Grader grader;
	
	private TestRunner runner;
	private TestSuiteRetriever suiteRetriever;
	private SolutionSubmission solutionSubmission;
	private SolutionGrade solutionGrade;
	private TestSuite testSuite;
	private SolutionProxy solutionProxy;
	private SolutionProxyFactory solutionProxyFactory;
	
	@Before
	public void setup() {
		runner = mock(TestRunner.class);		
		suiteRetriever = mock(TestSuiteRetriever.class);
		solutionSubmission = mock(SolutionSubmission.class);
		solutionGrade = mock(SolutionGrade.class);
		testSuite = mock(TestSuite.class);
		solutionProxy = mock(SolutionProxy.class);
		solutionProxyFactory = mock(SolutionProxyFactory.class);
		
		grader = new Grader();
		grader.setTestRunner(runner);
		grader.setTestSuiteRetriever(suiteRetriever);
		grader.setSolutionProxyBuilder(solutionProxyFactory);
	}
	

	@Test
	public void grade__delegatesToTheRunnerAndSuiteRetriever() throws Exception {
		when(solutionProxyFactory.tryNewSolutionProxy(any())).thenReturn(solutionProxy);
		when(suiteRetriever.getSuite(any())).thenReturn(testSuite);
		when(runner.runTests(any(), any())).thenReturn(solutionGrade);
		
		SolutionGrade returnedTestResult = grader.grade(solutionSubmission);
		
		verify(solutionProxyFactory).tryNewSolutionProxy(solutionSubmission);
		verify(suiteRetriever).getSuite(solutionSubmission);
		verify(runner).runTests(testSuite, solutionProxy);
		assertEquals(solutionGrade, returnedTestResult);
	}
	
	
}
