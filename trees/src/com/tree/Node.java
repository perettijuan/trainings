package com.tree;

/**
 * Class to hold a node representation for a binary tree.
 * 
 * @author Juan P. Peretti (peretti.juan@gmail.com)
 * 
 * @param <T>
 *            - the type of data to be hold by the tree.
 */
public class Node<T extends Comparable<T>> {

	private Node<T> mLeft;
	private Node<T> mRight;
	private T mValue;

	/**
	 * Class constructor.
	 * 
	 * @param value
	 *            - the value to be hold by the Node.
	 */
	public Node(T value) {
		assert value != null : "Value to be hold by the Node can not be null";
		mValue = value;
	}

	/**
	 * Class constructor.
	 * 
	 * @param value
	 *            - the value to be hold by the Node.
	 * @param left
	 *            - the left child of the node.
	 * @param right
	 *            - the right child of the node.
	 */
	public Node(T value, Node<T> left, Node<T> right) {
		this(value);
		mLeft = left;
		mRight = right;
	}

	public Node<T> getLeft() {
		return mLeft;
	}

	public void setLeft(Node<T> mLeft) {
		this.mLeft = mLeft;
	}

	public Node<T> getRight() {
		return mRight;
	}

	public void setRight(Node<T> mRight) {
		this.mRight = mRight;
	}

	public T getValue() {
		return mValue;
	}

	public String toString() {
		return mValue.toString();
	}

}
