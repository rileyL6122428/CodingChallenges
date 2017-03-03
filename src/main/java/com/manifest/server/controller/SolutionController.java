package com.manifest.server.controller;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.hibernate.Hibernate;
import org.mdkt.compiler.InMemoryJavaCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.manifest.server.model.CodingChallenge;
import com.manifest.server.model.Solution;
import com.manifest.server.repository.SolutionRepository;
import com.manifest.solutionsubmission.SolutionGrade;
import com.manifest.solutionsubmission.SolutionReviewer;
import com.manifest.solutionsubmission.SolutionReviewer.ReviewCriteria;

@Controller
public class SolutionController {
	
	@Autowired
	private SolutionRepository solutionRepository;
	
	//PROTOTYPE CODE
	@GetMapping(path = "/api/solutions", produces = "application/json")
	public ResponseEntity<CodingChallenge> testThoseSolutions() {
		Solution solution = solutionRepository.findOne(1L);
		CodingChallenge challenge = solution.getCodingChallenge();
		return new ResponseEntity<>(challenge, HttpStatus.OK);
	}
	
	@PostMapping(path = "/api/solution", produces = "application/json")
	public ResponseEntity<SolutionGrade> testMethod(@RequestBody SolutionSubmission solutionSubmission) throws ClassNotFoundException {
		SolutionReviewer solutionReviewer = new SolutionReviewer();
		SolutionGrade solutionGrade = solutionReviewer.processSolution(solutionSubmission);
		
		return new ResponseEntity<SolutionGrade>(solutionGrade, HttpStatus.OK);
	}
	
	
	public static class SolutionSubmission {
		public String sourceCode;
		public String[] parameterTypes;
		public String methodName;
		public String challengeName;
	}
}



