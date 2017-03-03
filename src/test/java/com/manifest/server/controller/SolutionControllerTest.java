package com.manifest.server.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

import com.manifest.server.dataobjects.SolutionSubmissionRequest;
import com.manifest.server.service.SolutionService;
import com.manifest.solutionsubmission.SolutionGrade;

public class SolutionControllerTest {

	private SolutionController solutionController;
	private SolutionService solutionService;
	
	@Before
	public void setup() {
		solutionController = new SolutionController();
		
		solutionService = mock(SolutionService.class);
		solutionController.setSolutionService(solutionService);
	}
	
	@Test
	public void submitSolution__returnsGradeReturnedBySolutionService() {
		SolutionGrade grade = new SolutionGrade();
		when(solutionService.reviewSolution(any())).thenReturn(grade);
		SolutionSubmissionRequest submissionRequest = new SolutionSubmissionRequest();
		
		ResponseEntity<SolutionGrade> response = solutionController.submitSolution(submissionRequest);
		
		verify(solutionService).reviewSolution(submissionRequest);
		assertEquals(grade, response.getBody());
	}

}
