package exercises.chapter3;

/**
 * 
 * Stack Min: How would you design a stack which, in addition to push and pop,
 * has a function min which returns the minimum element? Push, pop and min
 * should all operate in O(1) time.
 * 
 * Approach: always keep the min as a variable inside the class.
 * 
 */
public class StackExercise2 {

	public static class JStackMin<T extends Comparable<T>> extends JStack<T> {

		private T minValue = null;

		@Override
		public void push(T item) {
			if (minValue == null) {
				minValue = item;
			} else if (minValue.compareTo(item) > 0) {
				minValue = item;
			}
			super.push(item);
		}

		public T min() {
			return minValue;
		}
	}

}
