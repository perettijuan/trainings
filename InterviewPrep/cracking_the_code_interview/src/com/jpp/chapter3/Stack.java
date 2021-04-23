package com.jpp.chapter3;

import com.jpp.chapter2.Node;

public class Stack<T extends Comparable<T>> {

	private Node<T> mRoot;

	public void push(T data) {
		if (mRoot == null) {
			mRoot = new Node<T>(data);
		} else {
			Node<T> currentRoot = mRoot;
			mRoot = new Node<T>(data);
			mRoot.setNext(currentRoot);
		}
	}
	
	
	public T pop() {
		if(mRoot == null) {
			return null;
		}
		T data = mRoot.getData();
		mRoot = mRoot.next();
		return data;
	}

}
