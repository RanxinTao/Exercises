package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a non-negative integer array representing the heights of a list of adjacent bars. 
 * Suppose each bar has a width of 1. Find the largest rectangular area that can be formed in the histogram.
 * 
 * Assumptions:
 * The given array is not null or empty
 * 
 * Examples:
 * { 2, 1, 3, 3, 4 }, the largest rectangle area is 3 * 3 = 9 (starting from index 2 and ending at index 4)
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class LargestRectangleInHistogram {
	public int largest(int[] array) {
		int res = 0;
		Deque<Integer> stack = new LinkedList<>(); // stack of histogram indices
		for (int i = 0; i <= array.length; i++) {
			int curHeight = i == array.length ? 0 : array[i]; // explicitly add a bar of height 0 at last, to pop out all the elements in the stack
			while (!stack.isEmpty() && array[stack.peekFirst()] >= curHeight) {
				int height = array[stack.pollFirst()]; // if the previous bar is higher than the current bar, we pop it out
				int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1; // determine the left boundary
				res = Math.max(res, height * (i - left)); // the right boundary is i
			}
			stack.offerFirst(i);
		}
		return res;
	}

	public static void main(String[] args) {
		LargestRectangleInHistogram test = new LargestRectangleInHistogram();
		System.out.println(test.largest(new int[] { 1, 5, 6, 6, 2, 3, 5, 6, 3, 4, 4, 2 }));
	}
}
