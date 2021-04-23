package hackerrank.strings;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Valid String:
 *  1 - if all characters appear the same number of times.
 *  2 - Removing just one character, remaining occur same number of times.
 *  
 *  
 *  
 *  abc = {a:1, b:1, c:1} ==> YES
 *  abcc = {a:1, b:1, c:2} ==> YES (remove only one 'c')
 *  abccc = {a:1, b:1, c:3} ==> NO (remove two 'c')
 *  aabbc = {a:2, b:2, c:1} ==> YES (remove one 'a' and one 'b'}
 *  aabbcc = {a:2, b:2, c:2} ==> YES
 *  a = {a:1} => YES
 * 
 *   
 *  ALGORITHM: DIVIDE AND CONQUER
 *  1st problem: all characters appear same number of times.
 *   - create a HashMap<Character, Integer> => value is frequency. If all equals, print YES.
 *     otherwise -> solve 2nd problem
 *     
 *  2nd problem: remove just one character    
 *    - find minimum frequency (i can do it on 1st)
 *    - Iterate all frequency and do this math:
 *    		- if current - minimum == 0 ==> OK
 *    		- if current - minimum == 1 => COUNT ONE DELETION
 *          - if current - minimum > 1 => PRINT NO
 *          
 *          
 * SOLVED (WITH SOME TEST CASES FAILING)
 * 25 MINUTES (AFTER A DAY OF THINKING)
 * 
 *          
 ***************************************************************************************
 ***************************************************************************************
 ***************************************************************************************
 ***************************************************************************************
 ***************************************************************************************
 ************************* DIVIDE AND CONQUER BUDY!!!!!*********************************
 ***************************************************************************************
 ***************************************************************************************
 ***************************************************************************************
 ***************************************************************************************
 ***************************************************************************************
 */
public class SherlockAndValidString {
	
	static String isValid(String s) {		
		HashMap<Character, Integer> mapped = mapTo(s);
		
		int minimum = -1;
		int value = -1;
		boolean allEquals = true;
		for (Map.Entry<Character, Integer> entry : mapped.entrySet()) {
			int current = entry.getValue();
			if (value == -1) {
				value = current;
				minimum = current;
			} else if (value != current){
				allEquals = false;
			}
			
			if (current < minimum) {
				minimum = current;
			}			
		}
		
		if (allEquals) {
			return "YES";
		}
		
		
		int deletions = 0;
		
		for (Map.Entry<Character, Integer> entry : mapped.entrySet()) {
			int current = entry.getValue();
			int calc = Math.abs(minimum - current);
			
			if (calc > 1) {
				System.out.println("NO HERE");
				return "NO";
			} else if(calc == 1) {
				deletions++;
			}
			
		}
		

		if (deletions <= 1) {
			return "YES";
		} else {
			return "NO";
		}
    }
	
	private static HashMap<Character, Integer> mapTo(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char key = s.charAt(i);
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
