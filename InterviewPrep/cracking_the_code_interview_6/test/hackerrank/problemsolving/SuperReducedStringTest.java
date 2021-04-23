package hackerrank.problemsolving;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SuperReducedStringTest {

//	@Test
//	public void test1() {
//		String s = "aaabccddd";
//		String expected = "abd";
//		
//		String actual = SuperReducedString.superReducedString(s);
//		
//		assertEquals(expected, actual);
//	}
	
	@Test
	public void test2() {
		String s = "aa";
		String expected = "Empty String";
		
		String actual = SuperReducedString.superReducedString(s);
		
		assertEquals(expected, actual);
	}
	
}
