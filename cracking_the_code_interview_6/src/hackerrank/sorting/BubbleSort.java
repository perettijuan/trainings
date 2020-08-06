package hackerrank.sorting;
/**
 * 
 * SOLVED
 * Time = 8 min
 *
 */
public class BubbleSort {

	static void countSwaps(int[] a) {
		int n = a.length;
		int temp = 0;
		int swaps = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				// Swap adjacent elements if they are in decreasing order
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j+1] = temp;
					swaps = swaps + 1;
				}
			}
		}
		
		System.out.println("Array is sorted in " + swaps + " swaps");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[n-1]);
	}
}
