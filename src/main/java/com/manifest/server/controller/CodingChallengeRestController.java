package com.manifest.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.manifest.server.model.CodingChallenge;
import com.manifest.server.service.CodingChallengeService;

@RestController
public class CodingChallengeRestController {
	@Autowired
	private CodingChallengeService codingChallengeService;

	public List<CodingChallenge> index(HttpServletResponse response) {
		List<CodingChallenge> challenges = getCodingChallengeService().all();
		
		response.setStatus(HttpServletResponse.SC_OK);
		return challenges;
	}

	
	
	public CodingChallengeService getCodingChallengeService() {
		return codingChallengeService;
	}

	public void setCodingChallengeService(CodingChallengeService codingChallengeService) {
		this.codingChallengeService = codingChallengeService;
	}
	
	
}
