package hackerrank.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SherlockAndValidStringTest {

	@Test
	public void test1() {		
		String s = "abc";
		String expected = "YES";
		String actual = SherlockAndValidString.isValid(s);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {		
		String s = "abcc";
		String expected = "YES";
		String actual = SherlockAndValidString.isValid(s);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {		
		String s = "abccc";
		String expected = "NO";
		String actual = SherlockAndValidString.isValid(s);
		
		assertEquals(expected, actual);
	}
}
