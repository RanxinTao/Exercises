package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Enhance the stack implementation to support min() operation, min() should return the current minimum value in the
 * stack. If the stack is empty, min() should return -1.
 */
public class StackWithMin {
	private Deque<Integer> stack;
	private Deque<Integer> minStack;

	public StackWithMin() {
	    stack = new LinkedList<>();
	    minStack = new LinkedList<>();
	  }

	public int pop() {
		if (stack.isEmpty()) {
			return -1;
		}
		int res = stack.pollFirst();
		if (res == minStack.peekFirst()) {
			minStack.pollFirst();
		}
		return res;
	}

	public void push(int element) {
		stack.offerFirst(element);
		if (minStack.isEmpty() || element <= minStack.peekFirst()) {
			minStack.offerFirst(element);
		}
	}

	public int top() {
		return stack.isEmpty() ? -1 : stack.peekFirst();
	}

	public int min() {
		return minStack.isEmpty() ? -1 : minStack.peekFirst();
	}
}
