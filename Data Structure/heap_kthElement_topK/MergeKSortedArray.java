package heap_kthElement_topK;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge K sorted array into one big sorted array in ascending order.
 * Assumptions:
 * The input arrayOfArrays is not null, none of the arrays is null either.
 * Algorithm: move the smaller one
 */
public class MergeKSortedArray {
	public int[] merge(int[][] arrayOfArrays) {
		PriorityQueue<Entry> minHeap = new PriorityQueue<>(new Comparator<Entry>() {
			@Override
			public int compare(Entry e1, Entry e2) {
				return ((Integer) e1.value).compareTo(e2.value);
			}
		});
		int len = 0;
		// initiate minHeap
		for (int i = 0; i < arrayOfArrays.length; i++) {
			int[] array = arrayOfArrays[i];
			len += array.length;
			if (array.length > 0) {
				minHeap.offer(new Entry(array, 0));
			}
		}
		int[] res = new int[len];
		int index = 0;
		while (!minHeap.isEmpty()) {
			Entry entry = minHeap.poll();
			res[index] = entry.value;
			index++;
			if (entry.index + 1 < entry.array.length) {
				entry.index++;
				entry.value = entry.array[entry.index];
				minHeap.offer(entry);
			}
		}
		return res;
	}

	static class Entry {
		int[] array;
		int index;
		int value;

		Entry(int[] array, int index) {
			this.array = array;
			this.index = index;
			value = array[index];
		}
	}
}
