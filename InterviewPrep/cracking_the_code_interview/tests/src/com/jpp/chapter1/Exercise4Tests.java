package com.jpp.chapter1;

import junit.framework.Assert;

import org.junit.Test;

public class Exercise4Tests {

	
	@Test
	public void areAnagrams() {
		char[] str1 = new char[] {'r', 'o', 'm', 'a'};
		char[] str2 = new char[] {'a', 'm', 'o', 'r'};
		boolean areAnagrams = Exercise4.areAnagrams(str1, str2);
		Assert.assertTrue(areAnagrams);
	}
	
	
	
	@Test
	public void areNotAnagrams() {
		char[] str1 = new char[] {'r', 'o', 'm', 'a'};
		char[] str2 = new char[] {'a', 'm', 'o', 'o'};
		boolean areAnagrams = Exercise4.areAnagrams(str1, str2);
		Assert.assertFalse(areAnagrams);
	}
	
	
	@Test
	public void areAnagramsLong() {
		char[] str1 = "ARGENTINO".toCharArray();
		char[] str2 = "IGNORANTE".toCharArray();
		boolean areAnagrams = Exercise4.areAnagrams(str1, str2);
		Assert.assertTrue(areAnagrams);
	}
}
