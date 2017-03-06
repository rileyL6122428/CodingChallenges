package com.manifest.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.manifest.server.dataobjects.SolutionSubmissionRequest;
import com.manifest.server.service.SolutionService;
import com.manifest.solutionsubmission.SolutionGrade;

@Controller
public class SolutionController {
	
	@Autowired
	private SolutionService solutionService;	
	
	@PostMapping(path = "/api/solution", produces = "application/json")
	public ResponseEntity<?> submitSolution(@RequestBody SolutionSubmissionRequest requestBody){
		SolutionGrade solutionGrade = solutionService.reviewSolution(requestBody);
		
		if(solutionGrade != null) {
			return new ResponseEntity<SolutionGrade>(solutionGrade, HttpStatus.OK);			
		} else {
			return new ResponseEntity<Exception>(new Exception("INTERNAL SERVER ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public void setSolutionService(SolutionService solutionService) {
		this.solutionService = solutionService;
	}
}



