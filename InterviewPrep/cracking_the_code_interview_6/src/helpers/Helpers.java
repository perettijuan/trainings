package helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Helpers {
	
	/**
	 * Determinate if an array is sorted or not.
	 * @param array - the array to verify.
	 * @return true if it is sorted, false any other way.
	 */
	public static boolean isSorted(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {		
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Print the provided array into the console.
	 * @param arr
	 */
	public static void printArray(int[] arr) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		for (int i = 0; i < arr.length; i++) {
			buffer.append(arr[i] + " ");
		}
		buffer.append("]");
		System.err.println(buffer.toString());
	}
	
	/**
	 * Convert the provided String to an array of char.
	 * @param s
	 * @return
	 */
	public static char[] toChar(String s) {
		char[] asChar = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			asChar[i] = s.charAt(i);
		}
		return asChar;
	}
	
	/**
	 * Obtain all the sub-strings contained in s.
	 */
	public static HashMap<Integer, List<String>> getAllSubstrings(String s) {
		HashMap<Integer, List<String>> allSubstrings = new HashMap<Integer, List<String>>();			
		for (int i = 0; i < s.length(); i++) {
			for (int j = i+1; j <= s.length(); j++) {
				String subString = s.substring(i,j);
				int length = subString.length();
				if (length != s.length()) {
					if (allSubstrings.containsKey(length)) {
						List<String> sub = allSubstrings.get(length);
						sub.add(subString);							
					} else {
						List<String> sub = new ArrayList<String>();
						sub.add(subString);
						allSubstrings.put(length, sub);
					}	
				}								
		   }
		}
		return allSubstrings;
	}

}
