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
import com.manifest.solutionsubmission.SolutionReviewer.ReviewData;

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
		
		ReviewData reviewData = new ReviewData();
		reviewData.challengeName = solutionSubmission.challengeName;
		reviewData.methodName = solutionSubmission.methodName;
		reviewData.sourceCode = solutionSubmission.sourceCode;
		
		Class<?>[] parameterTypes = new Class<?>[solutionSubmission.parameterTypes.length];
		for (int idx = 0; idx < parameterTypes.length; idx++) {
			String parameterTypeString = solutionSubmission.parameterTypes[idx];
			parameterTypes[idx] = Class.forName(parameterTypeString);
		}
		reviewData.parameterTypes = parameterTypes;
		
		SolutionGrade solutionGrade = SolutionReviewer.processSolution(reviewData);
		
		return new ResponseEntity<SolutionGrade>(solutionGrade, HttpStatus.OK);
	}
	
	//PROTOTYPE CODE
//	@PostMapping(path = "/api/solution-fizzbuzz", produces = "application/json")
//	public ResponseEntity<SolutionReport> testMethod(@RequestBody SolutionSubmission solutionSubmission) {
//		SolutionReport solutionReport = new SolutionReport();
//		
//		try {
//			Class<?> solutionClass = InMemoryJavaCompiler.compile("Solution", solutionSubmission.getSourceCode());			
//			Object solution = solutionClass.newInstance();
//			Method fizzbuzz = solutionClass.getMethod("fizzbuzz");
//			String result = (String) fizzbuzz.invoke(solution); 
//			
//			if(result.equals("FIZZBUZZ")) { solutionReport.setPassed(true); } 
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return new ResponseEntity<>(solutionReport, HttpStatus.OK);
//	}
}



class SolutionSubmission {
	public String sourceCode;
	public String[] parameterTypes;
	public String methodName;
	public String challengeName;
}

//class SolutionReport {
//	private boolean passed = false;
//}