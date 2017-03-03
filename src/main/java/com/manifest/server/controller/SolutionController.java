package com.manifest.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.manifest.server.dataobjects.SolutionSubmissionRequest;
import com.manifest.server.model.CodingChallenge;
import com.manifest.server.model.Solution;
import com.manifest.server.repository.SolutionRepository;
import com.manifest.server.service.SolutionService;
import com.manifest.solutionsubmission.SolutionGrade;
import com.manifest.solutionsubmission.SolutionReviewer;

@Controller
public class SolutionController {
	
	@Autowired
	private SolutionService solutionService;
	
	
	@PostMapping(path = "/api/solution", produces = "application/json")
	public ResponseEntity<SolutionGrade> submitSolution(@RequestBody SolutionSubmissionRequest requestBody){
		SolutionGrade solutionGrade = solutionService.reviewSolution(requestBody);
		return new ResponseEntity<SolutionGrade>(solutionGrade, HttpStatus.OK);
	}
}



