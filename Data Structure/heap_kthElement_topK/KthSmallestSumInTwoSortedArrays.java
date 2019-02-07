package heap_kthElement_topK;

import java.util.PriorityQueue;

/**
 * Given two sorted arrays A and B, of sizes m and n respectively. Define s = a + b, 
 * where a is one element from A and b is one element from B. Find the Kth smallest s out of all possible s'.
 * 
 * Assumptions:
 * A is not null and A is not of zero length, so as B
 * K > 0 and K <= m * n
 * 
 * Examples:
 * A = {1, 3, 5}, B = {4, 8}
 * 1st smallest s is 1 + 4 = 5, 2nd smallest s is 3 + 4 = 7, 3rd, 4th smallest s are 9 (1 + 8, 4 + 5), 
 * 5th smallest s is 3 + 8 = 11
 */
public class KthSmallestSumInTwoSortedArrays {
	public int kthSum(int[] A, int[] B, int k) {
		PriorityQueue<Entry> minHeap = new PriorityQueue<>(); // maintain size k
		boolean[][] visited = new boolean[A.length][B.length];
		minHeap.offer(new Entry(0, 0, A[0] + B[0]));
		visited[0][0] = true;
		while (k > 1) {
			Entry cur = minHeap.poll();
			if (cur.ai + 1 < A.length && !visited[cur.ai + 1][cur.bi]) {
				Entry next = new Entry(cur.ai + 1, cur.bi, A[cur.ai + 1] + B[cur.bi]);
				minHeap.offer(next);
				visited[cur.ai + 1][cur.bi] = true;
			}
			if (cur.bi +1 < B.length && !visited[cur.ai][cur.bi + 1]) {
				Entry next = new Entry(cur.ai, cur.bi + 1, A[cur.ai] + B[cur.bi + 1]);
				minHeap.offer(next);
				visited[cur.ai][cur.bi + 1] = true;
			}
			k--;
		}
		return minHeap.peek().val;
	}

	static class Entry implements Comparable<Entry> {
		int ai;
		int bi;
		int val;

		public Entry(int ai, int bi, int val) {
			this.ai = ai;
			this.bi = bi;
			this.val = val;
		}

		@Override
		public int compareTo(Entry another) {
			return ((Integer) this.val).compareTo(another.val);
		}
	}
	
	public static void main(String[] args) {
		KthSmallestSumInTwoSortedArrays test = new KthSmallestSumInTwoSortedArrays();
		int[] A = new int[] {1,3,5};
		int[] B = new int[] {4,8};
		System.out.println(test.kthSum(A, B, 5));
	}
}
