package hackerrank.problemsolving;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CakewalkTest {
	
	@Test
	public void test1() {
		int[] calorie = {1,3,2};
		long expected = 11;
		long actual = Cakewalk.marcsCakewalk(calorie);
		assertEquals(expected, actual);
	}

}
