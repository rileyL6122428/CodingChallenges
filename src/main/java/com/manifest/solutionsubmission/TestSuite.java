package com.manifest.solutionsubmission;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestSuite {
	private List<SolutionTest> tests;
	
	public TestSuite() {
		this.tests = new ArrayList<SolutionTest>();
	}
	
	public void addTest(SolutionTest test) {
		tests.add(test);
	}
	
	public void forEachTest(Consumer<SolutionTest> consumer) {
		tests.stream().forEach(consumer);
	}
	
	class SuiteTestResult {
		public boolean passesTests;
		public String failureMessage;
	}
}
