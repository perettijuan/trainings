package com.sorting.advanced;

import java.util.Comparator;

import com.sorting.core.AbstractListSorterTest;
import com.sorting.core.ListSorter;

public class QuickSortListSorterTest extends AbstractListSorterTest {

	@Override
	protected ListSorter<String> createListSorter(Comparator<String> comparator) {
		return new QuicksortListSorter<String>(comparator);
	}

}
