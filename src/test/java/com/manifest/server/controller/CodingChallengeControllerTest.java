package com.manifest.server.controller;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.manifest.server.model.CodingChallenge;
import com.manifest.server.service.CodingChallengeService;

import java.util.Arrays;
import java.util.Date;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@ContextConfiguration(classes = {TestContext.class, WebApplicationContext.class})
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CodingChallengeControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;
	 
    @Autowired
    private CodingChallengeService challengeServiceMock;
    
//    @Ignore
    @Test
    public void index_challengesFound_sendChallenges() throws Exception {
    	CodingChallenge challenge1 = new CodingChallenge();
    	challenge1.setName("EXAMPLE NAME 1");
    	challenge1.setDescription("EXAMPLE DESCRIPTION 1");
    	challenge1.setDifficulty("EXAMPLE DIFFICULTY 1");
    	challenge1.setId((long)1);
    	challenge1.setDateCreated(new Date(1));
    	
    	CodingChallenge challenge2 = new CodingChallenge();
    	challenge2.setName("EXAMPLE NAME 2");
    	challenge2.setDescription("EXAMPLE DESCRIPTION 2");
    	challenge2.setDifficulty("EXAMPLE DIFFICULTY 2");
    	challenge2.setId((long)2);
    	challenge2.setDateCreated(new Date(2));
    	
    	when(challengeServiceMock.all()).thenReturn(Arrays.asList(challenge1, challenge2));
    	
    	mockMvc.perform(get("/api/codingChallenges"))
	        .andExpect(status().isOk())
	        .andExpect(content().contentType("application/json"))
	        .andExpect(jsonPath("$", hasSize(2)))
	        .andExpect(jsonPath("$[0].id", is(1)))
	        .andExpect(jsonPath("$[0].description", is("EXAMPLE DESCRIPTION 1")))
	        .andExpect(jsonPath("$[0].name", is("EXAMPLE NAME 1")))
	        .andExpect(jsonPath("$[0].difficulty", is("EXAMPLE DIFFICULTY 1")));
    	
    	verify(challengeServiceMock, times(1)).all();
        verifyNoMoreInteractions(challengeServiceMock);
    }
}
