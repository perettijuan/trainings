package hackerrank.strings;
/*
 * 
 * S = AABAAB
 * 		I would need to remove A at 0 and one A 3
 * 	Output = 2
 * 
 * S = AAAA
 * 	Output = 3
 * 
 * S = BBBBB
 * 	Output = 4
 * 
 * S = ABABABAB
 *  O = 0
 * 
 * S = BABABA
 * 	O = 0
 * 
 * S = AAABBB
 * 	O = 4
 * 
 * 
 * Algorithm:
 * 1 - Iterate the input with two index: i = 0 and j = i+1
 * 2 - If S[i] == S[j] ==> Count removed.
 * 3 - Watch out for = j < length - 1 (?) 
 * 
 * TIME: 13 minutes
 * STATUS: ALL GREEN
 * 
 */
public class AlternatingCharacters {

	
	static int alternatingCharacters(String s) { // AAAA
		int deletions = 0;
		
		for (int i = 0; i < s.length(); i++) { //i = 3; s.length = 4
			int j = i + 1; // j = 4
			
			if (j < s.length())  {
				if (s.charAt(i) == s.charAt(j)) { // s[i] = A; s[j] = A
					deletions++; // 2
				}				
			}			
		}

		return deletions;
    }
	
}
