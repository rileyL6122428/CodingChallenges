package com.manifest.server.controller;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.manifest.server.model.CodingChallenge;
import com.manifest.server.repository.CodingChallengeRepository;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CodingChallengeControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;
	private HttpServletResponse responseMock;
	
    private CodingChallengeRepository challengeRepositoryMock;
    private CodingChallengeRestController challengeRestController;
    
    @Before
    public void setup() {
    	responseMock = Mockito.mock(HttpServletResponse.class);
    	challengeRepositoryMock = Mockito.mock(CodingChallengeRepository.class);
    	
    	challengeRestController = new CodingChallengeRestController();
    	challengeRestController.setCodingChallengeRepository(challengeRepositoryMock);
    }
    
    @Test
    public void index_challengesFound_sendChallenges() throws Exception {
    	CodingChallenge challenge1 = new CodingChallenge();
    	challenge1.setName("EXAMPLE NAME 1");
    	challenge1.setDescription("EXAMPLE DESCRIPTION 1");
    	challenge1.setDifficulty("EXAMPLE DIFFICULTY 1");
    	challenge1.setId((long)1);
    	
    	CodingChallenge challenge2 = new CodingChallenge();
    	challenge2.setName("EXAMPLE NAME 2");
    	challenge2.setDescription("EXAMPLE DESCRIPTION 2");
    	challenge2.setDifficulty("EXAMPLE DIFFICULTY 2");
    	challenge2.setId((long)2);
    	
    	when(challengeRepositoryMock.findAll()).thenReturn(Arrays.asList(challenge1, challenge2));
    	Iterable<CodingChallenge> sentChallenges = challengeRestController.index(responseMock);
    	
    	
    	verify(responseMock).setStatus(HttpServletResponse.SC_OK);;
    	verify(challengeRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(challengeRepositoryMock);
    }
}

//mockMvc.perform(get("/api/codingChallenges"))
//.andExpect(status().isOk())
//.andExpect(content().contentType("application/json"))
//.andExpect(jsonPath("$", hasSize(2)))
//.andExpect(jsonPath("$[0].id", is(1)))
//.andExpect(jsonPath("$[0].description", is("EXAMPLE DESCRIPTION 1")))
//.andExpect(jsonPath("$[0].name", is("EXAMPLE NAME 1")))
//.andExpect(jsonPath("$[0].difficulty", is("EXAMPLE DIFFICULTY 1")));