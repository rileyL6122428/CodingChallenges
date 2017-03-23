package com.manifest.solutionsubmission.testsuites;

import com.manifest.solutionsubmission.SolutionTest;
import com.manifest.solutionsubmission.TestSuite;

public class SplashindromeSuite extends TestSuite {
	public SplashindromeSuite() {
		super("splashindrome");
	}
	
	{
		addTest(new SolutionTest<Boolean>(new String[]{ "" }, true));
		addTest(new SolutionTest<Boolean>(new String[]{ "a" }, true));
		addTest(new SolutionTest<Boolean>(new String[]{ "aa" }, true));
		addTest(new SolutionTest<Boolean>(new String[]{ "aba" }, true));
		addTest(new SolutionTest<Boolean>(new String[]{ "abba" }, true));
		addTest(new SolutionTest<Boolean>(new String[]{ "ababa" }, true));
		addTest(new SolutionTest<Boolean>(new String[]{ "cbabc" }, true));
		
		addTest(new SolutionTest<Boolean>(new String[]{ "ac" }, false));
		addTest(new SolutionTest<Boolean>(new String[]{ "abc" }, false));
		addTest(new SolutionTest<Boolean>(new String[]{ "abab" }, false));
		addTest(new SolutionTest<Boolean>(new String[]{ "abca" }, false));
		addTest(new SolutionTest<Boolean>(new String[]{ "abbca" }, false));
		addTest(new SolutionTest<Boolean>(new String[]{ "ababac" }, false));
	}
}
