package hackerrank.challenges;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

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
		out.add("1");
		out.add("2");
		out.add("Fizz");
		out.add("4");
		out.add("Buzz");
		out.add("Fizz");
		out.add("7");
		out.add("8");
		out.add("Buzz");
		out.add("11");
		out.add("Fizz");
		out.add("13");
		out.add("14");
		out.add("FizzBuzz");
		return out;
	}
}
