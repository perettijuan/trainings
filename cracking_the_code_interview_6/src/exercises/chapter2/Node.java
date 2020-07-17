package exercises.chapter2;

public class Node<T extends Comparable<T>> {
	private Node<T> next;
	private T value;

	public Node(T value) {
		if (value == null) {
			throw new NullPointerException("The provided value can not be null");
		}
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	// nullable
	public Node<T> getNext() {
		return next;
	}

	// newNext can be nullable
	public void setNext(Node<T> newNext) {
		next = newNext;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Node) {
			return getValue() == ((Node<T>) obj).value;
			
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	
}