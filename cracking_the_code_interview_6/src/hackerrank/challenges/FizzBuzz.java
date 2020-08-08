package hackerrank.challenges;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * 
 * Given a number n print all numbers from 1 to n but:
 * 
 *   1 - for numbers divisible by 3 -> print Fizz
 *   2 - for numbers divisible by 5 -> print Buzz
 *   3 - for numbers divisible by 3 and 5 -> print FizzBuzz
 *   
 * How to know if a number(n) is visible by another (a)
 *   if (n % a == 0) {
 *   	true
 *   }
 *   
 * ALL GREEN 
 * 10 MINUTES  
 * 
 */
public class FizzBuzz {

	public static void main(String[] args) {		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			int n = Integer.parseInt(line);
			// input
			System.out.println("n = " + n);
			// output
			System.out.println(1);
			
			List<String> out = fizz(n);
			
			for (String val : out) {
				System.out.println(val);
			}
			
		} catch (Exception e) {

		}
	}
	
	/*
	 * Expected output format:
	 * 1
	   2
	   Fizz
	   4
	   Buzz
	   Fizz
	   7
	   8
	   Fizz
	   Buzz
	   11
	   Fizz
	   13
	   14
	   FizzBuzz
	 */
	
	static List<String> fizz(int n) {
		List<String> out = new ArrayList<String>();
		
		for (int i = 0; i < n; i++) {
			boolean divBy3 = isDivisible(i, 3);
			boolean divBy5 = isDivisible(i, 5);
			
			if (divBy3 && divBy5) {
				out.add("FizzBuzz");
			} else if(divBy3) {
				out.add("Fizz");
			} else if(divBy5) {
				out.add("Buzz");
			} else {
				out.add(""+i);
			}			
		}
		
		
		return out;
	}
	
	
	static boolean isDivisible(int n, int a) {
		if (n% a == 0) {
			return true;
		} else {
			return false;
		}
	}
}
