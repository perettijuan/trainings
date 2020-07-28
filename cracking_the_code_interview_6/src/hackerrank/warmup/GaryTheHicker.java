package hackerrank.warmup;
//Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like 
//topography. During his last hike he took exactly 'n' steps. 
//For every step he took, he noted if it was an uphill, U , or a downhill, D step. 
//Gary's hikes start and end at sea level and each step up or down represents 
//a 1 unit change in altitude. We define the following terms:
//
//- A mountain is a sequence of consecutive steps above sea level, starting with 
//  a step up from sea level and ending with a step down to sea level.
//- A valley is a sequence of consecutive steps below sea level, starting with a 
//  step down from sea level and ending with a step up to sea level.
//
//Given Gary's sequence of up and down steps during his last hike, 
//find and print the number of valleys he walked through.
//
//For example, if Gary's path is s = [DDUUUDD], he first enters a valley 2 units deep. 
//Then he climbs out an up onto a mountain 2 units high. Finally, he returns to sea level and ends his hike.
//
//Function Description
//
//Complete the countingValleys function in the editor below. It must return an 
//integer that denotes the number of valleys Gary traversed.
//
//countingValleys has the following parameter(s):
//
// - n: the number of steps Gary takes
// - s: a string describing his path
//
//Input Format
//
//The first line contains an integer , the number of steps in Gary's hike.
//The second line contains a single string , of  characters that describe his path.
//
//Constraints
// - 2 <= n <= 10^6
// - s[i] is in {UD}
//
//Output Format
//
//Print a single integer that denotes the number of valleys Gary walked through during his hike.
//
//Sample Input
//8
//UDDDUDUU
//Sample Output
//1
//
//Input => 10, [DDDUUDUDDD] ====> output = 1
//Input => 10, [UDDDUUUDDU] ====> output = 2
//
//Algorithm:
//1 - Assign a numeric value to Ds and Us (D -> -1, U -> 1).
//2 - Process the array of numeric representation (iterating).
//3 - Sum the numeric representation of current and previous
//4 - If 3 is zero and it was a negative value before the sum -> count a valley.
//
//Basically, what I'm doing is counting the number of times the sum changes from negative to positive.
public class GaryTheHicker {
	
	static int countingValleys(int n, String s) {
	    if (n < 2 || n > Math.pow(10, 6)) {
	        return 0;
	    }

	    // Convert the String to an array of numeric representation
	    int[] numeric = new int[n];
	    for (int i = 0; i < n; i++) { 
	       char current = s.charAt(i);
	       if (current == 'U') {
	          numeric[i] = 1; 
	       } else {
	          numeric[i] = -1;
	       }
	    }

	   
	    int numberOfValleys = 0;
	    int level = 0; // sea level
	    for (int i = 0; i < numeric.length; i++) {
	        int current = numeric[i];
	    
	        int sum = level + current;
	        if (sum == 0 && level < 0) {
	            numberOfValleys = numberOfValleys + 1;
	        }

	        level = level + current;
	    }
	    
	    // if I'm done processing and never reached 0, then it means he never came out of the valley.
	    if (level < 0) {
	    	numberOfValleys = numberOfValleys + 1;
	    }

	    return numberOfValleys;
	}

}
