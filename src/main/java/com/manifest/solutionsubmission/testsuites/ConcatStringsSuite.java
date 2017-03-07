package com.manifest.solutionsubmission.testsuites;

import com.manifest.solutionsubmission.SolutionTest;
import com.manifest.solutionsubmission.TestSuite;

public class ConcatStringsSuite extends TestSuite {
	public ConcatStringsSuite() {
		super("concatStrings");
	}
	
	{
		addTest(new SolutionTest<String>(new Object[] {new String[]{"abc", "def"}}, "abcdef"));
		
		addTest(new SolutionTest<String>(new Object[] {new String[]{"abc", "def", "ghi"}}, "abcdefghi"));
		
		addTest(new SolutionTest<String>(new Object[]{new String[]{"a", "de", "ghi"}}, "adeghi"));
		
		addTest(new SolutionTest<String>(new Object[]{new String[]{ }}, ""));
		
		addTest(new SolutionTest<String>(new Object[]{new String[]{ "", "" }}, ""));
	}
}
