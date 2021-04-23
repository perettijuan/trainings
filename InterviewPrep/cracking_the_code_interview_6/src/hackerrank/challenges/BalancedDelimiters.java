package hackerrank.challenges;

import java.util.*;

/*
 * A balanced delimiter: 
 * 	- starts with an opening character => (,{ or [
 *  - may contain any number of balanced delimiters. 
 * 	- has only other matching delimiter => ), } or ] 
 * 
 * 
 * Examples
 *  - ()[]{}
 *  - ({[]})
 *  - ([]{})
 *  - (())
 *  - {()}(){}[]
 *  - {([{}])}
 *  - {()}({}[])
 *  - {()}(()[])
 *  
 * Examples Not valid
 * 	- ([)
 *  - ([})
 *  - ({[})
 *    
 * For every opening delimiter, I have to be able to find the closing delimiter.
 * 
 * 
 * Algorithm:
 *  - Start iterating with i = 0. If current character is an opening char -> find the closing one.
 *  - Find the closing character: iterate with j = i+1 and try to find the closing character.
 *  
 *  Better:
 *   - HashMap<Character, Count> -> Character either closing or opening.
 *   - Count all occurrencies.
 *   - Iterate the HM, Opening must match closing.
 *
 * ALL GREEN
 * 35 MINUTES
 */
public class BalancedDelimiters {
	
	/*
	 * This is the code to read the input for:
	 * https://www.hackerrank.com/contests/programming-interview-questions/challenges/balanced-delimiters
	 */
//	public static void main(String[] args) {      
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String line = br.readLine();
//           
//            //input
//            System.out.println("input = " + line);
//            //output
//            System.out.println("True");
//        } catch (Exception e) {
//
//        }
//    }
	
	public static boolean isBalanced(String input) { // ([()]
		boolean balanced = true;
		HashMap<Character, Integer> mapped = new HashMap<Character, Integer>();
		System.out.println("1");
		for (int i = 0; i < input.length(); i++) {
			char key = input.charAt(i);
			
			if (mapped.containsKey(key)) {
				int value = mapped.get(key);
				mapped.put(key, value + 1);
			} else {
				mapped.put(key, 1);
			}			
		}
		
		boolean balance1 = true;
		boolean balance2 = true;
		boolean balance3 = true;
		
		
		for(Map.Entry<Character, Integer> entry : mapped.entrySet()) {
			char key = entry.getKey();
			
			if (key == '(') {
				char closing = ')';
				int count = entry.getValue();
				if (mapped.containsKey(closing) && mapped.get(closing) == count) {					
					balance1 = true;
				} else {					
					balance1 = false;
				}
			}
			
			if (key == '{') {
				char closing = '}';
				int count = entry.getValue();
				if (mapped.containsKey(closing) && mapped.get(closing) == count) {
					balance2 = true;
				} else {					
					balance2 = false;
				}
			}
			
			if (key == '[') {
				char closing = ']';
				int count = entry.getValue();			
				if (mapped.containsKey(closing) && mapped.get(closing) == count) {
					balance3 = true;
				} else {					
					balance3 = false;
				}
			}
			
		}
		
		if (balance1 && balance2 && balance3 ) {
			balanced = true;
		} else {
			balanced = false;
		}
		
		return balanced;
	}
	
	
//	public static boolean isBalanced(String input) { // ([()]
//		boolean balanced = true;
//
//		for (int i = 0; i < input.length(); i++) { //i = 0
//			char current = input.charAt(i); // current = (
//
//			if (current == '(' || current == '{' || current == '[') {
//				char enclosing = getEnclosingFor(current);
//				boolean foundEnclosing = false;
//				
//				for (int j = i+1; j < input.length(); j++) {									
//					if (enclosing == input.charAt(j)) {
//						foundEnclosing = true;
//						break;
//					}
//				}
//				
//				if (!foundEnclosing) {
//					balanced = false;
//					break;
//				}				
//			}
//		}
//
//		return balanced;
//	}
//	
//	private static char getEnclosingFor(char opening) {
//		switch (opening) {
//		case '(':
//			return ')';
//		case '{':
//			return '}';
//		case '[':
//			return ']';
//		default:
//			throw new IllegalArgumentException("Can't find enclosing for " + opening);
//		} 
//	}

}
