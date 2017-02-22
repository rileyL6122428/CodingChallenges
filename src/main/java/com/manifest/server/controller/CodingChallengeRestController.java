package com.manifest.server.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manifest.server.model.CodingChallenge;
import com.manifest.server.repository.CodingChallengeRepository;

@RestController
public class CodingChallengeRestController {
	@Autowired
	private CodingChallengeRepository codingChallengeService;
	
	@Autowired
	private CodingChallengeRepository codingChallengeRepository;

	@GetMapping(path = "/api/coding-challenges", produces = "application/json")
	public Iterable<CodingChallenge> index(HttpServletResponse response) {
		Iterable<CodingChallenge> challenges = codingChallengeRepository.findAll();
		
		response.setStatus(HttpServletResponse.SC_OK);
		return challenges;
	}
	
	
	public CodingChallengeRepository getCodingChallengeService() {
		return codingChallengeService;
	}

	public void setCodingChallengeService(CodingChallengeRepository codingChallengeService) {
		this.codingChallengeService = codingChallengeService;
	}


	public CodingChallengeRepository getCodingChallengeRepository() {
		return codingChallengeRepository;
	}


	public void setCodingChallengeRepository(CodingChallengeRepository challengeRepository) {
		this.codingChallengeRepository = challengeRepository;
	}
	
	
}
