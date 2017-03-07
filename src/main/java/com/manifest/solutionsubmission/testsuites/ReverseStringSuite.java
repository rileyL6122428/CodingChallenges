package com.manifest.solutionsubmission.testsuites;

import com.manifest.solutionsubmission.SolutionTest;
import com.manifest.solutionsubmission.TestSuite;

public class ReverseStringSuite extends TestSuite {
	public ReverseStringSuite() {
		super("reverseString");
	}
	
	{
		addTest(new SolutionTest<String>(new Object[]{""}, ""));
		
		addTest(new SolutionTest<String>(new Object[]{"a"}, "a"));
		
		addTest(new SolutionTest<String>(new Object[]{"abc"}, "cba"));
		
		addTest(new SolutionTest<String>(new Object[]{"abcb"}, "bcba"));
		
		addTest(new SolutionTest<String>(new Object[]{"abcba"}, "abcba"));
		
		addTest(new SolutionTest<String>(new Object[]{"abcbaaa"}, "aaabcba"));
	}
}
