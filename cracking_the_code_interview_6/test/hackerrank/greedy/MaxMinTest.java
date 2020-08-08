package hackerrank.greedy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxMinTest {

	@Test
	public void test1() {
		int k = 5;
		int[] arr = { 4504, 1520, 5857, 4094, 4157, 
				3902, 822, 6643, 2422, 
				7288, 8245, 9948, 2822, 
				1784, 7802, 3142,
				9739, 5629, 5413, 7232 };
		int expected = 1335;
		
		int actual = MaxMin.maxMin(k, arr);
		
		assertEquals(expected, actual);	
	}

}
