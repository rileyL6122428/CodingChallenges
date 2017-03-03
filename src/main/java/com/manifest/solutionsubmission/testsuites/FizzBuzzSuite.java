package com.manifest.solutionsubmission.testsuites;

import com.manifest.solutionsubmission.SolutionTest;
import com.manifest.solutionsubmission.TestSuite;

public class FizzBuzzSuite extends TestSuite {

	public FizzBuzzSuite() {
		super("fizzbuzz");
	}
	
	{
		addTest(new SolutionTest<String>(new Integer[]{ 1 }, ""));
		addTest(new SolutionTest<String>(new Integer[]{ 3 }, "fizz"));
		addTest(new SolutionTest<String>(new Integer[]{ 5 }, "buzz"));
		addTest(new SolutionTest<String>(new Integer[]{ 15 }, "fizzbuzz"));
	}

}
