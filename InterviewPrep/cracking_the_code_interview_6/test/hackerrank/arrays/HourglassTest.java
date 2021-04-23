package hackerrank.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HourglassTest {

	/*
	 * 0 0 1 0 0 1 0
	 * 4
	 */
	@Test
	public void test1() {	
		int[][] arr = new int[6][6];
		arr[0][0] = -9;
		arr[0][1] = -9;
		arr[0][2] = -9;
		arr[0][3] = 1;
		arr[0][4] = 1;
		arr[0][5] = 1;
		
		arr[1][0] = 0;
		arr[1][1] = -9;
		arr[1][2] = 0;
		arr[1][3] = 4;
		arr[1][4] = 3;
		arr[1][5] = 2;
		
		arr[2][0] = -9;
		arr[2][1] = -9;
		arr[2][2] = -9;
		arr[2][3] = 1;
		arr[2][4] = 2;
		arr[2][5] = 3;
		
		arr[3][0] = 0;
		arr[3][1] = 0;
		arr[3][2] = 8;
		arr[3][3] = 6;
		arr[3][4] = 6;
		arr[3][5] = 0;
		
		arr[4][0] = 0;
		arr[4][1] = 0;
		arr[4][2] = 0;
		arr[4][3] = -2;
		arr[4][4] = 0;
		arr[4][5] = 0;
		
		arr[5][0] = 0;
		arr[5][1] = 0;
		arr[5][2] = 1;
		arr[5][3] = 2;
		arr[5][4] = 4;
		arr[5][5] = 0;
		
		
		int expected = 28;
		int actual = Hourglass.hourglassSum(arr);
		
		assertEquals(expected, actual);
	}
	
	
	/*
	 * 0 -4 -6 0 -7 -6
		-1 -2 -6 -8 -3 -1
		-8 -4 -2 -8 -8 -6
		-3 -1 -2 -5 -7 -4
		-3 -5 -3 -6 -6 -6
		-3 -6 0 -8 -6 -7
	 */
	@Test
	public void test2() {	
		int[][] arr = new int[6][6];
		arr[0][0] = 0;
		arr[0][1] = -4;
		arr[0][2] = -6;
		arr[0][3] = 0;
		arr[0][4] = -7;
		arr[0][5] = -6;
		
		arr[1][0] = -1;
		arr[1][1] = -2;
		arr[1][2] = -6;
		arr[1][3] = -8;
		arr[1][4] = -3;
		arr[1][5] = -1;
		
		arr[2][0] = -8;
		arr[2][1] = -4;
		arr[2][2] = -2;
		arr[2][3] = -8;
		arr[2][4] = -8;
		arr[2][5] = -6;
		
		arr[3][0] = -3;
		arr[3][1] = -1;
		arr[3][2] = -2;
		arr[3][3] = -5;
		arr[3][4] = -7;
		arr[3][5] = -4;
		
		arr[4][0] = -3;
		arr[4][1] = -5;
		arr[4][2] = -3;
		arr[4][3] = -6;
		arr[4][4] = -6;
		arr[4][5] = -6;
		
		arr[5][0] = -3;
		arr[5][1] = -6;
		arr[5][2] = 0;
		arr[5][3] = -8;
		arr[5][4] = -6;
		arr[5][5] = -7;
		
		
		int expected = -19;
		int actual = Hourglass.hourglassSum(arr);
		
		assertEquals(expected, actual);
	}
}
