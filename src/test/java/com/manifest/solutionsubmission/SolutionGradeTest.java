package com.manifest.solutionsubmission;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.*;

import com.manifest.solutionsubmission.SolutionTest.TestResult;

public class SolutionGradeTest {
	
	private List<TestResult> testResults;
	
	@Before
	public void setup() {
		testResults = new ArrayList<TestResult>();
	}
	
	@Test
	public void failingGrade_suppliedWithErrorMessage_returnsFailingGradeWithErrorMessage() {
		RuntimeException exception = new RuntimeException("MOCK EXCEPTION MESSAGE");
		
		SolutionGrade grade = SolutionGrade.failingGrade(exception);
		
		assertEquals("MOCK EXCEPTION MESSAGE", grade.getErrorMessage());
		assertFalse(grade.isPassing());
	}
	
	@Test
	public void constructor_suppliedFailingTest_gradeIsFailing() {
		TestResult passingResult = mock(TestResult.class);
		when(passingResult.getSolutionPasses()).thenReturn(true);
		testResults.add(passingResult);
		
		TestResult failingResult = mock(TestResult.class);
		when(failingResult.getSolutionPasses()).thenReturn(false);
		testResults.add(failingResult);
		
		SolutionGrade grade = new SolutionGrade(testResults);
		
		assertFalse(grade.isPassing());
	}
	
	@Test
	public void constructor_suppliedOnlyPassingTests_gradeIsPassing() {
		TestResult passingResult1 = mock(TestResult.class);
		when(passingResult1.getSolutionPasses()).thenReturn(true);
		testResults.add(passingResult1);
		
		TestResult passingResult2 = mock(TestResult.class);
		when(passingResult2.getSolutionPasses()).thenReturn(true);
		testResults.add(passingResult2);
		
		SolutionGrade grade = new SolutionGrade(testResults);
		
		assertTrue(grade.isPassing());
	}
}
