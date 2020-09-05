package hackerrank.problemsolving;

import java.util.ArrayList;
import java.util.List;

/*
 * Criteria:
 *  1 - length is >= 6
 *  2 - at least one digit (0,1,2,3,4,5,6,7,8,9)
 *  3 - at least one lower case.
 *  4 - at least one upper case.
 *  5 - at least one special character (!@#$%^&*()-+)
 * 
 * 
 * Result: minimum number of characters to add to make it strong.
 * 
 * 
 * input = Ab1
 * result = 3
 * 
 * input = #HackerRank
 * result = 1
 * 
 * input = Android123!
 * result = 0
 * 
 * input = ANDROID123!
 * result = 1
 * 
 * input = android123!
 * result = 1
 * 
 * input = Android123
 * result = 1
 * 
 * 
 * Algorithm:
 *  1 - check length --> if doesn't respect length, return 6 - length
 *  2 - iterate each character, check if it is a number. If no number is found, add 1.
 *  3 - iterate each character, check if lower case. If no lower case found, add 1.
 *  4 - iterate each character, check if upper case. If no upper case found, add 1.
 *  5 - iterate each character, check if special char. If no special char found, add 1.
 * 
 */
public class StrongPassword {

	private static final int MIN_LENGTH = 6;
	private static final List<Character> SPECIAL_CHARS = new ArrayList<Character>();
	
	static {
		SPECIAL_CHARS.add('!');
		SPECIAL_CHARS.add('@');
		SPECIAL_CHARS.add('#');
		SPECIAL_CHARS.add('$');
		SPECIAL_CHARS.add('%');
		SPECIAL_CHARS.add('^');
		SPECIAL_CHARS.add('&');
		SPECIAL_CHARS.add('*');
		SPECIAL_CHARS.add('(');
		SPECIAL_CHARS.add(')');
		SPECIAL_CHARS.add('-');
		SPECIAL_CHARS.add('+');
	}
	
	static int minimumNumber(int n, String password) {
		int minNumberToAdd = 0;
		
		if (n <= MIN_LENGTH) {
			return MIN_LENGTH - n;
		}
		
		if (!checkForNumbers(password)) {
			minNumberToAdd++;
		}
		
		if (!checkForLowerCase(password)) {
			minNumberToAdd++;
		}
		
		if (!checkForUpperCase(password)) {
			minNumberToAdd++;
		}
		
		if (!checkForSpecialCharacter(password)) {
			minNumberToAdd++;
		}
		
		return minNumberToAdd;
    }
	
	static final boolean checkForNumbers(String password) {
		boolean numberFound = false;
		
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				numberFound = true;
				break;
			}
		}
		
		return numberFound;
	}
	
	static final boolean checkForLowerCase(String password) {
		boolean lowerCaseFound = false;
		
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				lowerCaseFound = true;
				break;
			}
		}
		
		return lowerCaseFound;
	}
	
	static final boolean checkForUpperCase(String password) {
		boolean upperCaseFound = false;
		
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				upperCaseFound = true;
				break;
			}
		}
		
		return upperCaseFound;
	}
	
	static final boolean checkForSpecialCharacter(String password) {
		boolean specialCharFound = false;
		
		for (int i = 0; i < password.length(); i++) {
			if (SPECIAL_CHARS.contains(password.charAt(i))) {
				specialCharFound = true;
				break;
			}
		}
		
		return specialCharFound;
	}
	
}
