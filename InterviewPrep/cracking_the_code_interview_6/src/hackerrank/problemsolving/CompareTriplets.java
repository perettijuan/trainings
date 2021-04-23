package hackerrank.problemsolving;

import java.util.ArrayList;
import java.util.List;

/*
 * a = [1,2,3]
 * b = [3,2,1]
 * 
 * [0] => 1 < 3 -> Point for Bob
 * [1] => 2 = 2 -> no point
 * [2] => 3 > 1 -> Point for Alice
 * 
 * [1,1]
 *  [0] -> Alice point
 * 
 * ALL GREEN
 * 7 minutes
 * 
 */
public class CompareTriplets {

	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int alicePoints = 0;
		int bobPoints = 0;
		
		if (a.get(0) > b.get(0)) {
			alicePoints++;
		} else if(a.get(0) > b.get(0)){
			bobPoints++;
		}
		
		if (a.get(1) > b.get(1)) {
			alicePoints++;
		} else if(a.get(1) > b.get(1)){
			bobPoints++;
		}
		
		if (a.get(2) > b.get(2)) {
			alicePoints++;
		} else if(a.get(2) > b.get(2)){
			bobPoints++;
		}
		
		result.add(alicePoints);
		result.add(bobPoints);
		
		return result;
    }
}
