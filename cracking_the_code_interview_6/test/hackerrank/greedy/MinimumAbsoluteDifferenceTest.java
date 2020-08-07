package hackerrank.greedy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumAbsoluteDifferenceTest {
	
	@Test
	public void test1() {
		int[] arr = {-2, 2, 4};
		int expected = 2;
		
		int actual = MinimumAbsoluteDifference.minimumAbsoluteDifference(arr);
		
		assertEquals(expected, actual);
	}

}
