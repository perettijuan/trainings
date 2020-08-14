package hackerrank.problemsolving;

import java.util.ArrayList;

/*
 * Remove characters until the string is made up of any alternating characters.
 * When a character is chosen to be removed, all occurrences must be removed.
 * GOAL: create the longest string possible that contains just two alternating characters.
 * 
 * Example: 
 * abaacdabd -> remove a => bcdbd
 * 				remove c => bdbd
 * 
 * Print the length of the resulting string.
 * If no string can be made, print 0.
 * 
 * 
 * adafduf => remove a => dfduf
 * 			  remove u => dfdf
 * 
 * beabeefeab -> remove e => babfab
 *            -> remove f => babab
 *            
 * abdc -> 0
 * aaaa -> 0           
 * a -> 0
 * 
 * KEY = 2 alternating characters
 * 
 * Algorithm:
 *  1 - find all non-repeated characters in the string.
 *  2 - create all the possible combinations of two characters we can get.
 *  3 - for each (2), try to remove all other characters from the String and
 *  	validate if the string is valid
 * 
 * NOT SOLVED
 * LISTED AS EASY, BUT IT IS SUPER HARD (COMMENTS VALIDATE THIS)
 */
public class TwoCharacters {
	
	static int alternate(String s) {
		int result = 0;
		StringBuilder sb = new StringBuilder(s);	
		
		ArrayList<Character> nonRepeated = findNonRepeated(s);
		
		for (int i = 0; i < nonRepeated.size() - 1; i++) {
			char first = nonRepeated.get(i);			
			for (int j = i+1; j < nonRepeated.size(); j++) {
				char second = nonRepeated.get(j);
							
			}			
		}
		

		return result;
    }
	
	static ArrayList<Character> findNonRepeated(String s) {
		ArrayList<Character> nonRepeteated = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			if (!nonRepeteated.contains(current)) {
				nonRepeteated.add(current);
			}
		}		
		return nonRepeteated;
	}
	
	static boolean isValid(char first, char second, String s) {
		boolean isValid = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != first && s.charAt(i) != second) {
				isValid = false;
				break;
			}
		}		
		return isValid;
	}

}
