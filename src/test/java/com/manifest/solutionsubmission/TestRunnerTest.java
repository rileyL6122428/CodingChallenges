package com.manifest.solutionsubmission;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.manifest.solutionsubmission.SolutionTest.TestResult;

public class TestRunnerTest {
	
	TestRunner testRunner;
	
	TestSuite testSuite;
	SolutionTest test1, test2;
	SolutionProxy solutionProxy;
	
	
	@Before
	public void setup() {
		test1 = mock(SolutionTest.class);
		test2 = mock(SolutionTest.class);
		testSuite = new TestSuite("MOCK_CHALLENGE_NAME");
		testSuite.addTest(test1);
		testSuite.addTest(test2);
		
		solutionProxy = mock(SolutionProxy.class);
		testRunner = new TestRunner();
	}

	@Test
	public void runTests_notEveryTestPasses_returnsAFailingGrade() {
		TestResult failingTest1Result = mock(TestResult.class);
		when(failingTest1Result.getSolutionPasses()).thenReturn(false);
		TestResult passingTest2Result = mock(TestResult.class);
		when(passingTest2Result.getSolutionPasses()).thenReturn(true);
		
		when(test1.execute(any())).thenReturn(failingTest1Result);
		when(test2.execute(any())).thenReturn(passingTest2Result);
		
		SolutionGrade grade = testRunner.runTests(testSuite, solutionProxy); 
		
		assertFalse(grade.isPassing());
	}
	
	@Test
	public void runTests_allTestsPass_returnsAPassingGrade() {
		TestResult passingTest1Result = mock(TestResult.class);
		when(passingTest1Result.getSolutionPasses()).thenReturn(true);
		TestResult passingTest2Result = mock(TestResult.class);
		when(passingTest2Result.getSolutionPasses()).thenReturn(true);
		
		when(test1.execute(any())).thenReturn(passingTest1Result);
		when(test2.execute(any())).thenReturn(passingTest2Result);
		
		SolutionGrade grade = testRunner.runTests(testSuite, solutionProxy); 
		
		assertTrue(grade.isPassing());
	}

}
