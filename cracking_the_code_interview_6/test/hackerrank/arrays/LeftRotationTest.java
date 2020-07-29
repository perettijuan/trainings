package hackerrank.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeftRotationTest {
	
	/*
	 * Rotate 1 unit to the left
	 *  input = [1, 2, 3, 4, 5]
	 *  output = [2, 3, 4, 5, 1]
	 */
	@Test
	public void test1() {
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		int d = 1;
		int[] expected = new int[] { 2, 3, 4, 5, 1 };
		
		int[] actual = LeftRotation.rotLeft(a, d);
		
		for (int i = 0; i< expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}
	
	/*
	 * Rotate 4 unit to the left
	 *  input = [1, 2, 3, 4, 5]
	 *  output = [5, 1, 2, 3, 4]
	 */
	@Test
	public void test2() {
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		int d = 4;
		int[] expected = new int[] { 5, 1, 2, 3, 4 };
		
		int[] actual = LeftRotation.rotLeft(a, d);
		
		for (int i = 0; i< expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}
	
	/*
	 * Rotate 3 unit to the left
	 *  input = [1, 2, 3, 4, 5, 6, 7, 9, 8]
	 *  output = [4, 5, 6, 7, 9, 8, 1, 2, 3]
	 */
	@Test
	public void test3() {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 9, 8 };
		int d = 3;
		int[] expected = new int[] { 4, 5, 6, 7, 9, 8, 1, 2, 3 };
		
		int[] actual = LeftRotation.rotLeft(a, d);
		
		for (int i = 0; i< expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}
	
	/*
	 * Rotate 3 unit to the left
	 *  input = [1, 2, 3]
	 *  output = [3, 2, 1]
	 */
	@Test
	public void test4() {
		int[] a = new int[] { 1, 2, 3 };
		int d = 3;
		int[] expected = new int[] { 1, 2, 3 };
		
		int[] actual = LeftRotation.rotLeft(a, d);
		
		for (int i = 0; i< expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}

}
