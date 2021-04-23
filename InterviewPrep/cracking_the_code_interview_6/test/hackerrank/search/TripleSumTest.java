package hackerrank.search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TripleSumTest {
	
	@Test
	public void test1() {
		int[] a = {1,3,5};
		int[] b = {2,3};
		int[] c = {1,2,3};
		long expected = 8;
		long actual = TripleSum.triplets(a, b, c);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test2() {
		int[] a = {1,4,5};
		int[] b = {2,3,3};
		int[] c = {1,2,3};
		long expected = 5;
		long actual = TripleSum.triplets(a, b, c);
		
		assertEquals(expected, actual);
	}

}
