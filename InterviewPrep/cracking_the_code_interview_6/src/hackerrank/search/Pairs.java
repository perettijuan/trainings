package hackerrank.search;

import java.util.HashSet;
import java.util.Set;

/*
 * k = 2
 * arr = {1,5,3,4,2} 
 * 
 *   3 - 1 = 2 => 1 + 2 = 3 | 
 *   4 - 2 = 2 => 2 + 2 = 4 | i + k = target
 *   5 - 3 = 2 => 2 + 3 = 5 |
 *   
 *  Output = 3 
 *
 * Algorithm: 
 * 	Set does not allows duplicates
 * 	1 - Put all values in a set.
 *  2 - From lower to highest, find the target
 *      if target is in set, add
 *  
 * ALL FUCKING GREEN
 * 10 MINUTES!!!  0
 *  
 */
public class Pairs {
	
	static int pairs(int k, int[] arr) {
		int pairs = 0;
		
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i] + k)) {
				pairs++;
			}
		}
		
		return pairs;
    }

}
