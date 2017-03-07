package com.manifest.solutionsubmission.testsuites;

import com.manifest.solutionsubmission.SolutionTest;
import com.manifest.solutionsubmission.TestSuite;

public class CharacterCountSuite extends TestSuite {
	public CharacterCountSuite() {
		super("characterCount");
	}
	
	{
		addTest(new SolutionTest<Integer>(new Object[]{ 'c', "abcdefg" }, 1));
		
		addTest(new SolutionTest<Integer>(new Object[]{ 'c', "abcdcfc" }, 3));
		
		addTest(new SolutionTest<Integer>(new Object[]{ 'b', "babbab" }, 4));
		
		addTest(new SolutionTest<Integer>(new Object[]{ 'A', "babbab" }, 0));
		
		addTest(new SolutionTest<Integer>(new Object[]{ 'z', "" }, 0));
		
		addTest(new SolutionTest<Integer>(new Object[]{ 'A', "AaBbAA" }, 3));
	}
}
