package hackerrank.hashmaps;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnagramsTest {

	@Test
	public void test1() {
		int expected = 4;
		String s = "abba";
		
		int actual = Anagrams.sherlockAndAnagrams(s);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test2() {
		int expected = 0;
		String s = "abcd";
		
		int actual = Anagrams.sherlockAndAnagrams(s);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test3() {
		int expected = 3;
		String s = "ifailuhkqq";
		
		int actual = Anagrams.sherlockAndAnagrams(s);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {
		int expected = 10;
		String s = "kkkk";
		
		int actual = Anagrams.sherlockAndAnagrams(s);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() {
		int expected = 5;
		String s = "cdcd";
		
		int actual = Anagrams.sherlockAndAnagrams(s);
		
		assertEquals(expected, actual);
	}
}
