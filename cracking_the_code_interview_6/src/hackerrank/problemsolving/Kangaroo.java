package hackerrank.problemsolving;
/*
 * Starting position 
 *   x1
 *   x2
 * 
 * Meters rate per jump
 * 	 v1
 * 	 v2
 * 
 * Will ever meet?
 * 
 * 
 * VERY IMPORTANT = they have to meet after the same number of jumps!
 * 
 * 
 * x1 = 0, v1 = 3
 * x2 = 4, v2 = 2
 * 
 *  k1(0+3 = 3 + 3 = 6 + 3 = 9 + 3 = 12)
 *  k2(4+2 = 6 + 2 = 8 + 2 = 10 + 2 = 12)
 * 
 * 
 * x1 + v1(a1) = x2 + v2(a1)
 * x1 - x2 = v2(a1) - v1(a1)
 * x1 - x2 = (v2 - v1)a1
 * x1 - x2
 * ------- = 0 ?
 * v2 - v1
 * 
 * -4
 * -- = 4
 * -1
 * 
 * 
 * Algorithm:
 * 
 *  1 - Find the number of jumps using the equation.
 *  2 - If 1 is an int, then they can meet.
 * 
 */
public class Kangaroo {

	static String kangaroo(int x1, int v1, int x2, int v2) {
		float jumps = (x1 - x2) / (v2 - v1);
		System.out.println("jumps " + jumps);
		if (jumps % 1 == 0) {
			return "YES";
		} else {
			return "NO";
		}
    }
}
