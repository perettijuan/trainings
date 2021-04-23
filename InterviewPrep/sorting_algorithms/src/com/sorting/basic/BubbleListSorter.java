package com.sorting.basic;

import java.util.Comparator;
import java.util.List;

import com.sorting.core.ListSorter;

public class BubbleListSorter<E> implements ListSorter<E> {


    private Comparator<E> mComparator;

    public BubbleListSorter(Comparator<E> comparator) {
        assert comparator != null : "Comparator can not be null";
        mComparator = comparator;
    }

    @Override
    public List<E> sort(List<E> list) {

        assert list != null : "list can not be null";

        int size = list.size();

        for (int pass = 1; pass < size; pass++) {
            for (int left = 0; left < (size - pass); left++) {
                int right = left + 1;
                if (mComparator.compare(list.get(left), list.get(right)) > 0) {
                    swap(list, left, right);
                }
            }
        }

        return list;
    }

    private void swap(List<E> list, int left, int right) {
        E temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }

}
