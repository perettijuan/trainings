package hackerrank.simulation;

import java.util.ArrayList;
import java.util.List;

public class OddNumbers {

	public static List<Integer> oddNumbers(int l, int r) {
		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = l; i < r; i++) {
			if (i % 2 != 0) {
				result.add(i);
			}				
		}

		return result;
	}
}
