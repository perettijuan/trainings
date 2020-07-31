package hackerrank.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MToLastElement {

	public static void main(String[] args) {
		/*
		 * This is the code to read the input for:
		 * https://www.hackerrank.com/contests/programming-interview-questions/challenges/m-th-to-last-element
		 * 
		 */
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();

			int m = Integer.parseInt(line);
			List<Integer> input = new ArrayList();

			StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
			while (tokenizer.hasMoreTokens()) {
				input.add(Integer.parseInt(tokenizer.nextToken()));
			}

			// these two are the inputs
			System.out.println("m = " + m);
			System.out.println("input = " + input.toString());
			
			// this is the output
			System.out.println("9");
			
			int outPut = findMToLastelement(input, m);
			System.out.println(outPut);

		} catch (Exception e) {

		}

	}
	
	
	public static int findMToLastelement(List<Integer> input, int m) {
		return 1;
	}

}
