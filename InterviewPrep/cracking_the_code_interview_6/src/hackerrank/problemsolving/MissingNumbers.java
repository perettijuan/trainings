package hackerrank.problemsolving;
/*
 * 
 * You have two numbers, where one is a permutation of the other.
 * One of them has a few numbers missing.
 * Task: find the numbers missing (given the two numbers).
 * 
 * Notes:
 *  1 - If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists
 *  	is the same. If that is not the case, then it is also a missing number.
 *  2 - Print missing numbers in ascending order.
 *  3 - Print each missing number ONCE (even if it is missing multiple times)
 * 
 * Example:
 * arr = {7,2,5,3,5,3}
 * brr = {7,2,5,4,6,3,5,3}
 * Missing = {4,6}
 * 
 * arr = {203,204,205,206,207,208,203,204,205,206}
 * brr = {203,204,204,205,206,207,205,208,203,206,205,206,204}
 * 
 * brr is 203 x 2
 * 		  204 x 3
 * 		  205 x 3
 * 		  206 x 3
 * 		  207 x 1
 * 		  208 x 1
 * 
 * arr is 203 x 2
 * 		  204 x 2
 * 		  205 x 2
 * 		  206 x 2
 * 		  207 x 1
 * 		  208 x 1
 * 
 * Missing {204, 205, 206}
 * 
 * 
 * Algorithm:
 *  1 - create a HashMap<Integer, Integer> where key = number in brr, value is the frequency in brr.
 *  2 - Create a 2nd HashMap<Integer, Integer> where key = number in arr, value is the frequency in arr.
 *  3 - Iterate 1 and check if key is present in 2
 *  		if no present => put key in output
 *  		if present => check the frequency, if != put key in output.
 *  
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingNumbers {

	
	static int[] missingNumbers(int[] arr, int[] brr) { // arr = {203,204,205,206,207,208,203,204,205,206}; brr = {203,204,204,205,206,207,205,208,203,206,205,206,204}
		ArrayList<Integer> missing = new ArrayList<Integer>();
		HashMap<Integer, Integer> brrM = createMapFrom(brr); // brrM = {203 -> 2, 204 -> 3, 205 -> 3, 206 -> 3, 207 -> 1, 208 -> 1}
		HashMap<Integer, Integer> arrM = createMapFrom(arr); // arrM = {203 -> 2, 204 -> 2, 205 -> 2, 206 -> 2, 207 -> 1, 208 -> 1}
		
		
		for (Map.Entry<Integer, Integer> entry : brrM.entrySet()) {
			Integer key = entry.getKey(); // 206
			Integer value = entry.getValue(); // 2
			
			if (!arrM.containsKey(key)) {
				missing.add(key);
			} else if(arrM.get(key) != value) {
				missing.add(key); // missing => {204, 205, 206}
			}
		}
		
		int[] result = new int[missing.size()];
		for (int i = 0; i < missing.size(); i++) {
			result[i] = missing.get(i);
		}
		
		Arrays.sort(result);
		
		return result;
    }
	
	
	static HashMap<Integer, Integer> createMapFrom(int[] input) { // input = {203,204,205,206,207,208,203,204,205,206}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < input.length; i++) {
			int key = input[i]; // 206
			if (map.containsKey(key)) {  
				int value = map.get(key);
				map.put(key, value + 1); // {203 -> 2, 204 -> 2, 205 -> 2, 206 -> 2, 207 -> 1, 208 -> 1}
			} else {
				map.put(key, 1); //map {203 -> 1, 204 -> 1, 205 -> 1, 206 -> 1, 207 -> 1, 208 -> 1}
			}
		}
		
		
		return map;
	}
	
}
