package com.manifest.solutionsubmission;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import com.manifest.solutionsubmission.testsuites.AllTests;

public class Grader {
	private int suiteId;
	
	public Grader(int suiteId) {
		this.suiteId = suiteId;
	}
	
	public Result grade() {
		return JUnitCore.runClasses(AllTests.class);
	}
	
	public static void main(String[] args) {
		Grader grader = new Grader(1);
		Result result = grader.grade();
		System.out.println("Was successful: " + result.wasSuccessful());
		System.out.println("ERROR: " + result.getFailures().get(0));
	}
}
