package stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SortWith2Stacks {
	public void sort(Deque<Integer> stack) {
		Deque<Integer> buffer = new LinkedList<>();
		int rem = stack.size();
		while (rem > 0) {
			int max = Integer.MIN_VALUE;
			int count = 0;
			for (int i = 0; i < rem; i++) {
				int cur = stack.pollFirst();
				buffer.offerFirst(cur);
				if (cur > max) {
					max = cur;
					count = 1;
				} else if (cur == max) {
					count++;
				}	
			}
			// push the max numbers to the bottom of the original stack and then push remaining numbers back
			moveBack(stack, buffer, max, count);
			rem -= count;
		}
	}
	
	private void moveBack(Deque<Integer> stack, Deque<Integer> buffer, int max, int count) {
		while (count > 0) {
			stack.offerFirst(max);
			count--;
		}
		while (!buffer.isEmpty()) {
			int cur = buffer.pollFirst();
			if (cur != max) {
				stack.offerFirst(cur);
			}
		}
	}
	
	public static void main(String[] args) {
		SortWith2Stacks test = new SortWith2Stacks();
		List<Integer> data = Arrays.asList(1, 4, 2, 8, 7, 0, 9, 5);
		Deque<Integer> stack = new LinkedList<>(data);
		System.out.println(stack);
		test.sort(stack);
		System.out.println(stack);
	}
}
