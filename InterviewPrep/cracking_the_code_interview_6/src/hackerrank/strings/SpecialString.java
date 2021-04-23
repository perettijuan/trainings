package hackerrank.strings;

/*
 * Conditions for special strings:
 *  1 - all characters are the same.
 *  2 - all characters except the middle one are the same.
 *  
 * A special substring is a substring of a string that meets one of 
 * those criteria.
 * 
 * Find all special substrings of a string
 * 
 * Example: s = "mnonopoo"
 * especial substrings = {m, n, o, n,o, p, o, o, non, ono, opo, oo}
 * Output = 12
 * 
 * Input = asasd
 * Special substrings = {a, s, a, s, d, asa,sas}
 * Output = 7
 * 
 * Input = abcbaba
 * SS = {a,b,c,b,a,b,a,bcb,bab,aba}
 * Output = 10   
 * 
 * Input = aaaa
 * SS = {a, a, a, a, aa, aa, aa, aaa, aaa, aaaa}
 * Output = 10
 * 
 * Algorithm:
 *  1 - Iterate the whole input, with n = 1...input.length
 *  2 - For each n, determinate how many special strings I have.
 *       (going from i = 0 to the end, compare each substring)
 *       - if number is even => all letters have to be the same.
 *       - if number is odd => all letters are the same
 *       					   middle is different, all to left and right are the same. 
 * 
 *
 *
 * DONE (TIME LIMIT)
 * TOOK ME 56 minutes
 *
 */
public class SpecialString {
	
	static long substrCount(int n, String s) {
		long count = 0;
		int substringLength = 1;
		
		while (substringLength < n+1) {
			count = count + getSubtringEquals(substringLength, s);
			
			if (n % 2 != 0) {
				count = count + getSubstringCountOddLength(substringLength, s);
			}
			
			
			substringLength++;
		}
		

		return count;
    }
	
	
	static long getSubtringEquals(int length, String s) {
		long count = 0;
		int lengthIndex = length - 1; 
		
		for (int i = 0; i < s.length(); i++) {
			int endingIndex = i + lengthIndex; 
			
			
			
			if (endingIndex == s.length()) {				
				break;
			}
			
			boolean areEquals = true;
			for (int j = i + 1; j <= endingIndex; j++) {
				
				
				if (s.charAt(i) != s.charAt(j)) {					
					areEquals = false;
					break;
				}
			}	
			
			if (areEquals) {
				count++;
			}
		}	
		
		System.out.println("for length " + length + " count is " + count);
		return count;
	}
	
	static long getSubstringCountOddLength(int length, String s) {// abcbaba, l = 3
		if (length == 1) {
			return 0;
		}
		
		long count = 0;
		
		int lengthIndex = length - 1; // 2
		for (int i = 0; i < s.length(); i++) {
			int endingIndex = i + lengthIndex; 
			int middleIndex = mid(i, endingIndex);
			char current = s.charAt(i);
			
			if (endingIndex == s.length()) {
				break;
			}
			
			boolean areEquals = true;
			
			for (int start = i + 1; start < middleIndex; start++) {
				if (current != s.charAt(start)) {
					areEquals = false;
					break;
				}
			}
			
			if (areEquals) {
				for (int end = endingIndex; end > middleIndex; end--) {
					if (current != s.charAt(end)) {
						areEquals = false;
						break;						 
					}
				}
			}
			
			if (areEquals) {
				count++;
			}
			
		}
		
		System.out.println("ODD - for length " + length + " count is " + count);
		return count;
	}
	
	public static int mid(int x, int y) {
	    return (int) (((long)x + y) / 2);
	}

}
