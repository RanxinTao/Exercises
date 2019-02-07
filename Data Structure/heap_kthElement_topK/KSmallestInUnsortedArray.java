package heap_kthElement_topK;

import java.util.Collections;
import java.util.PriorityQueue;
import impl.Utils;

/**
 * Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.
 * 
 * Assumptions:
 * 1. A is not null
 * 2. K >= 0 and <= A.length
 * Examples:
 * A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
 */
public class KSmallestInUnsortedArray {
	public int[] kSmallest(int[] array, int k) {
		if (array.length == 0 || k == 0) {
			return new int[0];
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < array.length; i++) {
			if (i < k) {
				maxHeap.offer(array[i]);
			} else if (array[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.offer(array[i]);
			}
		}
		int[] res = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			res[i] = maxHeap.poll();
		}
		return res;
	}
	
	public static void main(String[] args) {
		KSmallestInUnsortedArray test = new KSmallestInUnsortedArray();
		int[] array = {3,4,1,2,5};
		int k = 3;
		Utils.printArray(test.kSmallest(array, k));
	}
}
