package exercises.chapter1;

/**
 * 
 * String Compression: Implement a method to perform basic string compression
 * using the counts of repeated characters. For example, the string aabcccccaaa
 * would become a2blc5a3. If the "compressed" string would not become smaller
 * than the original string, your method should return the original string. You
 * can assume the string has only uppercase and lowercase letters (a - z).
 * 
 * 
 * EXAMPLES: 
 * Input -> aabcccccaaa Output -> a2bc5a3
 * Input -> abcde Output -> abcde
 * Input -> bbAAtfEEut Output -> bbAAtfEEut (b2A2tfE2ut has the same size)
 * Input -> aaaaaaaaaaaaaB Output -> a13B
 * 
 * Output Format -> Character[number]
 * 
 * Approach: 
 * Iterate on the list of characters. 
 * Keep a counter of the current character. 
 * If I detect the next character is going to break the pattern,
 * store in an array list two positions: one for the character and one for the
 * counter. 
 * -- If the character has only one appearance, do not store the number. 
 * Check if the next string is larger than the Input and return the proper one.
 *
 */
public class Exercise5 {
	
	public static String compress(String input) { //aaaaaaaaaaaaaB

	    StringBuffer compressed = new StringBuffer();

	    int repeatedCounter = 1;
	    for (int i = 0; i < input.length(); ) { // i = 0
	        char currentChar = input.charAt(i); // currentChar = a
	      
	        int nextPosition = i + 1; // nextPosition = 2
	        while (nextPosition < input.length()) { // input.length() = 14
	            char nextChar = input.charAt(nextPosition); // nextChar = a

	            if (currentChar == nextChar) { // true
	              repeatedCounter = repeatedCounter + 1; // repeatedCounter = 2
	              nextPosition = nextPosition + 1; // nextPosition = 2
	            } else {
	              break; // while
	            }          
	        }

	        if (repeatedCounter > 1) { // repeatedCounter = 1 ==> false
	          compressed.append(currentChar); // compressed {}
	          compressed.append(repeatedCounter); // compressed {}
	        } else {
	          compressed.append(currentChar); // compressed {abcde}
	        }

	        repeatedCounter = 1;
	        i = nextPosition; // 5
	    }

	    if (compressed.length() < input.length()) {// compressed.length() = 5; input.length() = 5
	        return compressed.toString();
	    } else {
	        return input;
	    }
	 }
}
