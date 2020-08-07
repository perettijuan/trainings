package hackerrank.greedy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LuckBalanceTest {
	
	@Test
	public void test1() {
		int[][] contests = new int[6][6];
		contests[0][0] = 5;
		contests[0][1] = 1;
		
		contests[1][0] = 2;
		contests[1][1] = 1;
		
		contests[2][0] = 1;
		contests[2][1] = 1;
		
		contests[3][0] = 8;
		contests[3][1] = 1;
		
		contests[4][0] = 10;
		contests[4][1] = 0;
		
		contests[5][0] = 5;
		contests[5][1] = 0;
		int k = 3;
		
		int expected = 29;
		
		int actual = LuckBalance.luckBalance(k, contests);
		
		assertEquals(expected, actual);
	}

}
