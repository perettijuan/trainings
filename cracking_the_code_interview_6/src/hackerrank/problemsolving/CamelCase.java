package hackerrank.problemsolving;
/*
 * 
 * Properties:
 *  1 - it is a concatenation of one or more words consisting on English letters.
 *  2 - all letters in the first word are lowercase.
 *  3 - for each subsequent word, the first letter is UPPERCASE and the rest are lowercase.
 *  
 *  
 * example:
 *  oneTwoThreeFour -> one, Two, Three, Four => 4 
 *  one -> one => 1
 *  basketCase -> basket, Case => 2
 * 
 * 
 * algorithm: count the Upper cases and add 1
 * 
 */
public class CamelCase {

	static int camelcase(String s) { // oneTwoThreeFour
		int count = 1;

		for (int i = 0; i < s.length(); i++) { // i = 3
			if (Character.isUpperCase(s.charAt(i))) { //  char[i] = T 
				count = count + 1; // count = 2
			}
		}
		
		return count;
    }
	
}
