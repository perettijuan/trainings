package com.sorting.core;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractListSorterTest {


    private List<String> mUnsortedList;
    private List<String> mSortedList;

    @Before
    public void setUp() {

        mUnsortedList = new LinkedList<String>();

        mUnsortedList.add("test");
        mUnsortedList.add("driven");
        mUnsortedList.add("development");
        mUnsortedList.add("is");
        mUnsortedList.add("one");
        mUnsortedList.add("small");
        mUnsortedList.add("step");
        mUnsortedList.add("for");
        mUnsortedList.add("a");
        mUnsortedList.add("programmer");
        mUnsortedList.add("but");
        mUnsortedList.add("it's");
        mUnsortedList.add("one");
        mUnsortedList.add("giant");
        mUnsortedList.add("leap");
        mUnsortedList.add("for");
        mUnsortedList.add("programming");

        mSortedList = new LinkedList<String>();

        mSortedList.add("a");
        mSortedList.add("but");
        mSortedList.add("development");
        mSortedList.add("driven");
        mSortedList.add("for");
        mSortedList.add("for");
        mSortedList.add("giant");
        mSortedList.add("is");
        mSortedList.add("it's");
        mSortedList.add("leap");
        mSortedList.add("one");
        mSortedList.add("one");
        mSortedList.add("programmer");
        mSortedList.add("programming");
        mSortedList.add("small");
        mSortedList.add("step");
        mSortedList.add("test");
    }

    @After
    public void tearDown() {
        mSortedList = null;
        mUnsortedList = null;
    }

    protected abstract ListSorter<String> createListSorter(Comparator<String> comparator);

    @Test
    public void listSorterCanSortSampleList() {
        ListSorter<String> sorter = createListSorter(new NaturalComparator<String>());
        List<String> result = sorter.sort(mUnsortedList);

        assertEquals(result.size(), mSortedList.size());

        Iterator<String> actual = result.iterator();
        Iterator<String> expected = mSortedList.iterator();

        while (expected.hasNext()) {
            assertEquals(expected.next(), actual.next());
        }
    }

}
