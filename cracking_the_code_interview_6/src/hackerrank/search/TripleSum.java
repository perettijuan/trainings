package hackerrank.search;
/*
 * Arrays a, b and c
 * Find the number of distinct triplets (p,q,r)
 * Where p belongs to a
 * 		 q belongs to b
 * 		 r belongs to c
 * And p =< q and q >= r
 * 
 * Example:
 * a = {1,3,5}
 * b = {2,3}
 * c = {1,2,3}
 * 
 * 1,2,1
 * 1,2,2
 * 1,3,1
 * 1,3,2
 * 1,3,3
 * 3,3,1
 * 3,3,2
 * 3,3,3
 * 
 * Output = 8
 * 
 * Algorithm:
 * Put a and b in a Hashmap key = a[i] and value = frequency
 * 
 * 1 - Use b as pivot (b/c all b are potential q)
 * 2 - for q go down to zero
 * 
 * 
 * Green (with time outs)
 * 30 minutes
 * 
 * 
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TripleSum {
	
	static long triplets(int[] a, int[] b, int[] c) {
		long triplets = 0;
		
		Set<Integer> bAsSet = new HashSet<Integer>();
		for (int i = 0; i < b.length; i++) {
			bAsSet.add(b[i]);
		}
		
		Iterator<Integer> it = bAsSet.iterator();
		while(it.hasNext()) {
			int q = it.next();
			for (int j = 0; j < a.length; j++) {
				int p = a[j];
				
				if (p <= q) {
					for (int k = 0; k < c.length; k++) {
						int r = c[k];
						
						if (r <= q) {							
							triplets++;
						}					
					}					
				}				
			}	
		}
		return triplets;
    }
	
	

}
