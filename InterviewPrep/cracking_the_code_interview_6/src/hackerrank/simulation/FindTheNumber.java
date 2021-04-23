package hackerrank.simulation;

import java.util.List;

public class FindTheNumber {
	
	public static String findNumber(List<Integer> arr, int k) {
		String result = "NO";
	    for (int current : arr) {
	    	if(current == k) {
	    		result = "YES";
	    		break;
	    	}
	    }
	    return result;
	}

}
