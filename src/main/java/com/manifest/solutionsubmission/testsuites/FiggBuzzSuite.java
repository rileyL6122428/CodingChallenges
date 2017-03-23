package com.manifest.solutionsubmission.testsuites;

import com.manifest.solutionsubmission.SolutionTest;
import com.manifest.solutionsubmission.TestSuite;

public class FiggBuzzSuite extends TestSuite {

	public FiggBuzzSuite() {
		super("figgbuzz");
	}
	
	{
		addTest(new SolutionTest<String>(new Integer[]{ 1 }, ""));
		addTest(new SolutionTest<String>(new Integer[]{ 3 }, "figg"));
		addTest(new SolutionTest<String>(new Integer[]{ 5 }, "buzz"));
		addTest(new SolutionTest<String>(new Integer[]{ 15 }, "figgbuzz"));
	}

}
