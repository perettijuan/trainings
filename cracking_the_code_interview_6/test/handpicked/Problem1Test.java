package handpicked;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Problem1Test {
	
	@Test 
	public void test1() {
		String w = "abaaaaba";
		char[] word = w.toCharArray();
		int expected = 2;
		int actual = Problem1.countCharsToChagne(word);
		
		assertEquals(expected, actual);
	}
	
	
	@Test 
	public void test2() {
		String w = "abbaabaaabbcccd";
		char[] word = w.toCharArray();
		int expected = 5;
		int actual = Problem1.countCharsToChagne(word);
		
		assertEquals(expected, actual);
	}
	
	@Test 
	public void test3() {
		String w = "abab";
		char[] word = w.toCharArray();
		int expected = 0;
		int actual = Problem1.countCharsToChagne(word);
		
		assertEquals(expected, actual);
	}
	
	@Test 
	public void test4() {
		ArrayList<String> words = new ArrayList<String>();
		words.add("ab");
		words.add("aab");
		words.add("abb");
		words.add("abab");
		words.add("abaaaba");
		words.add("abaaaaba");
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(1);
		expected.add(1);
		expected.add(0);
		expected.add(1);
		expected.add(2);
		
		List<Integer> actual = Problem1.minimalReplaces(words);
		
		for(int i = 0;i< expected.size();i++) {
			assertEquals(expected.get(i), actual.get(i));
		}
	}

}
