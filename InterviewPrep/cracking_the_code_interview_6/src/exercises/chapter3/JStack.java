package exercises.chapter3;

/**
 * A stack implemented with a linked list.
 * 
 * A stack is a LIFO list = Last In -> First Out.
 * 
 * Input = A -> C -> D -> F -> B 
 * Out = B -> F -> D -> C -> A
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class JStack<T> {

	private static class SNode<T> {
		private T value;
		private SNode<T> next = null;

		SNode(T value) {
			this.value = value;
		}
	}

	private SNode<T> top;

	public T pop() {
		if (top == null) {
			throw new IllegalStateException("The stack is empty");
		}
		T value = top.value;
		top = top.next;
		return value;
	}

	public void push(T item) {
		SNode<T> newTop = new SNode(item);
		newTop.next = top;
		top = newTop;
	}

	public T peek() {
		if (top == null) {
			throw new IllegalStateException("The stack is empty");
		}
		return top.value;
	}

	public boolean isEmpty() {
		return top == null;
	}

}
