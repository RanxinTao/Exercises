package stack;

import java.util.Deque;
import java.util.LinkedList;

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
