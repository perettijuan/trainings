package hackerrank.warmup;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JumpinOnCloudsTest {

	/*
	 * 0 0 1 0 0 1 0
	 * 4
	 */
	@Test
	public void test1() {	
		int[] c = new int[] { 0, 0, 1, 0, 0, 1, 0 };
		
		int expected = 4;
		int actual = JumpinOnClouds.jumpingOnClouds(c);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * 0 0 0 1 0 0 1 0
	 * 4
	 */
	@Test
	public void test2() {	
		int[] c = new int[] { 0, 0, 0, 1, 0, 0, 1, 0 };
		
		int expected = 4;
		int actual = JumpinOnClouds.jumpingOnClouds(c);
		
		System.out.println("Modulo = " + (11 % 3));
		System.out.println("Div = " + (10 / 3));
		
		assertEquals(expected, actual);
	}
	
	/*
	 * 0 0 0 0 0 0 0
	 * 4
	 */
	@Test
	public void test3() {	
		int[] c = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		
		int expected = 3;
		int actual = JumpinOnClouds.jumpingOnClouds(c);
		
		assertEquals(expected, actual);
	}
}
