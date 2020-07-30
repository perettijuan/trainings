package hackerrank.hashmaps;

import java.util.HashSet;

/*
 * Input:
 *  s1 = hello 
 *  s2 = world
 *  
 *   Share o => PRINT YES
 *   
 * Input:
 * 	s1 = hi
 *  s2 = world
 *    
 *    Do not share => PRINT NO
 *    
 * Input
 *   s1 = hello
 *   s2 = uyhhelo
 *   
 *    Share hel => PRINT YES
 *    
 * Can I simplify to assume that if they share a character, I should print YES?
 *    
 *    
 * Algorithm:
 * 1 - Iterate over s1 and put each character in a Set.
 * 2 - Iterate over s2 and if the current character is in 1, voila!
 *
 */
public class TwoStrings {
	
	static String twoStrings(String s1, String s2) {
		boolean shareSubString = false;
		
		HashSet<Character> set = new HashSet<>();
		
		for (int i = 0; i < s1.length(); i++) {
			set.add(s1.charAt(i));
		}
		
		for (int i = 0; i< s2.length(); i++) {
			if (set.contains(s2.charAt(i))) {
				shareSubString = true;
				break;
			}
		}
		
		
		if (shareSubString) {
			return "YES";
		} else {
			return "NO";
		}

    }

}
