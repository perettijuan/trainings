package com.sorting.advanced;

import java.util.Comparator;
import java.util.List;

import com.sorting.core.ListSorter;

public class QuicksortListSorter<E> implements ListSorter<E> {

	private Comparator<E> mComparator;

	public QuicksortListSorter(Comparator<E> comparator) {
		assert comparator != null : "Comparatot can not be null";
		mComparator = comparator;
	}

	@Override
	public List<E> sort(List<E> unsortedList) {
		assert unsortedList != null : "the list can not be null";
		quickSort(unsortedList, 0, unsortedList.size() - 1);
		return unsortedList;
	}

	private void quickSort(List<E> list, int startIndex, int partitionItem) {

		if (startIndex < 0 || partitionItem > list.size()) {
			return;
		}

		if (partitionItem <= startIndex) {
			return;
		}

		E value = list.get(partitionItem);
		int partition = partition(list, value, startIndex, partitionItem - 1);
		if (mComparator.compare(list.get(partition), value) < 0) {
			++partition;
		}

		swap(list, partition, partitionItem);

		quickSort(list, startIndex, partitionItem - 1);
		quickSort(list, partition + 1, partitionItem);
	}

	private int partition(List<E> list, E value, int leftIndex, int rightIndex) {
		int left = leftIndex;
		int right = rightIndex;

		while (left < right) {
			if (mComparator.compare(list.get(left), value) < 0) {
				++left;
				continue;
			}

			if (mComparator.compare(list.get(right), value) >= 0) {
				--right;
				continue;
			}

			swap(list, left, right);
			++left;
		}

		return left;
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
