package hackerrank.arrays;

/*
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] 
 * without any duplicates. You are allowed to swap any two elements. 
 * You need to find the minimum number of swaps required to sort the array in ascending order.
 * 
 * 
 * Nomenclature: f = first one to swap (current > next)
 *               s = second to swap (current < previous)
 * 
 * [7, 1, 3, 2, 4, 5, 6] // f = 7[0]; s = 2[3]
 * [2 ,1, 3, 7, 4, 5, 6] // f = 2[0]; s = 1[1]
 * [1, 2, 3, 7, 4, 5, 6] // f = 7[3]; s = 4[4]
 * [1, 2, 3, 4, 7, 5, 6] // f = 7[4]; s = 5[5]
 * [1, 2, 3, 4, 5, 7, 6] // f = 7[5]; s = 6[6]
 * [1, 2, 3, 4, 5, 6, 7]
 *
 * 
 * [1, 4, 5, 2, 3, 7, 6, 8, 9] // f = 5[2]; s = 2[3]
 * [1, 4, 2, 5, 3, 7, 6, 8, 9] // f = 4[1]; s = 2[2]
 * [1, 2, 4, 5, 3, 7, 6, 8, 9] // f = 5[3]; s = 3[4]
 * [1, 2, 4, 3, 5, 7, 6, 8, 9] // f = 4[2]; s = 3[3]
 * [1, 2, 3, 4, 5, 7, 6, 8, 9] // f = 7[5]; s = 6[6]
 * [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * 
 * [4, 3, 1, 2] = 3
 * [1 3 5 2 4 6 7] = 3
 * [2 3 4 1 5] = 3
 * 
 * * Count the swaps (when doing it).
 * * Probable improvement: instead of iterating the full array
 * 						   on each loop, iterate only the unsorted
 * 						   section.
 * 
 * LEARNING : 
 *   1 - Don't get bias from the example. The algorithm might work different,
 *   	 but still provide the expected output.
 *   2 - Use the indexes along with the numbers in the array.
 */
public class MinimumSwaps {

	static int minimumSwaps(int[] arr) {// 7, 1, 3, 2, 4, 5, 6
		int minSwaps = 0;

		int temp = 0;
		int i = 0;
		int n = arr.length;

		while (i < n) { // n = 7, i = 0
			if (arr[i] != i + 1) { // 7 =! 1 => true
				temp = arr[i]; // temp = 7
				arr[i] = arr[temp - 1]; // arr[0] = 6
				arr[temp - 1] = temp; //
				minSwaps++;
			} else {
				i++;
			}
		}

		return minSwaps;
	}

}
