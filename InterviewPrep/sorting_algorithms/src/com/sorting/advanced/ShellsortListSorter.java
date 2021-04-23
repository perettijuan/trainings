package com.sorting.advanced;

import java.util.Comparator;
import java.util.List;

import com.sorting.core.ListSorter;

public class ShellsortListSorter<E> implements ListSorter<E> {


    private static final int[] INCREMENTS = { 121, 40, 13, 4, 1 };

    private Comparator<E> mComparator;

    public ShellsortListSorter(Comparator<E> comparator) {
        assert comparator != null : "Comparatot can not be null";
        mComparator = comparator;
    }

    @Override
    public List<E> sort(List<E> unsortedList) {
        assert unsortedList != null : "the list can not be null";

        for (int i = 0; i < INCREMENTS.length; i++) {
            int increment = INCREMENTS[i];
            hSort(unsortedList, increment);
        }

        return unsortedList;
    }

    private void hSort(List<E> list, int increment) {
        if (list.size() < (increment * 2)) {
            return;
        }

        for (int i = 0; i < increment; i++) {
            sortSubList(list, i, increment);
        }
    }

    private void sortSubList(List<E> list, int startIndex, int increment) {
        for (int i = startIndex + increment; i < list.size(); i += increment) {
            E value = list.get(i);
            int j;
            for (j = i; j > startIndex; j -= increment) {
                E previousValue = list.get(j - increment);
                if (mComparator.compare(value, previousValue) >= 0) {
                    break;
                }
                list.set(j, previousValue);
            }
            list.set(j, value);
        }
    }

}
