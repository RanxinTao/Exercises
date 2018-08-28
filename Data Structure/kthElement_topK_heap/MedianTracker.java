package kthElement_topK_heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianTracker {
	private PriorityQueue<Integer> smallerHalf;
	private PriorityQueue<Integer> largerHalf;

	public MedianTracker() {
		largerHalf = new PriorityQueue<Integer>(); // min heap
		smallerHalf = new PriorityQueue<Integer>(Collections.reverseOrder()); // max heap
	}

	public void read(int value) {
		// maintain the property: smallerHalf.size() == largerHalf.size() when there are even number of values read,
		// or smallerHalf.size() == largerHalf.size() + 1, when there are odd number of values read.
		if (smallerHalf.isEmpty() || value <= smallerHalf.peek()) {
			smallerHalf.offer(value);
		} else {
			largerHalf.offer(value);
		}
		// adjustment
		if (smallerHalf.size() - largerHalf.size() > 1) {
			largerHalf.offer(smallerHalf.poll());
		} else if (largerHalf.size() > smallerHalf.size()) {
			smallerHalf.offer(largerHalf.poll());
		}
	}

	public Double median() {
		int size = size();
		if (size == 0) {
			return null;
		} else if (size % 2 != 0) {
			return (double) (smallerHalf.peek());
		} else {
			return (smallerHalf.peek() + largerHalf.peek()) / 2.0;
		}
	}

	private int size() {
		return smallerHalf.size() + largerHalf.size();
	}
}
