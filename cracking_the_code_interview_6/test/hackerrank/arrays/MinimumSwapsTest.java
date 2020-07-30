package hackerrank.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumSwapsTest {
	
	@Test
	public void test1() {
		int[] arr = new int[] { 7, 1, 3, 2, 4, 5, 6};
		int expected = 5;
		
		int actual = MinimumSwaps.minimumSwaps(arr);
		
		assertEquals(expected, actual);
	}

}
