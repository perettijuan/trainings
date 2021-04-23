package handpicked;

import java.util.ArrayList;
import java.util.List;

/*
 * THINK McFly, THINK!!!!
 * 
 * Sells words that don't have adjacent matching characters.
 * 
 * 
 * Examples:
 * add -> need to replace 2nd d ==> 1
 * boook -> need to replace 2nd o ==> 1
 * break -> no need to replace
 * 
 * Out => [1,1,0]
 *	
 *	ab -> 0
 *	aab -> 1
 *	abb -> 1
 *	abab -> 0
 *	abaaaba -> 1
 *	abaaaaba -> 11 => 2
 *
 *  abbaabaaabbcccd => 1b1a1a1b1c
 *  
 *  
 *  Algorithm:
 *  Iterate each string in words *  
 *  if 1st char == 2nd char, count one change and change the char
 *  at 2nd char position for a - 
 *    
 *
 *
 *
 */
public class Problem1 {
	
	public static List<Integer> minimalReplaces(List<String> words) {
		ArrayList<Integer> count = new ArrayList<Integer>();
		
		for (String word : words) {		
			count.add(countCharsToChagne(word.toCharArray()));			
		}
		
        // Write your code here
        return count;
    }
	
	
	static int countCharsToChagne(char[] word) {
		int charsToChange = 0;
		
		for (int i = 0; i < word.length; i++) {
			int next = i + 1;
			if (next == word.length) {
				break;
			}
			
			if (word[i] == word[next]) {
				charsToChange++;
				word[next] = '-';
			}		
		}
		
		
		return charsToChange;
	}

}
