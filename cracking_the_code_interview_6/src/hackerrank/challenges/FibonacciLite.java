package hackerrank.challenges;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
 *
 *  Input = 12, Output = 144
 *   Fibonacci(12) => 0, 1, 1, 2, 3, 5, 8, 13, 21 34 55  89  144
 *                    0  1  2  3  4  5  6   7  8  9  10  11  12 
 *  
 *  Edge case = Input = 1, Output = 1
 */
public class FibonacciLite {

	/*
	 * This is the code to read the input for:
	 * https://www.hackerrank.com/contests/programming-interview-questions/
	 * challenges/fibonacci-lite
	 */
	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			int target = Integer.parseInt(line);
			// input
			//System.out.println("n = " + n);
			// output
			System.out.println(fibonacciFor(target));
		} catch (Exception e) {

		}
	}
	
	
	// base case
	public static int fibonacciFor(int target) { // target = 12 
		return fibonacci(0, 1, 0, target); 
	}
	
	
	private static int fibonacci(int n0, int n1, int progression, int target) { // n0 = 55, n1 = 89, progression = 10, target = 12
		if (progression == target) { // true
			return n0;
		}
		
		int next = n0 + n1; // next = 144
		int nextProgression = progression + 1; // 11
		
		
		
		return fibonacci(n1, next, nextProgression, target); // 55, 89, 10, 12
	}
}
