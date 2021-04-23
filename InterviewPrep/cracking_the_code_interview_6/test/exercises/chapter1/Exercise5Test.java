package exercises.chapter1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Exercise5Test {
	
	@Test
	public void test1() {
		String expected = "a2bc5a3";
		String actual = Exercise5.compress("aabcccccaaa");
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		String expected = "abcde";
		String actual = Exercise5.compress("abcde");
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		String expected = "bbAAtfEEut";
		String actual = Exercise5.compress("bbAAtfEEut");
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {
		String expected = "a13B";
		String actual = Exercise5.compress("aaaaaaaaaaaaaB");
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() {
		String expected = "a13Ba5";
		String actual = Exercise5.compress("aaaaaaaaaaaaaBaaaaa");
		assertEquals(expected, actual);	
	}

}
