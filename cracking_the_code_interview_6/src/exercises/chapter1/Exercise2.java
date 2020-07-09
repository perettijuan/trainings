package exercises.chapter1;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Check Permutation
 * Given two strings, write a method to decide if one is a permutation of the other.
 *
 * Questions:
 * 1 - What's the input type? A String or a char array? -> I'll assume it is a String.
 * 2 - The output is just a boolean value? -> Yes.
 *
 * Examples:
 * - input 1 -> abcde | input2 -> bcdae ==> YES
 * - input 1 -> abcde | input2 -> bcdaef ==> NO
 * - input 1 -> ju7ty | input2 -> lkjut ==> NO
 * - input 1 -> aacde | input2 -> acdae ==> YES
 * - input 1 -> aade | input2 -> aeae ==> YES
 *
 */
public class Exercise2 {
	
	public static boolean checkPermutation(String input1, String input2) {
	    if (input1.length() != input2.length()) {  
	        return false;
	    }

	    char[] input1AsChar = convertStringToCharArray(input1);
	    char[] input2AsChar = convertStringToCharArray(input2);
	    

	    HashMap<Character, Integer> input1AsMap = new HashMap<Character, Integer>();
	    HashMap<Character, Integer> input2AsMap = new HashMap<Character, Integer>();
	    for (int i = 0; i < input1.length(); i++) {	       
	        countAndUpdateMap(input1AsChar[i], input1AsMap);
	        countAndUpdateMap(input2AsChar[i], input2AsMap);
	      
	    }

	    boolean isPermutation = true;
	    for (Map.Entry<Character, Integer> entry : input1AsMap.entrySet()) {
	        Character key = entry.getKey();
	        Integer value = entry.getValue();
	        if (!input2AsMap.containsKey(key)) {
	            isPermutation = false;
	            break;
	        } else if (input2AsMap.get(key) != value) {
	            isPermutation = false;
	            break;
	        }
	    }
	    return isPermutation;
	 }
	
	private static void countAndUpdateMap(char current, Map<Character, Integer> map) {
		if (map.containsKey(current)) {
			int currentCount = map.get(current);
			map.put(current, currentCount + 1);
		} else {
			map.put(current, 1);
		}
	}

	 private static char[] convertStringToCharArray(String input) {
			char[] result = new char[input.length()];
			for (int i = 0; i < input.length(); i++) {
				result[i] = input.charAt(i);
			}
			return result;
		}

}
