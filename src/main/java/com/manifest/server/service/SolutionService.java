package com.manifest.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manifest.server.dataobjects.SolutionSubmission;
import com.manifest.server.dataobjects.SolutionSubmissionRequest;
import com.manifest.server.translator.SolutionRequestTranslator;
import com.manifest.solutionsubmission.Grader;
import com.manifest.solutionsubmission.SolutionGrade;

@Service
public class SolutionService {
	
	@Autowired
	private SolutionRequestTranslator requestConverter;
	private Grader grader = new Grader();
	
	public SolutionGrade reviewSolution(SolutionSubmissionRequest submitSolutionRequest)  {
		try {
			SolutionSubmission submission = requestConverter.tryConvertRequest(submitSolutionRequest);
			return grader.grade(submission);
			
			//TODO refactor to return error message to front end (THIS ERROR IS NOT CAUSED BY SOLUTION SUBMISSION)
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return SolutionGrade.failingGrade();
		}
	}
}
