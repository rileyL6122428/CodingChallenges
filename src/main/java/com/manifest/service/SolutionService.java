package com.manifest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public SolutionGrade reviewSolution(long challengeId, String sourceCode)  {
		try {
			CodingChallenge codingChallenge = codingChallengeRepository.findOne(challengeId);
			
			SolutionSubmission solutionSubmission = new SolutionSubmission();
			solutionSubmission.sourceCode = sourceCode;
			solutionSubmission.challengeName = codingChallenge.getName();
			solutionSubmission.methodName = codingChallenge.getName();
			
			List<ParameterType> parameterTypes = codingChallenge.getParameterTypes();
			Class<?>[] parameterClasses = new Class<?>[parameterTypes.size()];
			for (int idx = 0; idx < parameterClasses.length; idx++) {
				parameterClasses[idx] = Class.forName(parameterTypes.get(idx).getLibraryName());
			}
			solutionSubmission.parameterClasses = parameterClasses;
			
			return solutionReviewer.reviewSubmission(solutionSubmission);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return new SolutionGrade().setPassesTests(false);
		}
	}
	
	public static class SolutionSubmission {
		public String sourceCode;
		public Class<?>[] parameterClasses;
		public String methodName;
		public String challengeName;
	}
}
