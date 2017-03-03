package com.manifest.server.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

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
