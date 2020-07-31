package hackerrank.hashmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * abba
 *  a,a
 *  b,b
 *  ab, ba
 *  abb, bba
 *    => output = 4
 *  
 * abcd
 *    => output = 0
 *    
 * ifailuhkqq
 *    i,i
 *    q,q
 *    ifa,fai
 *     => output = 3
 * 
 * kkkk
 *  k,k => 6 anagrams [0,1][0,2][0,3][1,2][1,3][2,3]
 *  kk,kk => 3 anagrams [[0,1][1,2]] - [[0,1][2,3]] - [[1,2][2,3]]
 *  kkk,kkk => 1 anagram [0,1,2][1,2,3]
 *  	=> output = 10
 * cdcd 
 *  c,c => 1
 *  d,d => 1
 *  cd,dc => 1
 *  cd,cd => 1
 *  dc,cd => 1
 *  	=> output = 5
 *    
 * Algorithm:
 * 1 - Use a HashMap<Int,List<String>> key = length, value = all substrings that are length
 * 2 - For each key in 1, check if the list contains anagrams.
 *  
 *  
 * 
 *  In order to be anagrams, two strings must:
 *   1 - Have the same length.
 *   2 - Have the same characters (the same number of times), no matter how they
 *       are positioned (?).
 *             
 */
public class Anagrams {

	static int sherlockAndAnagrams(String s) {
		int numberOfAnagrams = 0;
		HashMap<Integer, List<String>> allSubstrings = getAllSubstrings(s);
		
		
		for (Map.Entry<Integer, List<String>> entry : allSubstrings.entrySet()) {
			int key = entry.getKey();
			List<String> value = entry.getValue();
			System.out.println("IS " + key + ", " + value);
			
			for (int i = 0; i < value.size(); i++) {
				  for (int j = i+1; j < value.size(); j++) {
				    if (areAnagrams(value.get(i), value.get(j))) {
				    	System.out.println("Are anagrams = " + value.get(i) + "," + value.get(j));
				    	numberOfAnagrams++;
				    }
				 }
			}
			
		}
		

		return numberOfAnagrams;
	}

	/**
	 * Obtain all the sub-strings contained in s.
	 */
	private static HashMap<Integer, List<String>> getAllSubstrings(String s) {
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
	
	
	/**
	 * Determinate if the two strings provided are anagrams.
	 * The solution is basically to sort the arrays and compare
	 * one by one the results.
	 */
	private static boolean areAnagrams(String one, String two) {
		char[] s1 = one.toCharArray();
		char[] s2 = two.toCharArray();
		
		int n1 = s1.length;
		int n2 = s2.length;
		
		if (n1 != n2) {
			return false;
		}
		
		boolean areAnagrams = true;
		
		Arrays.sort(s1);
		Arrays.sort(s2);
	
		for (int i = 0; i < n1; i++) {
			if (s1[i] != s2[i]) {
				areAnagrams = false;
				break;
			}
		}
		return areAnagrams;
	}

}
