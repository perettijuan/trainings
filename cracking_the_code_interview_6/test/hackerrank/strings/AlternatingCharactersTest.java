package hackerrank.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AlternatingCharactersTest {
	
	@Test
	public void test1() {		
		runTest("AABAAB", 2);
	}
	
	@Test
	public void test2() {
		runTest("AAAA", 3);
	}
	
	@Test
	public void test3() {
		runTest("BBBBB", 4);
	}
	
	@Test
	public void test4() {
		runTest("ABABABAB", 0);
	}
	
	@Test
	public void test5() {
		runTest("BABABA", 0);
	}

	@Test
	public void test6() {
		runTest("AAABBB", 4);
	}

	
	private void runTest(String s, int expected) {
		int actual = AlternatingCharacters.alternatingCharacters(s);		
		assertEquals(expected, actual);
	}
}
