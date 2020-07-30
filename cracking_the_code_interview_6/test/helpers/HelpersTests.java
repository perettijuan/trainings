package helpers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HelpersTests {
	
	@Test
	public void modulo() {
		/*
		 * if I want to know how many times
		 * a dimension fits into another and
		 * what is the left over, I can use a
		 * division and a modulo.
		 * 
		 * For instance:
		 *  How many times 3 fits in 10
		 *  
		 *  Division = 10/3 = 3 (take only the integer part - either in an int or a long)
		 *  
		 *  LeftOver = 1 (3x3 = 9 | 10 - 9 = 1)
		 *  I can calculate the LeftOver doing
		 *  Modulo = 10 % 3 = 1
		 *  
		 */	
		long expected = 1;
		long actual = 10 % 3;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void iterateAHashMap() {
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			System.out.println("IS " + key + ", " + value);
		}
	}
	
	@Test
	public void iterateA2DArray() {
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
		
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {		
				System.out.println("arr[" + row + "][ " + col + "] is => " + arr[row][col]);
			}
		}
	}

	
	/*
	 * Verify if hashMap.containsKey is case sensitive.  === YESSS
	 */
	@Test
	public void hashMapCaseSensitive() {
		
		HashMap<String, Integer> aMap = new HashMap<String, Integer>();
		aMap.put("aString", 1);
		
		assertTrue(aMap.containsKey("aString"));
		assertFalse(aMap.containsKey("astring"));
		
	}
	
	
}
