package hackerrank.warmup;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SockMerchantTest {

	/*
	 * 9 10 20 20 10 10 30 50 10 20
	 */
	@Test
	public void test1() {
		int n = 9;
		int[] ar = new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		
		int expected = 3;
		int actual = SockMerchant.sockMerchant(n, ar);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * n = 10; 5 8 6 5 6 7 8 2 2 9
	 */
	@Test
	public void test2() {
		int n = 9;
		int[] ar = new int[] { 5, 8, 6, 5, 6, 7, 8, 2, 2, 9 };
		
		int expected = 4;
		int actual = SockMerchant.sockMerchant(n, ar);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * n = 6; 2 2 8 7 2 2
	 */
	@Test
	public void test3() {
		int n = 6;
		int[] ar = new int[] { 2, 2, 8, 7, 2, 2 };
		
		int expected = 2;
		int actual = SockMerchant.sockMerchant(n, ar);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * n = 11; 2, 2, 8, 7, 2, 2, 2, 1, 3, 4
	 */
	@Test
	public void test4() {
		int n = 10;
		int[] ar = new int[] { 2, 2, 8, 7, 2, 2, 2, 1, 3, 4 };
		
		int expected = 2;
		int actual = SockMerchant.sockMerchant(n, ar);
		
		assertEquals(expected, actual);
	}

}
