package slidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array A and a sliding window of size K, find the maximum value of each window as 
 * it slides from left to right.
 * 
 * Assumptions:
 * 1. The given array is not null and is not empty
 * 2. K >= 1, K <= A.length
 * 
 * Examples:
 * A = {1, 2, 3, 2, 4, 2, 1}, K = 3, the windows are 
 * {{1, 2, 3}, {2, 3, 2}, {3, 2, 4}, {2, 4, 2}, {4, 2, 1}}, and the maximum values of each K-sized 
 * sliding window are [3, 3, 4, 4, 4]
 * 
 * Thoughts: store the index (instead of the actual value) in a deque, and maintain actual values 
 * are monotonously increasing from the first to the last, so the last one is the maximum value.
 * 
 * Time: O(n)
 * Space: O(k)
 */
public class MaximumValuesOfSizeKSlidingWindows {
	public List<Integer> maxWindows(int[] array, int k) {
		List<Integer> res = new ArrayList<>();
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < array.length; i++) {
			while (!deque.isEmpty() && array[deque.peekFirst()] <= array[i]) { 
				deque.pollFirst(); // discard any index with smaller value than index i
			}
			deque.offerFirst(i);	
			if (!deque.isEmpty() && deque.peekLast() <= i - k) { 
				deque.pollLast(); // if the head element is out of the current sliding window, discard it as well
			}
			if (i >= k - 1) {
				res.add(array[deque.peekLast()]); // only after i >= k - 1, we begin to add maximum values to res
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		MaximumValuesOfSizeKSlidingWindows test = new MaximumValuesOfSizeKSlidingWindows();
		int[] array = {1,2,3,2,4,2,1};
		int k = 3;
		System.out.println(test.maxWindows(array, k));
	}
}
