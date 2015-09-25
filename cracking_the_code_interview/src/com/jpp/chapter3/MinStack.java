package com.jpp.chapter3;

import com.jpp.chapter2.Node;

public class MinStack<T extends Comparable<T>> {

	/*
	 * How would you design a stack which, in addition to push and pop, also has
	 * a function min which returns the minimum element? Push, pop and min
	 * should all operate in O(1) time.
	 */

	private Node<T> mRoot;
	private T mMin;

	public void push(T data) {
		if (mRoot == null) {
			mRoot = new Node<T>(data);
		} else {
			Node<T> currentRoot = mRoot;
			mRoot = new Node<T>(data);
			mRoot.setNext(currentRoot);
		}

		if (mMin == null) {
			mMin = data;
		} else if (mMin.compareTo(data) > 0) {
			mMin = data;
		}
	}

	public T min() {
		return mMin;
	}

	public T pop() {
		if (mRoot == null) {
			return null;
		}
		T data = mRoot.getData();
		mRoot = mRoot.next();

		return data;
	}

}
