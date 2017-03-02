package com.manifest.solutionsubmission;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.manifest.solutionsubmission.testsuites.SolutionTestSuite;

public class TestSuiteRetrieverTest {
	
	private TestSuiteRetriever suiteRetriever;
	
	static class SolutionTestSuiteMock extends SolutionTestSuite {
		static { CHALLENGE_NAME = "MOCK_CHALLENGE_NAME"; }
	}
	
	@Before
	public void setup() {
		suiteRetriever = new TestSuiteRetriever(new HashMap<String, Class<?>>());
		suiteRetriever.addSuite(SolutionTestSuiteMock.class);
	}
	
	
	@Test
	public void retreiveSuit_suiteFound_returnsAClass() {
		Class<?> testSuiteClass = suiteRetriever.get(SolutionTestSuiteMock.CHALLENGE_NAME);
		assertEquals(SolutionTestSuiteMock.class, testSuiteClass);
	}
	
	@Test
	public void retreiveSuit_suiteNotFound_returnsNull() {
		Class<?> testSuiteClass = suiteRetriever.get("UNMATCHED_CHALLENGE_NAME");
		assertNull(testSuiteClass);
	}


}
