package com.manifest.solutionsubmission.testsuites;

import org.junit.runners.Suite.SuiteClasses;


@SuiteClasses({ FizzBuzzTest.class })
public class FizzBuzzTestSuite extends SolutionTestSuite {
	static {
		CHALLENGE_NAME = "FIZZ BUZZ";
	}
}
