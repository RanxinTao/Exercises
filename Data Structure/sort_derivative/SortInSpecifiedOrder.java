package sort_derivative;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given two integer arrays A1 and A2, sort A1 in such a way that the relative order among the elements will be same as 
 * those are in A2. For the elements that are not in A2, append them in the right end of the A1 in an ascending order.
 * 
 * Assumptions:
 * 1. A1 and A2 are both not null.
 * 2. There are no duplicate elements in A2.
 * Examples:
 * A1 = {2, 1, 2, 5, 7, 1, 9, 3}, A2 = {2, 1, 3}, A1 is sorted to {2, 2, 1, 1, 3, 5, 7, 9}
 */
public class SortInSpecifiedOrder {
	public int[] sortSpecial(int[] A1, int[] A2) {
		// count the occurrence of each A2 element in A1
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int num : A2) {
			countMap.put(num, 0);
		}
		// sort the elements that are not in A2
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		// traverse A1, for elements that are in A2, record its count; for those not in A2, offer into heap
		for (int i = 0; i < A1.length; i++) {
			Integer count = countMap.get(A1[i]);
			if (count != null) {
				countMap.put(A1[i], count + 1);
			} else {
				minHeap.offer(A1[i]);
			}
		}
		// rearrange (sort) A2
		int end = 0;
		for (int num : A2) {
			int count = countMap.get(num);
			for (int i = 0; i < count; i++) {
				A1[end] = num;
				end++;
			}
		}
		while (!minHeap.isEmpty()) {
			A1[end] = minHeap.poll();
			end++;
		}
		return A1;
	}
}
