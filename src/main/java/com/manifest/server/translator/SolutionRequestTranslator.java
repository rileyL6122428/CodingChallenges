package com.manifest.server.translator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manifest.server.dataobjects.SolutionSubmission;
import com.manifest.server.dataobjects.SolutionSubmissionRequest;
import com.manifest.server.model.CodingChallenge;
import com.manifest.server.model.ParameterType;
import com.manifest.server.repository.CodingChallengeRepository;

@Component
public class SolutionRequestTranslator {
	
	@Autowired
	CodingChallengeRepository codingChallengeRepository;
	
	public SolutionRequestTranslator(CodingChallengeRepository codingChallengeRepository) {
		this.codingChallengeRepository = codingChallengeRepository;
	}
	
	public SolutionSubmission tryConvertRequest(SolutionSubmissionRequest submitSolutionRequest) throws ClassNotFoundException {
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
}
