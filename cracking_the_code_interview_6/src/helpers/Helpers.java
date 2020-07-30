package helpers;

public class Helpers {
	
	public static boolean isSorted(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {		
				return false;
			}
		}
		return true;
	}
	
	
	static void printArray(int[] arr) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		for (int i = 0; i < arr.length; i++) {
			buffer.append(arr[i] + " ");
		}
		buffer.append("]");
		System.err.println(buffer.toString());
	}

}
