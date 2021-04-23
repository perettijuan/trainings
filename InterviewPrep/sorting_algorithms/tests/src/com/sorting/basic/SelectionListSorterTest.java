package com.sorting.basic;

import java.util.Comparator;

import com.sorting.core.AbstractListSorterTest;
import com.sorting.core.ListSorter;

public class SelectionListSorterTest extends AbstractListSorterTest {


    @Override
    protected ListSorter<String> createListSorter(Comparator<String> comparator) {
        return new SelectionListSorter<String>(comparator);
    }

}
