package heap_kthElement_topK;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge K sorted array into one big sorted array in ascending order.
 * 
 * Assumptions:
 * The input arrayOfArrays is not null, none of the arrays is null either.
 * 
 * Algorithm: move the smaller one
 * Time: O(knlogk), where n is the average length of arrays
 * Space: O(k)
 */
public class MergeKSortedArray {
	public int[] merge(int[][] arrayOfArrays) {
		PriorityQueue<Entry> minHeap = new PriorityQueue<>(new Comparator<Entry>() {
			public int compare(Entry e1, Entry e2) {
				return ((Integer) e1.value).compareTo(e2.value);
			}
		});
		int totalLen = 0;
		for (int[] curArr : arrayOfArrays) { // initiate minHeap
			totalLen += curArr.length;
			if (curArr.length > 0) {
				minHeap.offer(new Entry(curArr, 0));
			}
		}
		int[] res = new int[totalLen];
		int resIdx = 0;
		while (!minHeap.isEmpty()) {
			Entry entry = minHeap.poll();
			res[resIdx] = entry.value;
			resIdx++;
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
