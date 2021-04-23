package exercises.chapter1;

/**
 * 
 *URLify: Write a method to replace all spaces in a string with '%20'. 
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string. 
 * (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith ", 13 
 * Output: "Mr%20John%20Smith"
 *
 * Input: "My airplane", 11
 * Output: "My%20airplane" 
 * 
 * Input: "NoSpaces", 8
 * Output: "NoSpaces" 
 * 
 * QUESTION:
 * Should ignore all characters of the input that are beyond the provided length? 
 * For instance: 
 *              Input = "Mr John Smith And", 13 
 *               Output: "Mr%20John%20Smith"
 * 
 *     ASSUMPTION ===> YES
 * 
 *
 * My first approach was to have a simple char array and replace the spaces
 * with a char = '%20'. The problem is that %20 is not a char, is a String!
 */
public class Exercise3 {

	public static String urlIfy(String input, int length) { // input = "Mr John Smith" , length = 13, Output: "Mr%20John%20Smith"
	    char[] inputAsCharArray = convertStringToCharArray(input);
	    
	    int newLength = length;
	    for (int i = 0; i < length; i++) { // i = 2
	        if (inputAsCharArray[i] == ' ') { // inputAsCharArray[i] = space
	            newLength = newLength + 2; // I need 2 positions for %20
	        } // newLength = 17
	    }

	    char[] outputAsChar = new char[newLength];
	    int newArrayIndex = 0;
	    for (int i = 0; i < length; i++) { // i = 12
	        // newArrayIndex = 14
	        if (inputAsCharArray[i] == ' ') { // inputAsCharArray[i] =  h
	            outputAsChar[newArrayIndex] = '%'; 
	            outputAsChar[newArrayIndex + 1] = '2';
	            outputAsChar[newArrayIndex + 2] = '0';
	            newArrayIndex = newArrayIndex + 3; // newArrayIndex = 10
	        } else {
	            outputAsChar[newArrayIndex] = inputAsCharArray[i]; // outputAsChar[newArrayIndex] = h
	            newArrayIndex = newArrayIndex + 1; // newArrayIndex = 15
	        }

	        // outputAsChar = Mr%20John%20Smith
	    }

	    return String.valueOf(outputAsChar);
	}


	private static char[] convertStringToCharArray(String input) {

	    char[] output = new char[input.length()];

	    for (int i = 0; i < input.length(); i++) {
	        output[i] = input.charAt(i);
	    }

	    return output;
	}
}
