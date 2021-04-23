package hackerrank.problemsolving;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PermutingTwoArraysTest {
	
	@Test 
	public void test1() {
		int[] A = {1, 5, 1, 4, 4, 2, 7, 1, 2, 2};
		int[] B = {8, 7, 1, 7, 7, 4, 4, 3, 6, 7};
		int k = 9;
		
		String expected = "NO";
		String actual = PermutingTwoArrays.twoArrays(k, A, B);
		
		assertEquals(expected, actual);
	}
	
	@Test 
	public void test2() {
		int[] A = {3, 6, 8, 5, 9, 9, 4, 8, 4, 7};
		int[] B = {5, 1,0, 1, 6, 4, 1, 7, 4, 3};
		int k = 9;
		
		String expected = "YES";
		String actual = PermutingTwoArrays.twoArrays(k, A, B);
		
		assertEquals(expected, actual);
	}
	
	@Test 
	public void test3() {
		int[] A = {4, 4, 3, 2, 1, 4, 4, 3, 2, 4};
		int[] B = {2, 3, 0, 1, 1, 3, 1, 0, 0, 2};
		int k = 4;
		
		String expected = "YES";
		String actual = PermutingTwoArrays.twoArrays(k, A, B);
		
		assertEquals(expected, actual);
	}

}
