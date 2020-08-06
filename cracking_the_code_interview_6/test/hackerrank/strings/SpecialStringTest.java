package hackerrank.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SpecialStringTest {
	
	@Test
	public void test1() {
		String s = "aaaa";
		int n = s.length();
		long expected = 10;
		long actual = SpecialString.substrCount(n, s);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test2() {
		String s = "abcbaba";
		int n = s.length();
		long expected = 10;
		long actual = SpecialString.substrCount(n, s);
		
		assertEquals(expected, actual);
	}
	

}
