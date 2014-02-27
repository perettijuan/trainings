package com.sorting.basic;

import java.util.Comparator;
import java.util.List;

import com.sorting.core.ListSorter;

public class SelectionListSorter<E> implements ListSorter<E> {


    private Comparator<E> mComparator;

    public SelectionListSorter(Comparator<E> comp) {
        assert comp != null : "Comparatot can not be null";
        mComparator = comp;
    }

    @Override
    public List<E> sort(List<E> unsortedList) {

        int size = unsortedList.size();

        for (int slot = 0; slot < size - 1; slot++) {
            int smallest = slot;
            for (int check = slot + 1; check < size; check++) {
                if (mComparator.compare(unsortedList.get(check), unsortedList.get(smallest)) < 0) {
                    smallest = check;
                }
            }
            swap(unsortedList, smallest, slot);
        }

        return unsortedList;
    }

    private void swap(List<E> list, int left, int right) {
        if (left == right) {
            return;
        }
        E temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);

    }
}
