package hackerrank.strings;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*
 * Anagrams: the letters of the first string can be re-arranged
 * to form the second string.
 * 
 * IMPORTANT: Both strings MUST have the same exact letters in the
 * same exact frequency.
 * 
 * Example:
 * 		bacdc and dcbac 
 * 		b -> 1 time   d -> 1 time  |
 * 		a -> 1 time   c -> 2 times | THEY ARE
 * 		c -> 2 times  b -> 1 time  | ANAGRAMS!
 * 		d -> i time   a -> 1 time  |
 * 
 * 		bacdc and dcbad
 * 		b -> 1 time  d -> 2 times  |
 * 		a -> 1 time  c -> 1 time   |   NO
 * 		c -> 2 times b -> 1 time   |ANAGRAMS!
 *      d -> 1 time  a -> 1 time   |
 *
 * Given a and b => number of deletions to make them anagrams.
 *		- a and b can have different length.
 *		- we can delete characters from either of the strings.
 *
 * Example:
 *		a = cde | b = dcf ===> removing e from "a" and f from "b" we get a 
 *							   a = cd and b = dc which are anagrams.
 *							   Output = 2
 *
 * Example:
 * 		a = hgteroiu | b = ytgfer 
 * 			Common letters = gter
 * 			In order to get gter from a => remove 4 
 *			In order to get gter from b => remove 2 
 *			Output = 6
 *
 * Example:
 * 		a = cde | b = abc
 * 			Common letters = c
 * 			From a ==> remove 2
 * 			From b ==> remove 2
 * 			Output = 4
 * Example:
 * 		a = cderte | b = ruievf
 * 			Common letters = e, but it is present 2 times in a and 1 time in b
 * 			From a => 5 = a.length - common frequency
 * 			From b => 5 = b.length - common frequency 
 * 			Output = 10
 * 
 * 
 * I think the algorithm needs to be based on founding the common characters and common
 * frequency for each character.
 * 
 * 1 - Use the longest string as a pivot.
 * 2 - Create a HashMap<Character, Integer> with the longest, where value if the frequency.
 * 3 - Iterate 2 and verify if the key exists in the shortest string with the same frequency. If
 * 	   it fulfills the criteria, count it as a common char.
 * 4 - When done, apply the formula:
 * 		a.lenght - commonCharFrequency + b.length - commonCharFrequency
 * 		a.length + b.length - 2commoCharFrequency
 * 
 */
public class MakingAnagrams {
	
	static int makeAnagram(String a, String b) {// a = bacdc b = dcbad
		char[] longest, shortest;
		int commonCharFrequency = 0;
		
		if (a.length() > b.length()) {
			longest = a.toCharArray();
			shortest = b.toCharArray();		
		} else {
			longest = b.toCharArray(); // longest = dcbad
			shortest = a.toCharArray(); // shortest = bacdc
		}
		
		HashMap<Character, Integer> map = mapTo(longest); // map = [d,2][c,1][b,1][a,1]	
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey(); // key = b
			int value = entry.getValue(); // value = 1
			int count = 0;
			
			for (int j = 0; j < shortest.length; j++) {// j == 3, shortest = bacdc
				if (shortest[j] == key) { // shortest[j] = d				
					count = count + 1; // count = 1
				}
			}
			
			if (count == value) {
				commonCharFrequency = commonCharFrequency + value; // commonCharFrequency = 4
			} else if(count > 0) {
				commonCharFrequency = commonCharFrequency + 1; // commonCharFrequency = 2
			}
		}
		
		return a.length() - commonCharFrequency + b.length() - commonCharFrequency; // 5 + 5 - (2*5) = 0
    }
	
	
	private static HashMap<Character, Integer> mapTo(char[] arr) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();	
		for (int i = 0; i < arr.length; i++) {
			char key = arr[i];
			if (map.containsKey(key)) {
				int value = map.get(key);
				map.put(key, value + 1);
			} else {
				map.put(key, 1);
			}
		}		
		return map;
	}
	
	
	
}
