package com.interviewcake;

/**
 * https://www.interviewcake.com/question/product-of-other-numbers
 */
public class ProductOfIntegers {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 7, 3, 4 };
		int[] products = getProductsOfAllIntsExceptAtIndex(array);
		for (int i = 0; i < products.length; i++) {
			System.out.println("product[" + i + "] = " + products[i]);
		}
	}

	private static int[] getProductsOfAllIntsExceptAtIndex(int[] original) {
		int products[] = new int[original.length];

		for (int i = 0; i < original.length; i++) {
			int product = 1;
			for (int j = 0; j < original.length; j++) {
				if (j != i) {
					product = product * original[j];
				}
			}
			products[i] = product;
		}

		return products;
	}

}
