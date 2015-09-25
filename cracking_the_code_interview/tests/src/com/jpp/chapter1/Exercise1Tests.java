package com.jpp.chapter1;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Exercise1Tests {

	@Test
	public void hasDplicatesWithDuplicated() {
		char[] string = new char[] { 'a', 'b', 'c', 'd', 'e', 'a', 'f' };
		boolean hasDuplicates = Exercise1.hasDuplicates(string);
		Assert.assertTrue(hasDuplicates);
	}

	@Test
	public void hasDplicatesWithoutDuplicated() {
		char[] string = new char[] { 'a', 'b', 'c', 'd', 'e', 'z', 'f' };
		boolean hasDuplicates = Exercise1.hasDuplicates(string);
		Assert.assertFalse(hasDuplicates);
	}

	@Test
	public void hasDplicatesWithDuplicatedAtEnd() {
		char[] string = new char[] { 'x', 'b', 'c', 'd', 'e', 'a', 'a' };
		boolean hasDuplicates = Exercise1.hasDuplicates(string);
		Assert.assertTrue(hasDuplicates);
	}

	@Test
	public void hasDplicatesWithOneChar() {
		char[] string = new char[] { 'x' };
		boolean hasDuplicates = Exercise1.hasDuplicates(string);
		Assert.assertFalse(hasDuplicates);
	}

	@Test
	public void hasDplicatesWithMoreThanOneDuplicated() {
		char[] string = new char[] { 'a', 'b', 'c', 'd', 'e', 'a', 'f', 'c' };
		boolean hasDuplicates = Exercise1.hasDuplicates(string);
		Assert.assertTrue(hasDuplicates);
	}

	@Test
	public void hasDplicatesWithNull() {
		boolean hasDuplicates = Exercise1.hasDuplicates(null);
		Assert.assertFalse(hasDuplicates);
	}

	@Test
	public void hasDplicatesWithZeroChar() {
		char[] string = new char[] {};
		boolean hasDuplicates = Exercise1.hasDuplicates(string);
		Assert.assertFalse(hasDuplicates);
	}

	@Test
	public void hasDplicatesWithNullString() {
		boolean hasDuplicates = Exercise1.hasDuplicatesString(null);
		Assert.assertFalse(hasDuplicates);
	}

	@Test
	public void hasDplicatesWithZeroCharString() {
		String string = "";
		boolean hasDuplicates = Exercise1.hasDuplicatesString(string);
		Assert.assertFalse(hasDuplicates);
	}

	@Test
	public void hasDplicatesWithDuplicatedString() {
		String string = "abcdeagf";
		boolean hasDuplicates = Exercise1.hasDuplicatesString(string);
		Assert.assertTrue(hasDuplicates);
	}
}
