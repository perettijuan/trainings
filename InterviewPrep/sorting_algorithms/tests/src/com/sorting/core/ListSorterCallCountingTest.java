package com.sorting.core;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sorting.basic.BubbleListSorter;
import com.sorting.basic.InsertionListSorter;
import com.sorting.basic.SelectionListSorter;

public class ListSorterCallCountingTest {


    private static final int SIZE = 1000;

    private final List<Integer> mSortedArray = new ArrayList<Integer>(SIZE);
    private final List<Integer> mReverseArray = new ArrayList<Integer>(SIZE);
    private final List<Integer> mRandomArray = new ArrayList<Integer>(SIZE);

    private CallCountingComparator<Integer> mComparator;

    @Before
    public void setUp() {
        mComparator = new CallCountingComparator<Integer>(new NaturalComparator<Integer>());

        for (int i = 1; i < SIZE; i++) {
            mSortedArray.add(new Integer(i));
        }

        for (int i = SIZE; i > 0; i--) {
            mReverseArray.add(new Integer(i));
        }

        for (int i = 0; i < SIZE; i++) {
            mRandomArray.add(new Integer((int) (SIZE * Math.random())));
        }
    }

    @Test
    public void testWorstCaseBubbleSort() {
        new BubbleListSorter<Integer>(mComparator).sort(mReverseArray);
        reportCalls("testWorstCaseBubbleSort", mComparator.getCallCount());
    }

    @Test
    public void testWorstCaseSelectioneSort() {
        new SelectionListSorter<Integer>(mComparator).sort(mReverseArray);
        reportCalls("testWorstCaseSelectionSort", mComparator.getCallCount());
    }

    @Test
    public void testWorstCaseInsertionSort() {
        new InsertionListSorter<Integer>(mComparator).sort(mReverseArray);
        reportCalls("testWorstCaseInsertionSort", mComparator.getCallCount());
    }

    @Test
    public void testBestCaseBubbleSort() {
        new BubbleListSorter<Integer>(mComparator).sort(mSortedArray);
        reportCalls("testBestCaseBubbleSort", mComparator.getCallCount());
    }

    @Test
    public void testBestCaseSelectioneSort() {
        new SelectionListSorter<Integer>(mComparator).sort(mSortedArray);
        reportCalls("testBestCaseSelectionSort", mComparator.getCallCount());
    }

    @Test
    public void testBestCaseInsertionSort() {
        new InsertionListSorter<Integer>(mComparator).sort(mSortedArray);
        reportCalls("testBestCaseInsertionSort", mComparator.getCallCount());
    }

    @Test
    public void testAverageCaseBubbleSort() {
        new BubbleListSorter<Integer>(mComparator).sort(mRandomArray);
        reportCalls("testAverageCaseBubbleSort", mComparator.getCallCount());
    }

    @Test
    public void testAverageCaseSelectioneSort() {
        new SelectionListSorter<Integer>(mComparator).sort(mRandomArray);
        reportCalls("testAverageCaseSelectionSort", mComparator.getCallCount());
    }

    @Test
    public void testAverageCaseInsertionSort() {
        new InsertionListSorter<Integer>(mComparator).sort(mRandomArray);
        reportCalls("testAverageCaseInsertionSort", mComparator.getCallCount());
    }

    private void reportCalls(String name, int callCount) {
        System.out.println(name + ": " + callCount + " calls");
    }
}
