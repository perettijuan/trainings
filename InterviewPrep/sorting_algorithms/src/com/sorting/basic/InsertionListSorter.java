package com.sorting.basic;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sorting.core.ListSorter;

public class InsertionListSorter<E> implements ListSorter<E> {


    private Comparator<E> mComparator;

    public InsertionListSorter(Comparator<E> comp) {
        mComparator = comp;
    }

    @Override
    public List<E> sort(List<E> list) {
        assert list != null : "list can not be null";

        final List<E> sortedList = new LinkedList<E>();

        Iterator<E> it = list.iterator();

        while (it.hasNext()) {
            E current = it.next();
            int slot = sortedList.size();
            while (slot > 0) {
                if (mComparator.compare(current, sortedList.get(slot - 1)) >= 0) {
                    break;
                }
                --slot;
            }
            sortedList.add(slot, current);
        }

        return sortedList;
    }

}
