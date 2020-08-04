package hackerrank.sorting;

import java.util.Comparator;
import java.util.HashMap;

/*
 * compareTo(a, b) - should return -1 => a < b
 * 				   - should return 0 => a = b
 * 				   - should return 1 => a > b	
 * 
 * 
 * First sort descending by score.
 * Second sort ascending by name.
 *
 * Descending by score is simple.
 * 
 * Ascending by name
 *   - create a hashmap <character, integer> where value is the weight of each letter.
 *   - iterate the name of the Player and assign a weight to the name, based on 1.
 *   
 *   
 *   
 * Input =
 *      Player("Jones", 20)
 *      Player("Asange", 30)
 *      Player("Jonesi", 20) 
 *      
 *        
 * TOOK ME AN HOUR AND 14 MINUTES 
 *   THE PROBLEM: I JUMPED TO CODE BEFORE UNDERSTANDING THE PROBLEM!!!        
 *
 */
public class Checker implements Comparator<Player> {

	private static HashMap<Character, Integer> alphabetWeights = new HashMap<Character, Integer>();

	public Checker() {
		alphabetWeights.put('a', 1);
		alphabetWeights.put('b', 2);
		alphabetWeights.put('c', 3);
		alphabetWeights.put('d', 4);
		alphabetWeights.put('e', 5);
		alphabetWeights.put('f', 6);
		alphabetWeights.put('g', 7);
		alphabetWeights.put('h', 8);
		alphabetWeights.put('i', 9);
		alphabetWeights.put('j', 10);
		alphabetWeights.put('k', 11);
		alphabetWeights.put('l', 12);
		alphabetWeights.put('m', 13);
		alphabetWeights.put('n', 14);
		alphabetWeights.put('o', 15);
		alphabetWeights.put('p', 16);
		alphabetWeights.put('q', 17);
		alphabetWeights.put('r', 18);
		alphabetWeights.put('s', 19);
		alphabetWeights.put('t', 20);
		alphabetWeights.put('u', 21);
		alphabetWeights.put('v', 22);
		alphabetWeights.put('w', 23);
		alphabetWeights.put('x', 24);
		alphabetWeights.put('y', 25);
		alphabetWeights.put('z', 26);
	}

	@Override
	public int compare(Player a, Player b) {
		int compare = compareScore(a, b);
		if (compare == 0) {
			compare = compareNames(a, b);
		}

		return compare;
	}

	private int compareScore(Player a, Player b) {
		if (a.score > b.score) {
			return -1;
		} else if (a.score == b.score) {
			return 0;
		} else {
			return 1;
		}
	}

	private int compareNames(Player a, Player b) {
		String nameA = a.name;
		String nameB = b.name;

		if (nameA.length() <= nameB.length()) {
			return compareNamesEqualLength(nameA, nameB);
		} else {
			int compared = compareNamesEqualLength(nameB, nameA);

			if (compared == -1) {
				return 1;
			} else if (compared == 1) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	private int compareNamesEqualLength(String a, String b) {
		int compared = 0;
		char[] shortArr = toLowerCaseArray(a);
		char[] longArr = toLowerCaseArray(b);

		for (int i = 0; i < shortArr.length; i++) {
			int shW = alphabetWeights.get(shortArr[i]);
			int loW = alphabetWeights.get(longArr[i]);

			if (shW < loW) {
				compared = -1;
			} else if (shW > loW) {
				compared = 1;
			}

			if (compared != 0) {
				break;
			}
		}
		
		if (compared == 0) {
			return -1;
		}
		
		return compared;
	}

	private char[] toLowerCaseArray(String string) {
		char[] lower = new char[string.length()];
		for (int i = 0; i < lower.length; i++) {
			lower[i] = Character.toLowerCase(string.charAt(i));
		}

		return lower;
	}

}
