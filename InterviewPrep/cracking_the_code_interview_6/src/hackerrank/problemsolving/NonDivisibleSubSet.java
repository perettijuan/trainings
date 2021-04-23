package hackerrank.problemsolving;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/*
 * IMPORTANT = all integers in input are UNIQUE.
 * 
 * Maximal subset where the sum of any 2 numbers is not evenly divisible by k.
 * 
 * k = 3
 * S = {1,7,2,4}
 * 1 + 7 = 8 ==> 8/3 -> odd ------> 1,7
 * 1 + 2 = 3 ==> 3/3 -> even
 * 1 + 4 = 5 ==> 5/3 -> odd ------> 1,4
 * 7 + 2 = 9 ==> 9/3 -> even
 * 7 + 4 = 11 => 11/3 -> odd -----> 7,4
 * 2 + 4 = 6 ==> 6/3 -> even 
 * 
 * 1,7,4 completes the criteria => output = 3
 * 
 * Algorithm:
 * 1 - iterate the input and sum each element with each other.
 * 2 - if the division of the sum by k is odd, store the two elements in a list (or a set)
 * 3 - count the elements in the list
 * 
 * 
 * Extremely hard
 * Not solved
 */
public class NonDivisibleSubSet {
	
	public static int nonDivisibleSubset(int k, List<Integer> s) {	    
	    HashSet<Integer> subset = new HashSet<Integer>();
	    
	    for (int i = 0; i < s.size(); i++) {
	    	int currentI = s.get(i);
	    	for (int j = i+1; j < s.size(); j++) {
	    		int currentJ = s.get(j);
	    		
	    		int sum = currentI + currentJ;
	    		System.out.println("SUM " + sum);
	    		
	    		if (sum % k != 0) {
	    			System.out.println("Adding i " + currentI);
	    			System.out.println("Adding i " + currentJ);
	    			subset.add(currentI);
	    			subset.add(currentJ);
	    		}
	    		
	    	}
	    	
	    }

	    Iterator<Integer> it = subset.iterator();
	    while (it.hasNext()) {
	    	System.out.println("subset has " + it.next());
	    }
	    
	    return subset.size();
	}

}
