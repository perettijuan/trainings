package com.jpp.chapter2;

public class Node<T extends Comparable<T>> {

	private T mData;
	private Node<T> mNext;

	public Node(T data) {
		mData = data;
	}

	public Node<T> addToTail(T data) {
		Node<T> tail = new Node<T>(data);
		Node<T> n = this;
		while (n.mNext != null) {
			n = n.mNext;
		}
		n.mNext = tail;
		return tail;
	}

	public T getData() {
		return mData;
	}

	public Node<T> next() {
		return mNext;
	}

	public void setNext(Node<T> next) {
		mNext = next;
	}

	public void setData(T data) {
		mData = data;
	}

	@Override
	public boolean equals(Object another) {
		boolean equals = false;
		if (another instanceof Node) {
			equals = mData.equals(((Node) another).mData);
		}
		return equals;
	}

	public Node<T> deleteNode(Node<T> root, T data) {
		if (root == null) {
			return null;
		}

		if (root.mData == null) {
			return null;
		}

		// Just delete this one
		if (root.mData.compareTo(data) == 0) {
			return root.mNext;
		}

		while (root.mNext != null) {

			if (root.mNext.mData.equals(data)) {
				root.mNext = root.mNext.mNext;
				return root;
			}

			root = root.mNext;
		}

		return null;
	}

}
