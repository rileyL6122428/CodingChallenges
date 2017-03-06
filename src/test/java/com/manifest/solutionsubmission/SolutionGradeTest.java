package com.manifest.solutionsubmission;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SolutionGradeTest {
	
	@Test
	public void failingGrade_suppliedWithErrorMessage_returnsFailingGradeWithErrorMessage() {
		RuntimeException exception = new RuntimeException("MOCK EXCEPTION MESSAGE");
		
		SolutionGrade grade = SolutionGrade.failingGrade(exception);
		
		assertEquals("MOCK EXCEPTION MESSAGE", grade.getErrorMessage());
		assertFalse(grade.passesTests());
	}
	

}
