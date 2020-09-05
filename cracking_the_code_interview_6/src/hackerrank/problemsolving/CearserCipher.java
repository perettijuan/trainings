package hackerrank.problemsolving;
/*
 * Cipher: shifts a letter with another one by rotating the alphabet k positions.
 * 
 * k = 3
 * 		abcdefghijklmnopqrstuvwxyz
 *  	defghijklmnopqrstuvwxyzabc
 *  
 *  My dog is bad
 *  pb grj lv edg
 *  
 *   
 * I could probably use a HashMap
 * 	where key is the original letter
 *  value is the rotated one
 *  
 * Create the map
 * 	For loop for alphabet size
 *   i = current letter in the alphabet
 *   kI = i + k
 *   kI0 = 0
 *   
 *   if (kI < alphabet.size) {
 *   	use kI
 *   } else {
 *   	use kI0
 *   	then kI0++
 *   }
 * 
 * 
 * 
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class CearserCipher {
	
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private static final String ALPHABETUPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	static String caesarCipher(String s, int k) {
		StringBuffer sb = new StringBuffer();
		
		Map<Character, Character> map = createRotatedAlphabet(ALPHABET.toCharArray(), k);
		Map<Character, Character> mapUpper = createRotatedAlphabet(ALPHABETUPPER.toCharArray(), k);
		
		for (int i = 0; i < s.length(); i++) {
			char key = s.charAt(i);
			
			if (Character.isLetter(key)) {
				if (Character.isUpperCase(key)) {
					sb.append(mapUpper.get(key));
				} else {
					sb.append(map.get(key));
				}
			} else {
				sb.append(key);	
			}
			
		}
		
		return sb.toString();
    }
	
	
	static Map<Character, Character> createRotatedAlphabet(char[] alphabet, int k) { // abcdefghijklmnopqrstuvwxyz, k = 3
		HashMap<Character, Character> mapped = new HashMap<Character, Character>();
		
		
		int kI = k; // kI = 3
		
		if (k > 26) {
			kI = k % 26;
		}
		
		int kI0 = 0;
		for (int i = 0; i < alphabet.length; i++) { // i = 0
			char current = alphabet[i]; // a
			char rotated; 
			
			// alphabet.length = 26
			if (kI < alphabet.length) { // true
				rotated = alphabet[kI]; // rotated = g
				kI++; // kI = 7
			} else {
				rotated = alphabet[kI0];
				kI0++;
			}
			
			mapped.put(current, rotated);
		}
		
		
		return mapped;
	}

}
