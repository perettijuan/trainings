package exercises.chapter3;

/**
 * 
 * Sort Stack: Write a program to sort a stack such that the smallest items are
 * on the top. You can use an additional temporary stack, but you may not copy
 * the elements into any other data structure (such as an array). The stack
 * supports the following operations: push, pop, peek, and isEmpty.
 * 
 * Question: do I have to use the same Stack (input) => NO (I can do return new
 * JStack)
 * 
 * Example: 
 * INPUT = 3 -> 4 -> 1 -> 5 -> 2 -> 6 -> 7 -> 9 -> 8 -> 10 
 * OUTPUT = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
 * 
 */
public class StackExercise5 {

	public static <T extends Comparable<T>> JStack<T> sortStack(JStack<T> input) { 																				
		JStack<T> sorted = new JStack<T>();
		while (!input.isEmpty()) {
			T value = input.pop();

			if (sorted.isEmpty()) {
				sorted.push(value);
			} else {
				insertSorted(value, sorted);
			}
		}
		return sorted;
	}

	private static <T extends Comparable<T>> void insertSorted(T value, JStack<T> sorted) {
		JStack<T> helper = new JStack<T>();
		while (value.compareTo(sorted.peek()) > 0) {
			helper.push(sorted.pop());

			if (sorted.isEmpty()) {
				break; // finish the loop
			}
		}

		sorted.push(value);

		// dump helper
		while (!helper.isEmpty()) {
			sorted.push(helper.pop());
		}
	}

}
