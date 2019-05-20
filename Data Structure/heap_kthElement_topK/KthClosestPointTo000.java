package heap_kthElement_topK;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given three arrays sorted in ascending order. Pull one number from each array to form a coordinate <x,y,z> in a 3D 
 * space. Find the coordinates of the points that is k-th closest to <0,0,0>.
 * 
 * Assumptions:
 * 1. The three given arrays are not null or empty
 * 2. K >= 1 and K <= a.length * b.length * c.length
 * 
 * Examples:
 * A = {1, 3, 5}, B = {2, 4}, C = {3, 6}
 * 1. The closest is <1, 2, 3>, distance is sqrt(1 + 4 + 9)
 * 2. The 2nd closest is <3, 2, 3>, distance is sqrt(9 + 4 + 9)
 * 
 * Time: O(klogk)
 * Space: O(k)
 */
public class KthClosestPointTo000 {
	public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
		PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
			public int compare(List<Integer> p1, List<Integer> p2) {
				int d1 = distanceSq(a[p1.get(0)], b[p1.get(1)], c[p1.get(2)]);
				int d2 = distanceSq(a[p2.get(0)], b[p2.get(1)], c[p2.get(2)]);
				return ((Integer) d1).compareTo(d2);
			}

			private int distanceSq(int x, int y, int z) {
				return x * x + y * y + z * z;
			}
		});
		Set<List<Integer>> visited = new HashSet<>();
		List<Integer> cur = Arrays.asList(0, 0, 0); // indices of A, B, C
		minHeap.offer(cur);
		visited.add(cur);
		while (k > 1) {
			cur = minHeap.poll();
			List<Integer> next = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
			if (next.get(0) < a.length && visited.add(next)) {
				minHeap.offer(next);
			}
			next = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
			if (next.get(1) < b.length && visited.add(next)) {
				minHeap.offer(next);
			}
			next = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
			if (next.get(2) < c.length && visited.add(next)) {
				minHeap.offer(next);
			}
			k--;
		}
		cur = minHeap.peek();
		cur.set(0, a[cur.get(0)]); // replace the index with actual values in a, b, c
		cur.set(1, b[cur.get(1)]);
		cur.set(2, c[cur.get(2)]);
		return cur;
	}
}
