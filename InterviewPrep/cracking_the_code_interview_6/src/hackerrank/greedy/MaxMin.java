package hackerrank.greedy;

import java.util.Arrays;

/*
 * Unfairness = max(subarr) - min(subarr)
 *  - max = the largest integer in subarr.
 *  - min = the smallest integer in subarr.
 *  
 * Output = an array of length k with minimum unfairness possible.
 * 
 *  arr = {1, 4, 7, 2}
 *  k = 2
 *   
 *   pick 1,4 => max(1,4) - min(1,4) = 4 - 1 = 3
 *   pick 4,7 => max(4,7) - min(4,7) = 7 - 4 = 3
 *   pick 7,2 => max(7,2) - min(7,2) = 7 - 2 = 5
 *   pick 1,2 => max(1,2) - min(1,2) = 2 - 1 = 1 <-- LOWEST
 *   pick 1,7 => max(1,7) - min(1,7) = 7 - 1 = 6
 *   pick 4,2 => max(4,2) - min(4,2) = 4 - 2 = 2
 *   
 * Output = 1  
 * 
 * arr = {10,100,300,200,1000,20,30}
 * k = 3
 * 
 *    10,100,300 => 300 - 10 = 290
 *    10,100,200 => 200 - 10 = 190
 *    10,100,1000 => 1000 - 10 = 1990
 *    10,20,30 => 30 - 10 = 20  
 *  
 * 
 * Idea:
 * 1 - sort input from lowest to highest.
 * 2 - Grab first k elements and do max-min  
 *  
 * 
 * PARTIAL GREEN 
 * 22 minutes
 * 
 * DO NOT GET LAZY. DO THE WHOLE ALGORITHM.
 * SORTING IS IMPORTANT!!!!
 *  
 */
public class MaxMin {
	
	static int maxMin(int k, int[] arr) {
		int out = 0;
		Arrays.sort(arr);
		
		int[] sub = new int[k];
		
		for (int i = 0; i < k; i++) {
			sub[i] = arr[i];
		}
		
		int min = sub[0];
		int max = sub[k-1];
			
		
		out = max - min;

		return out;
    }

}
