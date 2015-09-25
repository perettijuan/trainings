package com.jpp.chapter1;

public class Exercise7 {

	/*
	 * Write an algorithm such that if an element in an MxN matrix is 0, its
	 * entire row and column is set to 0.
	 */
	
	public static void setAllToZeroWhenZero(int[][] matrix) {
		
		// check for null
		if(matrix == null) {
			return;
		}
		
		// Check for size
		if(matrix.length == 0) {
			return;
		}
		
		
		int column = -1;
		int row = -1;
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == 0) {
					column = i;
					row = j;
					break;
				}
			}
		}
		
		if(column != 0 && row != 0) {
			// set all elements in the column to zero
			for(int i = 0; i < matrix[column].length; i++) {
				matrix[column][i] = 0;
			}

			// set all elements in the row to zero
			for(int i = 0; i < matrix.length; i++) {
				matrix[i][row] = 0;
			}

		}
		
	}

}
