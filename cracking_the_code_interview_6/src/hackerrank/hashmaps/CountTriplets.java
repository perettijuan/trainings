package hackerrank.hashmaps;

import java.util.HashMap;
import java.util.List;

/*
 * 
 * Input = {1, 2, 2, 4}
 * Triplets: 1, 2, 4 (0, 1, 3)
 * 			 1, 2, 3 (0, 2, 3)
 * Output = 2
 * 
 * Input = {1, 2, 2, 4, 4}
 * Triplets: 1, 2, 4 (0, 1, 3)
 * 			 1, 2, 4 (0, 1, 4)
 *  		 1, 2, 4 (0, 2, 3)
 *  		 1, 2, 4 (0, 2, 4)
 * Output = 4
 * 
 * Input = {1, 3, 9, 9, 27, 81}
 * Triplets: 1, 3, 9 (0, 1, 2)
 * 			 1, 3, 9 (0, 1, 3)
 * 			 3, 9, 27 (1, 2, 4)
 *  		 3, 9, 27 (1, 3, 4)
 *  		 9, 27, 81 (2, 4, 5)
 *  		 9, 27, 81 (3, 4, 5)
 * Output: 6
 *  
 * Input = {1, 1, 2, 2, 4, 4}
 * Triplets: 1, 2, 4 - 0,2,4
 * 			 1, 2, 4 - 0,3,4
 * 			 1, 2, 4 - 0,2,5
 * 			 1, 2, 4 - 0,3,5
 * 			 1, 2, 4 - 1,2,4
 * 			 1, 2, 4 - 1,3,4
 * 			 1, 2, 4 - 1,2,5
 * 			 1, 2, 4 - 1,3,5
 *  
 *  
 * Question: the input is always ordered? => I'll assume YES.
 * 
 * 
 * Algorithm:
 *  1 - Iterate the input.
 *  2 - For each position, calculate the required two numbers (to get the triplet).
 *  3 - Keep two flags (foundFirst, foundSecond).
 *  4 - Iterate the array from i+1 and try to find the remaining ones.
 *      PROBLEM WITH THIS APPROACH = how do I count the total number of triples if
 *                                   I have repeated?
 *                                   
 * Alteration: Use a HashMap
 *  1 - Iterate the input and put every value in a HashMap
 *        HashMap<Int, Int> = key: the number in input
 *        					  value: the number of times key is in input.
 *  2 - For each input, calculate the two required numbers for triplets.
 *  3 - Verify if (2) are both in the map (as Keys).
 *  		if they are, I have to calculate the number of times
 *  
 * 			HM for example 1 = {1, 1}{2, 2}{4,1}
 * 					for 1 = find {2, 4}
 * 							2 => 2 times
 * 							4 => 1 time
 * 			HM for example 2 = {1,1}{2, 2}{4,2}
 * 					for 1 = find {2, 4}
 * 							2 => 2 times
 * 							4 => 2 times 					
 *      	HM for example 3 = {1, 1}{3, 1}{9, 2}{27, 1}{81, 1}
 *      			for 1 = find {3, 9}
 *      					3 => 1 time
 *      					9 => 2 times
 *      			for 3 = find {9, 27}
 *      					9 => 2 times
 *      					27 => 1 time
 *      			for 9 = find {27, 81}
 *      					27 => 1 time
 *                          81 => 1 time
 *                  for 9 = find {9,  27}
 *							27 => 1 time
 *                          81 => 1 time
 *                          
 *       Formula = for each pair, do value times value and sum all of them.
 *       			Example 1 = 2x1 = 2 | 2
 *       			Example 2 = 2x2 = 2 | 2
 *       			Example 3 = 1x2	= 2 |
 *       						2x1 = 2 | 2+2+1+1 = 6
 *       						1x1 = 1 |
 *       						1x1 = 1	|                
 *                                         
 */
public class CountTriplets {

	static long countTriplets(List<Long> arr, long r) {
		long triplets = 0;
		// 1st - create the map
		HashMap<Long, Integer> map = createMap(arr);

		for (int i = 0; i < arr.size(); i++) {
			long current = arr.get(i);
			long firstTriplet = current * r;
			long secondTriplet = firstTriplet * r;

			if (map.containsKey(firstTriplet) 
					&& map.containsKey(secondTriplet)) {
				// triplet is in the map, count them
				int firstTripletCount = map.get(firstTriplet);
				int secondTripletCount = map.get(secondTriplet);
				int tripletCount = firstTripletCount * secondTripletCount;
				triplets = triplets + tripletCount;
			}
		}
		return triplets;
	}

	private static HashMap<Long, Integer> createMap(List<Long> arr) {
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();

		for (int i = 0; i < arr.size(); i++) {
			long key = arr.get(i);
			if (map.containsKey(key)) {
				int count = map.get(key);
				map.put(key, count + 1);
			} else {
				map.put(key, 1);
			}
		}

		return map;
	}

}
