package exercises.chapter1;

/**
 * IS UNIQUE Implement an algorithm to determine if a String has all unique
 * characters. What is you cannot use additional data structures?
 *
 * EXAMPLES: 
 * - abcde -> true 
 * - #aifa -> false 
 * - #1 -> true 
 * - #122 -> false 
 * - #131 -> false 
 * - #34tU -> true 
 * 
 * ASSUMPTION: the input is a String and not a char array.
 */
public class Exercise1 {

	public static boolean isUnique(String input) {
		char[] inputAsChar = convertStringToCharArray(input);
		char current;
		
		for (int i = 0; i < inputAsChar.length; i++) {
			current = inputAsChar[i];
			int next = i + 1;

			if (next == inputAsChar.length - 1) {
				// reached the end	
				break;
			}

			for (int j = next; j < inputAsChar.length; j++) {
				char current2 = inputAsChar[j];
				if (current == current2) {
					// Found an equals
					return false;				
				}
			}
		}
		return true;
	}

	private static char[] convertStringToCharArray(String input) {
		char[] result = new char[input.length()];
		for (int i = 0; i < input.length(); i++) {
			result[i] = input.charAt(i);
		}
		return result;
	}
}
