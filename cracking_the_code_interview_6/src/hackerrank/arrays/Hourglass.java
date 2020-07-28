package hackerrank.arrays;

/*
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 
 * 
 * I have to iterate the matrix (or 2D array)
 *   - col will iterate horizontally.
 *   - row will iterate vertically (start in 1)
 *   
 * 1 - sum [i, i+1, i+2]
 * 2 - sum 1 + [i+1 - j]
 * 3 - sum 2 + [i-j+2, i+1 - j+2, i+2 - j+2] 
 * 
 * 
 * for (int row = 0; row < board.length; row++) { 
 *    for (int col = 0; col < board[row].length; col++) {
 *     		board[row][col] = row * col; 
 *     } 
 * }
 */
public class Hourglass {

	/*
	 * -9 -9 -9 1 1 1 0 -9 0 4 3 2 -9 -9 -9 1 2 3 0 0 8 6 6 0 0 0 0 -2 0 0 0 0 1 2 4
	 * 0
	 */

	static int hourglassSum(int[][] arr) {
		Integer maxHourglassSum = null;

		for (int row = 0; row < arr.length; row++) { // row = 4
			int row2 = row + 2; // row2 = 6
			if (row2 > arr.length - 1) { // arr.lenght = 6
				break;
			}

			for (int col = 0; col < arr[row].length; col++) { // col = 3
				int col2 = col + 2; // col2 = 5

				if (col2 > arr[row].length - 1) { // arr[row] = 6
					break;
				}

				int sum1 = arr[row][col] + arr[row][col + 1] + arr[row][col2]; // 1 1 1 = 3
				int middle = arr[row + 1][col + 1]; // 3
				int sum2 = arr[row2][col] + arr[row2][col + 1] + arr[row2][col2]; // 1 2 3 = 6

				int sumHourglass = sum1 + middle + sum2; // -9

				if (maxHourglassSum == null) {
					maxHourglassSum = sumHourglass;
				} else if (sumHourglass > maxHourglassSum) { // false
					maxHourglassSum = sumHourglass; // maxHourglassSum = 0
				}
			}
		}

		return maxHourglassSum;
	}

}
