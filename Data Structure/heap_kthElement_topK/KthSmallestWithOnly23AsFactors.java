package heap_kthElement_topK;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Find the Kth smallest number s such that s = 2 ^ x * 3 ^ y, x >= 0 and y >= 0, x and y are all integers.
 * 
 * Assumptions:
 * K >= 1
 * 
 * Examples:
 * the smallest is 1, the 2nd smallest is 2, the 3rd smallest is 3, the 5th smallest is 2 * 3 = 6, 
 * the 6th smallest is 2 ^ 3 * 3 ^ 0 = 8
 */
public class KthSmallestWithOnly23AsFactors {
	public int kth(int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		Set<Integer> visited = new HashSet<>();
		minHeap.offer(1 * 1);
		visited.add(1 * 1);
		while (k > 1) {
			int cur = minHeap.poll();
			int next = 2 * cur;
			if (visited.add(next)) {
				minHeap.offer(next);
			}
			next = 3 * cur;
			if (visited.add(next)) {
				minHeap.offer(next);
			}
			k--;
		}
		return minHeap.peek();
	}
}
