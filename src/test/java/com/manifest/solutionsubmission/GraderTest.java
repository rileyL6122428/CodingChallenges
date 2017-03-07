package com.manifest.solutionsubmission;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
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
	private TestSuite testSuite;
	private SolutionProxy solutionProxy;
	private SolutionProxyFactory solutionProxyFactory;
	
	@Before
	public void setup() {
		runner = mock(TestRunner.class);		
		suiteRetriever = mock(TestSuiteRetriever.class);
		solutionSubmission = mock(SolutionSubmission.class);
		testSuite = mock(TestSuite.class);
		solutionProxy = mock(SolutionProxy.class);
		solutionProxyFactory = mock(SolutionProxyFactory.class);
		
		grader = new Grader();
		grader.setTestRunner(runner);
		grader.setTestSuiteRetriever(suiteRetriever);
		grader.setSolutionProxyBuilder(solutionProxyFactory);
	}
	

	@Test
	public void grade_gradingDoesNotThrow_delegatesToTheRunnerAndSuiteRetriever() throws Exception {
		SolutionGrade expectedGrade = mock(SolutionGrade.class);
		when(solutionProxyFactory.tryNewSolutionProxy(any())).thenReturn(solutionProxy);
		when(suiteRetriever.getSuite(any())).thenReturn(testSuite);
		when(runner.runTests(any(), any())).thenReturn(expectedGrade);
		
		SolutionGrade actualGrade = grader.grade(solutionSubmission);
		
		verify(solutionProxyFactory).tryNewSolutionProxy(solutionSubmission);
		verify(suiteRetriever).getSuite(solutionSubmission);
		verify(runner).runTests(testSuite, solutionProxy);
		assertEquals(expectedGrade, actualGrade);
	}
	
	@Test
	public void grade_gradingThrowsClassFormatError_returnsFailingGradeWithErrorMessage() throws Exception {
		when(solutionProxyFactory.tryNewSolutionProxy(any())).thenThrow(new ClassFormatError("MOCK_ERROR_MESSAGE"));
		
		SolutionGrade grade = grader.grade(solutionSubmission);
		
		assertFalse(grade.isPassing());
		assertThat(grade.getErrorMessage(), containsString("MOCK_ERROR_MESSAGE"));
	}
	
	@Test
	public void grade_gradingThrowsNoSuchMethodException_returnsFailingGradeWithErrorMessage() throws Exception {
		when(solutionProxyFactory.tryNewSolutionProxy(any())).thenThrow(new NoSuchMethodException("MOCK_ERROR_MESSAGE"));
		
		SolutionGrade grade = grader.grade(solutionSubmission);
		
		assertFalse(grade.isPassing());
		assertThat(grade.getErrorMessage(), containsString("MOCK_ERROR_MESSAGE"));
	}
	
	@Test
	public void grade_gradingThrowsUnforseenThrowable_returnsNullAndPrintsStackTrace() throws Exception {
		ArrayIndexOutOfBoundsException unexpectedException = mock(ArrayIndexOutOfBoundsException.class);
		doNothing().when(unexpectedException).printStackTrace();
		when(solutionProxyFactory.tryNewSolutionProxy(any())).thenThrow(unexpectedException);
		
		SolutionGrade grade = grader.grade(solutionSubmission);
		
		assertNull(grade);
		verify(unexpectedException).printStackTrace();
	}
}
