package com.manifest.server.controller;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Ignore;
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
    	
    	codingChallenge1 = new CodingChallenge();
    	codingChallenge1.setName("EXAMPLE NAME 1");
    	codingChallenge1.setDescription("EXAMPLE DESCRIPTION 1");
    	codingChallenge1.setDifficulty("EXAMPLE DIFFICULTY 1");
    	codingChallenge1.setId((long)1);
    	
    	codingChallenge2 = new CodingChallenge();
    	codingChallenge2.setName("EXAMPLE NAME 2");
    	codingChallenge2.setDescription("EXAMPLE DESCRIPTION 2");
    	codingChallenge2.setDifficulty("EXAMPLE DIFFICULTY 2");
    	codingChallenge2.setId((long)2);
    	
    	codingChallenges = Arrays.asList(codingChallenge1, codingChallenge2);
    }
    
    @Test
    public void index__sendsChallenges() throws Exception {
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
    
    @Test
    public void show_challengeFound_sendsChallenge() {
    	when(challengeRepositoryMock.findOne(anyLong())).thenReturn(codingChallenge1);
    	
    	CodingChallenge sentChallenge = challengeRestController.show(codingChallenge1.getId(), responseMock);
    	
    	verify(responseMock).setStatus(HttpServletResponse.SC_OK);
    	verify(challengeRepositoryMock, times(1)).findOne(codingChallenge1.getId());
        verifyNoMoreInteractions(challengeRepositoryMock);
        
        assertEquals(codingChallenge1.getName(), sentChallenge.getName());
    	assertEquals(codingChallenge1.getDescription(), sentChallenge.getDescription());
    	assertEquals(codingChallenge1.getId(), sentChallenge.getId());
    	assertEquals(codingChallenge1.getDifficulty(), sentChallenge.getDifficulty());
    }
    
    @Test
    public void show_challengeNotFound_sendsErrorMsg() {
    	when(challengeRepositoryMock.findOne(anyLong())).thenReturn(null);
    	
    	CodingChallenge sentChallenge = challengeRestController.show(-1L, responseMock);
    	
    	verify(responseMock).setStatus(HttpServletResponse.SC_NOT_FOUND);
    	verify(challengeRepositoryMock, times(1)).findOne(-1L);
        verifyNoMoreInteractions(challengeRepositoryMock);
        
        assertNull(sentChallenge);
    }
}
