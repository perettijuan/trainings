package hackerrank.problemsolving;
/*
 * Input = array {a...z}
 * 
 * 
 * On each operation select a pair of adjacent lowercase letters that match and
 * delete them.
 * 
 * For instance:
 * 
 * aabbbdeegoo => bdg
 * 
 * aaaaaaaaaaa => a
 * 
 * aaaaaaaaaa => Empty String
 * 
 * baab => Empty String (delete aa and then delete bb)
 * 
 * 
 * IMPORTANT HERE: After each operation I have to re-check the result.
 * 
 * Algorithm
 * 1 - CONTROL: a flag that indicates if the whole string has been processed.
 * 2 - Iterate the chars in the string and compare i with i+1
 *     Remove in string with = s.substring(i, i+1) // verify with a test.
 * 3 - Update control when reaching the end of the string and no duplicates are present.    
 * 
 * 
 * ALL GREEN
 * 25 Minutes
 * Easy - Medium
 */
public class SuperReducedString {

	
	static String superReducedString(String s) {
		StringBuilder sb = new StringBuilder(s);		
		boolean control = true;
		
		while (control) {
			
			for (int i = 0; i < sb.length(); i++) {
				
				if (i+1 == sb.length()) {
					control = false;
					break;
				}
				
				
				char current = sb.charAt(i);
				char next = sb.charAt(i + 1);
				
				if (current == next) {					
					sb.delete(i, i+2);
					
					if (sb.length() == 0) {
						control = false;
						break;
					}
					
					
					break;
				}				
			}
			
			
		}
		
		if (sb.length() == 0) {
			return "Empty String";
		}
		
		return sb.toString();
    }
}
