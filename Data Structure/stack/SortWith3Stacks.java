package stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given one stack with integers, sort it with two additional stacks (total 3 stacks).
 * After sorting the original stack should contain the sorted integers and from
 * top to bottom the integers are sorted in ascending order.
 * 
 * Assumptions:
 * The given stack is not null
 * Requirements:
 * No additional memory, time complexity = O(nlogn)
 * 
 * Time: O(nlogn), Space: O(1)
 */
public class SortWith3Stacks {
	public void sort(Deque<Integer> stack) {
		Deque<Integer> buffer1 = new LinkedList<>();
		Deque<Integer> buffer2 = new LinkedList<>();
		sort(stack, buffer1, buffer2, stack.size());
	}
	
	private void sort(Deque<Integer> s1, Deque<Integer> s2, Deque<Integer> s3, int length) {
		if (length <= 1) {
			return;
		}
		int leftLen = length / 2;
		int rightLen = length - leftLen;
		// move the left part to s2
		for (int i = 0; i < leftLen; i++) {
			s2.offerFirst(s1.pollFirst());
		}
		sort(s2, s1, s3, leftLen);
		sort(s1, s2, s3, rightLen);
		// now s2 and s1 are sorted, merge them into s3
		int i = 0;
		int j = 0;
		while (i < leftLen && j < rightLen) {
			if (s2.peekFirst() < s1.peekFirst()) {
				s3.offerFirst(s2.pollFirst());
				i++;
			} else {
				s3.offerFirst(s1.pollFirst());
				j++;
			}
		}
		while (i < leftLen) {
			s3.offerFirst(s2.pollFirst());
			i++;
		}
		while (j < rightLen) {
			s3.offerFirst(s1.pollFirst());
			j++;
		}
		// after merging, the numbers are in descending order from top to bottom in s3, we need to push them
		// back to s1 so that they are in ascending order
		for (int k = 0; k < length; k++) {
			s1.offerFirst(s3.pollFirst());
		}
	}
	
	public static void main(String[] args) {
		SortWith3Stacks test = new SortWith3Stacks();
		List<Integer> data = Arrays.asList(1, 4, 2, 8, 7, 0, 9, 5);
		Deque<Integer> stack = new LinkedList<>(data);
		System.out.println(stack);
		test.sort(stack);
		System.out.println(stack);
	}
}
