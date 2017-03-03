package com.manifest.solutionsubmission;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.manifest.solutionsubmission.SolutionTest.TestResult;

import static org.mockito.Mockito.*;

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
		testRunner = new TestRunner(solutionProxy);
	}

	@Test
	public void runTests_notEveryTestPasses_returnsAFailingGrade() {
		TestResult failingTest1Result = test1.new TestResult(){{ passedTest = false; }};
		TestResult passingTest2Result = test2.new TestResult(){{ passedTest = true; }};
		
		when(test1.execute(any())).thenReturn(failingTest1Result);
		when(test2.execute(any())).thenReturn(passingTest2Result);
		
		SolutionGrade grade = testRunner.runSuite(testSuite); 
		
		assertFalse(grade.passesTests);
	}
	
	@Test
	public void runTests_allTestsPass_returnsAPassingGrade() {
		TestResult passingTest1Result = test1.new TestResult(){{ passedTest = true; }};
		TestResult passingTest2Result = test2.new TestResult(){{ passedTest = true; }};
		
		when(test1.execute(any())).thenReturn(passingTest1Result);
		when(test2.execute(any())).thenReturn(passingTest2Result);
		
		SolutionGrade grade = testRunner.runSuite(testSuite); 
		
		assertTrue(grade.passesTests);
	}

}
