package com.manifest.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manifest.server.dataobjects.SolutionSubmission;
import com.manifest.server.dataobjects.SolutionSubmissionRequest;
import com.manifest.server.model.CodingChallenge;
import com.manifest.server.model.ParameterType;
import com.manifest.server.repository.CodingChallengeRepository;
import com.manifest.solutionsubmission.SolutionGrade;
import com.manifest.solutionsubmission.SolutionReviewer;

@Service
public class SolutionService {
	
	@Autowired
	CodingChallengeRepository codingChallengeRepository;
	SolutionReviewer solutionReviewer = new SolutionReviewer();
	
	public SolutionGrade reviewSolution(SolutionSubmissionRequest submitSolutionRequest)  {
		try {
			SolutionSubmission submission = formatRequest(submitSolutionRequest);
			return solutionReviewer.reviewSubmission(submission);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return failingGrade();
		}
	}
	
	private SolutionSubmission formatRequest(SolutionSubmissionRequest submitSolutionRequest) throws ClassNotFoundException {
		CodingChallenge codingChallenge = codingChallengeRepository.findOne(submitSolutionRequest.getChallengeId());			
		SolutionSubmission solutionSubmission = new SolutionSubmission();
		
		solutionSubmission.setSourceCode(submitSolutionRequest.getSourceCode());
		solutionSubmission.setChallengeName(codingChallenge.getName());
		solutionSubmission.setMethodName(codingChallenge.getName());
		solutionSubmission.setParameterClasses(convertTypesToClasses(codingChallenge.getParameterTypes()));
		
		return solutionSubmission;
	}
	
	private Class<?>[] convertTypesToClasses(List<ParameterType> parameterTypes) throws ClassNotFoundException {
		Class<?>[] parameterClasses = new Class<?>[parameterTypes.size()];
		
		for (int idx = 0; idx < parameterClasses.length; idx++) {
			parameterClasses[idx] = Class.forName(parameterTypes.get(idx).getLibraryName());
		}
		
		return parameterClasses;
	}
	
	private SolutionGrade failingGrade() {
		SolutionGrade grade = new SolutionGrade();
		grade.setPassesTests(false);
		return grade;
	}
}
