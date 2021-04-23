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
		String s = "aabbcc";
		String expected = "YES";
		String actual = SherlockAndValidString.isValid(s);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {		
		String s = "abccba";
		String expected = "YES";
		String actual = SherlockAndValidString.isValid(s);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {		
		String s = "abcc";
		String expected = "YES";
		String actual = SherlockAndValidString.isValid(s);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() {		
		String s = "abccc";
		String expected = "NO";
		String actual = SherlockAndValidString.isValid(s);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test6() {		
		String s = "abcdefghhgfedecba";
		String expected = "YES";
		String actual = SherlockAndValidString.isValid(s);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test7() {		
		String s = "aabbc";
		String expected = "YES";
		String actual = SherlockAndValidString.isValid(s);
		
		assertEquals(expected, actual);
	}
}
