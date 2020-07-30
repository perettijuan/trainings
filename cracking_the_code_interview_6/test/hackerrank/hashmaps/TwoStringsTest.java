package hackerrank.hashmaps;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TwoStringsTest {
	
	@Test
	public void test1() {
		String s1 = "hello";
		String s2 = "world";
		
		assertEquals("YES", TwoStrings.twoStrings(s1, s2));
	}

	@Test
	public void test2() {
		String s1 = "hi";
		String s2 = "world";
		
		assertEquals("NO", TwoStrings.twoStrings(s1, s2));
	}
	
	@Test
	public void test3() {
		String s1 = "hello";
		String s2 = "uyhhelo";
		
		assertEquals("YES", TwoStrings.twoStrings(s1, s2));
	}
}
