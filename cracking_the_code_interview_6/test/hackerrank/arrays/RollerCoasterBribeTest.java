package hackerrank.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RollerCoasterBribeTest {

	@Test
	public void test1() {
		int[] q = new int[] { 2, 1, 5, 3, 4 };
		int expected = 3;
		
		int actual = RollerCoasterBribe.minimumBribesImpl(q);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test2() {
		int[] q = new int[] { 2, 5, 1 , 3, 4 };
		int expected = -1;
		
		int actual = RollerCoasterBribe.minimumBribesImpl(q);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		int[] q = new int[] { 2, 1, 5, 3, 4, 6, 8, 9, 7 };
		int expected = 5;
		
		int actual = RollerCoasterBribe.minimumBribesImpl(q);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {
		int[] q = new int[] { 1, 2, 3, 4, 5, 6 };
		int expected = 0;
		
		int actual = RollerCoasterBribe.minimumBribesImpl(q);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() {
		int[] q = new int[] { 1, 2, 5, 3, 7, 8, 6, 4 };
		int expected = 7;

		int actual = RollerCoasterBribe.minimumBribesImpl(q);

		assertEquals(expected, actual);
	}
}
