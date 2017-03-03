package com.manifest.solutionsubmission;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestSuite {
	
	public final String CHALLENGE_NAME;
	
	private List<SolutionTest> tests;
	
	public TestSuite(String challengeName) {
		this.CHALLENGE_NAME = challengeName;
		this.tests = new ArrayList<SolutionTest>();
	}
	
	public void addTest(SolutionTest test) {
		tests.add(test);
	}
	
	public void forEachTest(Consumer<SolutionTest> consumer) {
		tests.stream().forEach(consumer);
	}
}
