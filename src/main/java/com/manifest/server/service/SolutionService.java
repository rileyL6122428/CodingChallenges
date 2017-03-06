package com.manifest.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manifest.server.dataobjects.SolutionSubmission;
import com.manifest.server.dataobjects.SolutionSubmissionRequest;
import com.manifest.server.translator.SolutionRequestTranslator;
import com.manifest.solutionsubmission.Grader;
import com.manifest.solutionsubmission.GraderBuilder;
import com.manifest.solutionsubmission.SolutionGrade;

@Service
public class SolutionService {
	
	@Autowired
	private SolutionRequestTranslator requestConverter;
	private Grader grader = new Grader();
	
	public SolutionGrade reviewSolution(SolutionSubmissionRequest submitSolutionRequest)  {
		try {
			SolutionSubmission submission = requestConverter.convertRequest(submitSolutionRequest);
			return grader.grade(submission);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return failingGrade();
		}
	}
	
	private SolutionGrade failingGrade() {
		SolutionGrade grade = new SolutionGrade();
		grade.setPassesTests(false);
		return grade;
	}
}
