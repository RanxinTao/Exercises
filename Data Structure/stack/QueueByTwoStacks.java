package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Implement a queue by using two stacks. The queue should provide size(), isEmpty(), offer(), poll(), and peek()
 * operations. When the queue is empty, poll() and peek() should return null.
 * 
 * Assumptions:
 * 1. The elements in the queue are all Integers.
 * 2. size() should return the number of element buffered in the queue.
 * 3. isEmpty() should return true if there is no element buffered in the queue, false otherwise.
 */
public class QueueByTwoStacks {
	private Deque<Integer> in;
	private Deque<Integer> out;

	public QueueByTwoStacks() {
	    in = new LinkedList<>();
	    out = new LinkedList<>();
	  }

	public Integer poll() {
		moveIfEmpty();
		return out.isEmpty() ? null : out.pollFirst();
	}

	public void offer(int element) {
		in.offerFirst(element);
	}

	public Integer peek() {
		moveIfEmpty();
		return out.isEmpty() ? null : out.peekFirst();
	}

	public int size() {
		return in.size() + out.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	private void moveIfEmpty() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.offerFirst(in.pollFirst());
			}
		}
	}
}
