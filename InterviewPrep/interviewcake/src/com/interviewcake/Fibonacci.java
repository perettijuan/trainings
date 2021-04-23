package com.interviewcake;

/**
 * Find nth Fibonacci Number in the Fibonacci sequence?
 */
public class Fibonacci {

	public static void main(String[] args) {
		int n = 5;
		int fibo = fibonacciRecursive(n);
		System.out.println("Fibonacci Recursive(" + n + ") = " + fibo);

		fibo = fibonacciIterative(n);
		System.out.println("Fibonacci Iterative(" + n + ") = " + fibo);
	}

	private static int fibonacciRecursive(int n) {
		if (n < 1) {
			return 1;
		}

		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	private static int fibonacciIterative(int n) {
		int fibo = 0;

		while (n != 0) {
			fibo += (n - 1);
			n--;
		}

		return fibo;
	}
}
