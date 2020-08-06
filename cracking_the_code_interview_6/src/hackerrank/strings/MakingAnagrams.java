package hackerrank.strings;

/*
 * Two Strings are anagrams if the letters of one can be re-arranged to
 * form the other string.
 * 
 * CONDITIONS:
 *  1 - Must contain the same exact letters.
 *  2 - 1 in the same frequency.
 *  
 * Example:
 * 	bacdc
 * 	dcbac
 * 	OK
 *  
 *  bacdc
 *  dcbad
 *  NO
 *  
 *  Output: minimum number of deletion to make the two strings anagrams.
 *  
 * Example 1:
 * 	a = cde
 * 	b = dcf
 * 		Anagrams cd-dc / delete e and f
 *  Output = 2 (3-1; 3-1)
 *  
 * Example 2:
 * 	a = cde
 * 	b = abc
 * 		Anagram: c (3-1 = 2; 3-1=2)
 *	Output: 4
 *
 * Example 3:
 * 	a = abdfr
 * 	b = rtfbh
 * 		Common letters: bfr
 *  Output: 4 (a.length - anagram.length + b.length - anagram.length)
 *  
 * Example 4
 * 	a = abcc
 * 	c = cbfd
 * 		Common letters = bc
 *  Output = 4  (a.length - anagram.length + b.length - anagram.length)
 *  
 * Example 5:
 * 	a = bacdc
 * 	b = dcbac 
 *  	Common letters = bacdc
 *  Output = 0 (5-5; 5-5)
 *  
 * Example 6:
 * 	a = abgtrq
 * 	b = fgtr 
 * 
 * Example 7:
 *  a = bacdc
 *  b = dcbad
 *  	Common letters = bacd
 *  
 * Algorithm:
 * 1 - 
 *  
 *  
 * 
 */
public class MakingAnagrams {
	
	static int makeAnagram(String a, String b) { // a = cde b = abc
		int commonLength = findCommonLength(a, b);
		int removals = (a.length() - commonLength) + (b.length() - commonLength);
		
		
		
		return removals;
    }
	
	private static int findCommonLength(String a, String b) { 
		int length = 0;
		for (int i = 0; i < a.length(); i++) { // i  = 2
			char current = a.charAt(i); // current = e
			for (int j = 0; j <b.length(); j++) { //j = 0
				if (current == b.charAt(j)) { // b.charAt(j) = c
					System.out.println("Count " + current + " and "  + b.charAt(j));
					length++; // length = 1
				}
			}
		}
		
		return length;
	}

	
	
	
}
