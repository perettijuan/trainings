package hackerrank.challenges;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hackerrank.challenges.FibonacciLite;

public class FibonacciLiteTest {
	

	@Test
	public void test1() {
		int expected = 144;
		int actual = FibonacciLite.fibonacciFor(12);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		int expected = 832040;
		int actual = FibonacciLite.fibonacciFor(30);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		int expected = 1;
		int actual = FibonacciLite.fibonacciFor(1);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {
		int expected = 0;
		int actual = FibonacciLite.fibonacciFor(0);
		
		assertEquals(expected, actual);
	}

}
