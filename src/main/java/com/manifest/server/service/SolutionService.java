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
			long challengeId = submitSolutionRequest.getChallengeId();
			String sourceCode = submitSolutionRequest.getSourceCode();
			
			CodingChallenge codingChallenge = codingChallengeRepository.findOne(challengeId);
			
			SolutionSubmission solutionSubmission = new SolutionSubmission();
			solutionSubmission.setSourceCode(sourceCode);
			solutionSubmission.setChallengeName(codingChallenge.getName());
			solutionSubmission.setMethodName(codingChallenge.getName());
			
			List<ParameterType> parameterTypes = codingChallenge.getParameterTypes();
			Class<?>[] parameterClasses = new Class<?>[parameterTypes.size()];
			for (int idx = 0; idx < parameterClasses.length; idx++) {
				parameterClasses[idx] = Class.forName(parameterTypes.get(idx).getLibraryName());
			}
			solutionSubmission.setParameterClasses(parameterClasses);
			
			return solutionReviewer.reviewSubmission(solutionSubmission);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			SolutionGrade grade = new SolutionGrade();
			grade.setPassesTests(false);
			return grade;
		}
	}
}
