package com.manifest.server.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.google.common.collect.Lists;
import com.manifest.server.model.CodingChallenge;
import com.manifest.server.repository.CodingChallengeRepository;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CodingChallengeControllerTest {
	
	private HttpServletResponse responseMock;
	
    private CodingChallengeRepository challengeRepositoryMock;
    private CodingChallengeRestController challengeRestController;
    
    CodingChallenge codingChallenge1, codingChallenge2;
    List<CodingChallenge> codingChallenges;
    
    @Before
    public void setup() {
    	responseMock = Mockito.mock(HttpServletResponse.class);
    	challengeRepositoryMock = Mockito.mock(CodingChallengeRepository.class);
    	
    	challengeRestController = new CodingChallengeRestController();
    	challengeRestController.setCodingChallengeRepository(challengeRepositoryMock);
    	
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
    	
    	codingChallenges = Arrays.asList(challenge1, challenge2);
    }
    
    @Test
    public void index__sendChallenges() throws Exception {
    	when(challengeRepositoryMock.findAll()).thenReturn(codingChallenges);
    	List<CodingChallenge> sentChallenges = Lists.newArrayList(challengeRestController.index(responseMock));
    	
    	
    	verify(responseMock).setStatus(HttpServletResponse.SC_OK);
    	verify(challengeRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(challengeRepositoryMock);
        
        assertSentChallengesMatchCodingChallenges(sentChallenges);
    }
    
    private void assertSentChallengesMatchCodingChallenges(List<CodingChallenge> sentChallenges) {
    	for(int idx = 0; idx < sentChallenges.size(); idx++) {
        	CodingChallenge codingChallenge = codingChallenges.get(idx);
        	CodingChallenge sentChallenge = sentChallenges.get(idx); 
        	
        	assertEquals(codingChallenge.getName(), sentChallenge.getName());
        	assertEquals(codingChallenge.getDescription(), sentChallenge.getDescription());
        	assertEquals(codingChallenge.getId(), sentChallenge.getId());
        	assertEquals(codingChallenge.getDifficulty(), sentChallenge.getDifficulty());
        }
    }
}
