package com.jpp.chapter1;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Exercise3Tests {

	@Test
	public void removeDuplicatesWithDuplicates() {
		char[] s = new char[] { 'a', 'b', 'c', 'd', 'a', 'f' };
		Exercise3.removeDuplicates(s);
		Assert.assertEquals(s[0], 'a');
		Assert.assertEquals(s[1], 'b');
		Assert.assertEquals(s[2], 'c');
		Assert.assertEquals(s[3], 'd');
		Assert.assertEquals(s[4], 'f');
		Assert.assertEquals(s[5], ' ');
		System.out.println(s);
	}

}
