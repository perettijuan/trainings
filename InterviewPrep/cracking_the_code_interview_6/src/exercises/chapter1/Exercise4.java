package exercises.chapter1;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * One Away: There are three types of edits that can be performed on strings: -
 * insert a character, - remove a character, - or replace a character. Given two
 * strings, write a function to check if they are one edit (or zero edits) away.
 * 
 * EXAMPLE 
 * pale, ple -> true 
 * pales, pale -> true 
 * pale, bale -> true 
 * pale, bake -> false 
 * paae, paaae -> true
 * 
 * Question: Do I have to say which type of edition is? ====> NO
 * 
 * WHAT I SHOULD CHEK basically, the two strings has to be the same except for
 * one character (can be: different or inexistent) Verify that one character
 * exists the same number of times in both Strings. If the char does not exists
 * or exists different number of times more than once, then they are not the
 * same.
 * 
 * If I put them in a map, the two maps should have the same keys with only one
 * difference (in the case they're not the same size). If I iterate over the map
 * (grabbing the map that has more keys first), for every key I should have the
 * same number.
 *
 */
public class Exercise4 {

	public static boolean areEdit(String input1, String input2) { // input1 = pale  input2 = bake
	    if (Math.abs(input1.length() - input2.length()) > 1) {
	        return false;
	    }

	    Map<Character, Integer> map1 = convertStringToMap(input1); // {p -> 1, a -> 1, l -> 1, e -> 1}
	    Map<Character, Integer> map2 = convertStringToMap(input2); // {b -> 1, a -> 1, k -> 1, e -> 1}


	    boolean areEdit;
	    if (map1.size() > map2.size()) {
	       areEdit = areEdit(map1, map2);
	    } else {
	    	areEdit = areEdit(map2, map1);
	    }
	  
	    return areEdit;
	}
	
	
	private static Map<Character, Integer> convertStringToMap(String input) {  // input = ple
	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    for (int i = 0; i < input.length(); i++) { // i = 0
	        char current = input.charAt(i); // p
	        if (map.containsKey(current)) {
	            int currentCount = map.get(current);
	            map.put(current, currentCount + 1);
	        } else {
	            map.put(current, 1); // map {p -> 1, l -> 1, e -> 1}
	        }    
	    }
	    return map;
	}

	private static boolean areEdit(Map<Character, Integer> pivot, Map<Character, Integer> altered) { 
	    // pivot = {b -> 1, a -> 1, l -> 1, e -> 1}
	    // altered = {p -> 1, a -> 1, k -> 1, e -> 1}
	    int numberOfCharactersNotPresent = 0;  
	    for (Map.Entry<Character, Integer> entry : pivot.entrySet()) { // entry = l -> 1	      
	        int value = entry.getValue(); // value = 1

	        if (!altered.containsKey(entry.getKey())) {
	            numberOfCharactersNotPresent = numberOfCharactersNotPresent + 1; // numberOfCharactersNotPresent = 2
	        } else {
	            int alteredValue = altered.get(entry.getKey()); // alteredValue = 1
	            if (alteredValue != value) {
	                numberOfCharactersNotPresent = numberOfCharactersNotPresent + 1;
	            }
	        }
	    }

	    return numberOfCharactersNotPresent <= 1;
	} 
}
