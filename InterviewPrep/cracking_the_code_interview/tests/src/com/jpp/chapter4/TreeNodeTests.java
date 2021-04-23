package com.jpp.chapter4;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

public class TreeNodeTests {

	@Test
	public void insert() {
		int[] data = { 6, 4, 1, 7, 9, 2, 5 };
		TreeNode<Integer> root = new TreeNode<Integer>(data[0]);
		for (int i = 1; i < data.length; i++) {
			root.insert(data[i]);
		}

		Assert.assertTrue(6 == root.data());
		Assert.assertTrue(4 == root.left().data());
		Assert.assertTrue(1 == root.left().left().data());
		Assert.assertTrue(2 == root.left().left().right().data());
		Assert.assertTrue(7 == root.right().data());
		Assert.assertTrue(9 == root.right().right().data());
		Assert.assertTrue(5 == root.left().right().data());
	}

	
	@Test
	public void lookUp() {
		int[] data = { 6, 4, 1, 7, 9, 2, 5 };
		TreeNode<Integer> root = new TreeNode<Integer>(data[0]);
		for (int i = 1; i < data.length; i++) {
			root.insert(data[i]);
		}

		Assert.assertTrue(6 == root.data());
		Assert.assertTrue(4 == root.left().data());
		Assert.assertTrue(1 == root.left().left().data());
		Assert.assertTrue(2 == root.left().left().right().data());
		Assert.assertTrue(7 == root.right().data());
		Assert.assertTrue(9 == root.right().right().data());
		Assert.assertTrue(5 == root.left().right().data());
		
		TreeNode<Integer> found = root.lookUp(7);
		Assert.assertTrue(7 == found.data());
		Assert.assertTrue(9 == found.right().data());
		Assert.assertNull(found.left());
	}
	
	
	@Test
	public void preOrder() {
		int[] data = { 6, 4, 1, 7, 9, 2, 5 };
		TreeNode<Integer> root = new TreeNode<Integer>(data[0]);
		for (int i = 1; i < data.length; i++) {
			root.insert(data[i]);
		}
		
		ArrayList<Integer> ordered = new ArrayList<Integer>();
		root.preOrder(ordered);

		Assert.assertTrue(6 == ordered.get(0));
		Assert.assertTrue(4 == ordered.get(1));
		Assert.assertTrue(1 == ordered.get(2));
		Assert.assertTrue(2 == ordered.get(3));
		Assert.assertTrue(5 == ordered.get(4));
		Assert.assertTrue(7 == ordered.get(5));
		Assert.assertTrue(9 == ordered.get(6));
	}
	
	
	@Test
	public void inOrder() {
		int[] data = { 6, 4, 1, 7, 9, 2, 5 };
		TreeNode<Integer> root = new TreeNode<Integer>(data[0]);
		for (int i = 1; i < data.length; i++) {
			root.insert(data[i]);
		}
		
		ArrayList<Integer> ordered = new ArrayList<Integer>();
		root.inOrder(ordered);

		Assert.assertTrue(4 == ordered.get(0));
		Assert.assertTrue(1 == ordered.get(1));
		Assert.assertTrue(2 == ordered.get(2));
		Assert.assertTrue(5 == ordered.get(3));
		Assert.assertTrue(6 == ordered.get(4));
		Assert.assertTrue(7 == ordered.get(5));
		Assert.assertTrue(9 == ordered.get(6));
	}
	
	
	@Test
	public void postOrder() {
		int[] data = { 6, 4, 1, 7, 9, 2, 5 };
		TreeNode<Integer> root = new TreeNode<Integer>(data[0]);
		for (int i = 1; i < data.length; i++) {
			root.insert(data[i]);
		}
		
		ArrayList<Integer> ordered = new ArrayList<Integer>();
		root.postOrder(ordered);

		Assert.assertTrue(4 == ordered.get(0));
		Assert.assertTrue(1 == ordered.get(1));
		Assert.assertTrue(2 == ordered.get(2));
		Assert.assertTrue(5 == ordered.get(3));
		Assert.assertTrue(7 == ordered.get(4));
		Assert.assertTrue(9 == ordered.get(5));
		Assert.assertTrue(6 == ordered.get(6));
	}
}
