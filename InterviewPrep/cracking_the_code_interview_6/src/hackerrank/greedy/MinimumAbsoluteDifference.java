package hackerrank.greedy;

import java.util.Arrays;

/*
 * 
 * Find and print the minimum absolute difference between any two elements in the array.
 * 
 * arr = {-2, 2, 4}
 *        3 pairs = {-2, 2}{-2,4}{2,4}
 *		  Abs Diff = 4       6    2
 *		 Min = 2 (Output)
 *
 * arr = {3, -7, 0} (-10, 3, 7)
 * Out = 3
 * 
 * Algorithm:
 * 1 - Iterate each position in the array (i=0; i < arr.length)
 * 2 - Internal iteration with j = i+1
 * 3 - Sum arr[i] and arr[j] = get the minimum
 * 
 * DONE (TIME OUT)
 * 12 MINUTES
 * 
 * 
 * IMPROVEMENT = SORT THE ARRAY AND CONSIDER THE DIFFERENCE BETWEEN THE FIRST TWO ITEMS AS THE MINIMUM.
 */
public class MinimumAbsoluteDifference {
	
	
	static int minimumAbsoluteDifference(int[] arr) {
		int minDifference = -1;
		
		for (int i = 0; i < arr.length; i++) {
			int current = arr[i]; 
			
			for (int j = i + 1; j < arr.length; j++) {				
				
				int sum = Math.abs(current - arr[j]); 			
				
				if (minDifference == -1) {
					minDifference = sum;
				}
				
				if (sum < minDifference) {
					minDifference = sum;
				}				
			}			
		}
		
		
		
		return minDifference;
    }

	
	static int minimumAbsoluteDifferenceImproved(int[] arr) {		
		Arrays.sort(arr);
		
		int minDifference = Math.abs(arr[0] - arr[1]);
		
		for (int i = 0; i < arr.length; i++) {
			if (i+1 == arr.length) {
				break;
			}
			
			
			int abs = Math.abs(arr[i+1] - arr[i]);
			if (abs < minDifference) {
				minDifference = abs;
			}			
		}
		
		return minDifference;
    }

}
