package heap_kthElement_topK;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integers.
 * 
 * Assumptions:
 * K >= 1
 * Examples:
 * the smallest is 3 * 5 * 7 = 105, the 2nd smallest is 3 ^ 2 * 5 * 7 = 315, the 3rd smallest is 3 * 5 ^ 2 * 7 = 525,
 * the 5th smallest is 3 ^ 3 * 5 * 7 = 945
 */
public class KthSmallestWithOnly357AsFactors {
	public long kth(int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		Set<Integer> visited = new HashSet<>();
		minHeap.offer(3 * 5 * 7);
		visited.add(3 * 5 * 7);
		while (k > 1) {
			int cur = minHeap.poll();
			int next = 3 * cur;
			if (visited.add(next)) {
				minHeap.offer(next);
			}
			next = 5 * cur;
			if (visited.add(next)) {
				minHeap.offer(next);
			}
			next = 7 * cur;
			if (visited.add(next)) {
				minHeap.offer(next);
			}
			k--;
		}
		return minHeap.peek();
	}
}	
