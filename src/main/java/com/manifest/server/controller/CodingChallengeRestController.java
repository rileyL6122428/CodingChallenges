package com.manifest.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.manifest.server.model.CodingChallenge;
import com.manifest.server.model.ParameterType;
import com.manifest.server.repository.CodingChallengeRepository;

@RestController
public class CodingChallengeRestController {
	
	@Autowired
	private CodingChallengeRepository codingChallengeRepository;

	@GetMapping(path = "/api/coding-challenges", produces = "application/json")
	public Iterable<CodingChallenge> index(HttpServletResponse response) {
		Iterable<CodingChallenge> challenges = codingChallengeRepository.findAll();
		
		response.setStatus(HttpServletResponse.SC_OK);
		return challenges;
	}
	
	@GetMapping(path = "/api/coding-challenge/{id}", produces = "application/json")
	public CodingChallenge show(@PathVariable("id") long id, HttpServletResponse response) {
		CodingChallenge codingChallenge = codingChallengeRepository.findOne(id);

		if(codingChallenge == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);			
		}
		
		return codingChallenge;
	}

	public CodingChallengeRepository getCodingChallengeRepository() {
		return codingChallengeRepository;
	}


	public void setCodingChallengeRepository(CodingChallengeRepository challengeRepository) {
		this.codingChallengeRepository = challengeRepository;
	}


	
	
	
}
