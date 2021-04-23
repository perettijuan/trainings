package hackerrank.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MakingAnagramsTest {
	
//	@Test
//	public void test1() {
//		String a = "bacdc";
//		String b = "dcbac";
//		
//		int expected = 0;
//		int actual = MakingAnagrams.makeAnagram(a, b);
//		
//		assertEquals(expected, actual);
//	}
	
	
	@Test
	public void test2() {
		String a = "bacdc";
		String b = "dcbad";
		
		int expected = 4;
		int actual = MakingAnagrams.makeAnagram(a, b);
		
		assertEquals(expected, actual);
	}
	
//	@Test
//	public void test3() {
//		String a = "cde";
//		String b = "abc";
//		
//		int expected = 4;
//		int actual = MakingAnagrams.makeAnagram(a, b);
//		
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void test4() {
//		String a = "fcrxzwscanmligyxyvym";
//		String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
//		
//		int expected = 30;
//		int actual = MakingAnagrams.makeAnagram(a, b);
//		
//		assertEquals(expected, actual);
//	}

}
