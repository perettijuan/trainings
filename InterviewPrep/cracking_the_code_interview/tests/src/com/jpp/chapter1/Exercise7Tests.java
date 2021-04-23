package com.jpp.chapter1;

import junit.framework.Assert;

import org.junit.Test;

public class Exercise7Tests {

	
	@Test
	public void setAllToZero() {
		
		int[][] original = new int[][] {
				{1,2,3,4,5},
				{5,4,0,3,2},
				{6,6,4,2,1},
				{7,5,3,2,1},
				{1,2,3,4,5}
		};
		
		Exercise7.setAllToZeroWhenZero(original);

		int[][] expected = new int[][] {
				{1,2,0,4,5},
				{0,0,0,0,0},
				{6,6,0,2,1},
				{7,5,0,2,1},
				{1,2,0,4,5}
		};
		int col = 3;
		int row = 2;
		
		Assert.assertEquals(expected[col][0], original[col][0]);
		Assert.assertEquals(expected[col][1], original[col][1]);
		Assert.assertEquals(expected[col][2], original[col][2]);
		Assert.assertEquals(expected[col][3], original[col][3]);
		Assert.assertEquals(expected[col][4], original[col][4]);
		
		Assert.assertEquals(expected[0][row], original[0][row]);
		Assert.assertEquals(expected[1][row], original[1][row]);
		Assert.assertEquals(expected[2][row], original[2][row]);
		Assert.assertEquals(expected[3][row], original[3][row]);
		Assert.assertEquals(expected[4][row], original[4][row]);
		
		
	}
	
}
