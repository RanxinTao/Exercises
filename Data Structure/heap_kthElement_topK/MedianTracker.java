package heap_kthElement_topK;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given a unlimited flow of numbers, keep track of the median of all elements seen so far.
 * You will have to implement the following two methods for the class
 * 1. read(int value) - read one value from the flow
 * 2. median() - return the median at any time, return null if there is no value read so far
 * 
 * Examples:
 * read(1), median is 1; read(2), median is 1.5; read(3), median is 2; read(10), median is 2.5
 * 
 * Time: O(nlogn)
 * Space: O(n)
 */
public class MedianTracker {
	private PriorityQueue<Integer> smallerHalf;
	private PriorityQueue<Integer> largerHalf;

	public MedianTracker() {
		largerHalf = new PriorityQueue<Integer>(); // min heap
		smallerHalf = new PriorityQueue<Integer>(Collections.reverseOrder()); // max heap
	}

	// maintain the property: smallerHalf.size() == largerHalf.size() when even number of values read, 
	// or smallerHalf.size() == largerHalf.size() + 1, when odd number of values read.
	public void read(int value) {
		if (smallerHalf.isEmpty() || value <= smallerHalf.peek()) {
			smallerHalf.offer(value);
		} else {
			largerHalf.offer(value);
		}
		if (smallerHalf.size() - largerHalf.size() > 1) { // adjustment
			largerHalf.offer(smallerHalf.poll());
		} else if (largerHalf.size() > smallerHalf.size()) {
			smallerHalf.offer(largerHalf.poll());
		}
	}

	public Double median() {
		int size = smallerHalf.size() + largerHalf.size();
		if (size == 0) {
			return null;
		} else if (size % 2 != 0) { // odd number
			return (double) (smallerHalf.peek());
		} else { // even number
			return (smallerHalf.peek() + largerHalf.peek()) / 2.0;
		}
	}
}
