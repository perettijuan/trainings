package handpicked;
/*
 * Amount of time to type a key rules:
 * 1 - 0 seconds to move finger to first key.
 * 2 - 0 seconds press the key where the finger is located any number of times.
 * 3 - 1 second move the finger to an adjacent key.
 * 4 - x seconds to move from a key to another key x keys far.
 * 
 * Return the minimum amount of time it takes to type the string input.
 * 
 * Example
 * s = 423692
 * keypad = 923857614
 * 			923
 * 			857
 * 			614
 * 
 *  Assum the finger is located in the first position
 *  
 *  4 -> 2 => 2
 *  2 -> 3 => 1
 *  3 -> 6 => 2
 *  6 -> 9 => 2
 *  9 -> 2 => 1 
 *   -----------
 *  		  8
 *  
 * s = 91566165
 * keypad = 639485712
 * 639
 * 485
 * 712
 * 			
 * 			
 * 
 * Starts at 9 
 *  9 -> 1 => 2
 *  1 -> 5 => 1
 *  5 -> 6 => 2
 *  6 -> 6 => 0
 *  6 -> 1 => 2
 *  1 -> 6 => 2
 *  6 -> 5 => 2
 *  -------------
 *  		11
 * Algorithm:
 *  For current, find all close adjacent and then find all fat adjacent
 *  			fin adjacent 
 *                 {-1,-1,},
 *                 {-1,0,},
 *                 {-1,1},
 *                 {0,-1},
 *                 {0,1},
 *                 {1,-1},
 *                 {1,0},
 *                 {1,1}
 *                 
 *                  Using this matrix, check boundaries
 *                  
 *  1 - Find the first key in the keypad.
 *  2 - Create the adjacent
 *       if next in s is in adjacent ==> +1
 *       else => +2
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
	
	
	static int[][] adjacentsMatrix = {
			{-1,-1},
			{0,-1},
			{1,-1},
			{-1,0},
			{1,0},
			{-1,1},
			{0,1},
			{1,1}
	};

	public static int timeToInput(String s, String keypad) {// 91566165
		if (s.length() == 0) {
			return 0;
		}
		
		int count = 0;
		char[][] keyPad = new char[3][3];
		
		keyPad[0][0] = keypad.charAt(0);
		keyPad[0][1] = keypad.charAt(1);
		keyPad[0][2] = keypad.charAt(2);
		
		keyPad[1][0] = keypad.charAt(3);
		keyPad[1][1] = keypad.charAt(4);
		keyPad[1][2] = keypad.charAt(5);
		
		keyPad[2][0] = keypad.charAt(6);
		keyPad[2][1] = keypad.charAt(7);
		keyPad[2][2] = keypad.charAt(8);
		
		for (int i = 0; i < s.length(); i++) {
			int nextIndex = i+1;
			if (nextIndex ==s.length()) {
				break;
			}
			
			
			char current = s.charAt(i);
			List<Character> adj = findAdjacents(current, keyPad);
			char next = s.charAt(nextIndex);
//			System.out.println("Current " + current);
//			System.out.println("next " + next);
			
//			for(int j = 0; j < adj.size(); j++) {
//				System.out.println("Adj j " + j + " is " + adj.get(j));
//			}
			
			if (current != next) {
				if (adj.contains(next)) {
					System.out.println("Current " + current);
					System.out.println("next " + next);
					System.out.println("Count 1");
					count = count +1;
				} else {
					System.out.println("Current " + current);
					System.out.println("next " + next);
					System.out.println("Count 2");
					count = count +2;
				}
			}
			
			//91566165
//			639
// 			485
// 			712
			
			System.out.println("------");
		}
		
        return count;
    }
	
	static List<Character> findAdjacents(char currentChar, char[][] keyPad) {
		ArrayList<Character> adjacents = new ArrayList<Character>();
		// find the element current char
		int x = -1;
		int y = -1;
		
		for (int row = 0; row < keyPad.length; row++) {
			for (int col = 0; col < keyPad[row].length; col++) {		
				if (currentChar == keyPad[row][col]) {
					x = col;
					y = row;				
					break;				
				}
			}
		}
		
		
		
		for (int col = 0; col < adjacentsMatrix.length; col++) {				
			int currentX = x + adjacentsMatrix[col][0];
			int currentY = y + adjacentsMatrix[col][1];			
			if (currentX >= 0 && currentX < 3
					&& currentY >=0 && currentY <3) {
				adjacents.add(keyPad[currentY][currentX]);
			}
		}
		
		return adjacents;
	}
	
}
