package com.manifest.server.controller;

import java.lang.reflect.Method;
import java.util.List;

import org.mdkt.compiler.InMemoryJavaCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.manifest.server.model.Solution;
import com.manifest.server.repository.CodingChallengeRepository;
import com.manifest.server.repository.SolutionRepository;

@Controller
public class SolutionController {
	
	@Autowired
	private SolutionRepository solutionRepository;
	
	@GetMapping(path = "/api/solutions", produces = "application/json")
	public ResponseEntity<Iterable<Solution>> testThoseSolutions() {
		Iterable<Solution> solutions = solutionRepository.findAll();
		
		return new ResponseEntity<>(solutions, HttpStatus.OK);
	}
	
	@PostMapping(path = "/api/solution-fizzbuzz", produces = "application/json")
	public ResponseEntity<SolutionReport> testMethod(@RequestBody SolutionSubmission solutionSubmission) {
		SolutionReport solutionReport = new SolutionReport();
		
		try {
			Class<?> solutionClass = InMemoryJavaCompiler.compile("Solution", solutionSubmission.getSourceCode());			
			Object solution = solutionClass.newInstance();
			Method fizzbuzz = solutionClass.getMethod("fizzbuzz");
			String result = (String) fizzbuzz.invoke(solution); 
			
			if(result.equals("FIZZBUZZ")) { solutionReport.setPassed(true); } 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(solutionReport, HttpStatus.OK);
	}
}

class SolutionSubmission {
	private String sourceCode;

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
}

class SolutionReport {
	private boolean passed = false;

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	
}