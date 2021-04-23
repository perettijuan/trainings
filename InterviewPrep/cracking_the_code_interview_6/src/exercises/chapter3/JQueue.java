package exercises.chapter3;

/**
 * A Queue is a FIFO data structure: First In First Out.
 * 
 * Input = A -> C -> D -> F -> B 
 * Out = A -> C -> D -> F -> B
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class JQueue<T> {
	private static class QNode<T> {
		T data;
		QNode<T> next;

		QNode(T data) {
			this.data = data;
		}
	}

	private QNode<T> first = null;
	private QNode<T> last = null;

	public void add(T item) {
		QNode<T> toAdd = new QNode(item);
		if (first == null) {
			first = toAdd;
		}

		if (last == null) {
			last = toAdd;
		} else {
			last.next = toAdd;
			last = toAdd;
		}
	}

	public T remove() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}

		T toRemove = first.data;
		first = first.next;

		if (first == null) {
			last = null;
		}

		return toRemove;
	}

	public T peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		return first.data;
	}

	public boolean isEmpty() {
		return first == null;
	}

}
