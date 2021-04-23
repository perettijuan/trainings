package hackerrank.problemsolving;

import java.util.Arrays;

/*
 * Go row by row and sort the string in that row.
 * Verify if the column is sorted.
 * 
 * ALL GREEN
 * 20 minutes
 */
public class GridChallenge {

	static String gridChallenge(String[] grid) {
		boolean sorted = true;
		String[] gridSorted = new String[grid.length];
		int stringLength = grid[0].length();
		
		for (int row = 0; row < grid.length; row++) {
			char[] toChar = grid[row].toCharArray();
			Arrays.sort(toChar);
			gridSorted[row] = new String(toChar);			
		}
		
		for (int col = 0; col < stringLength; col++) {
			for (int row = 0; row < gridSorted.length - 1; row++) {
				int nextRow = row+1;					
				if(gridSorted[row].charAt(col) > gridSorted[nextRow].charAt(col)) {
					sorted = false;
					break;
				}				
			}
		}
		
		
		if (sorted) {
			return "YES";
		} else {
			return "NO";
		}
    }
}
