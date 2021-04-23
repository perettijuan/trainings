package hackerrank.search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumTimeRequiredTest {
	
	@Test
	public void test1() {
		long[] machines = {2, 3};
		long goal = 5;
		long expected = 6;
		
		long actual = MinimumTimeRequired.minTime(machines, goal);
		
		assertEquals(expected, actual);
	}

}
