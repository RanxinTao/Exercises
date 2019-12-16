package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Implement a deque by using three stacks. The queue should provide size(), isEmpty(), offerFirst(), offerLast(),
 * pollFirst(), pollLast(), peekFirst(), and peekLast() operations. When the queue is empty, pollFirst(), peekFirst(),
 * and peek() should return null. The amortized time complexity of all operations should be O(1).
 * 
 * Assumptions:
 * 1. The elements in the queue are all Integers.
 * 2. size() should return the number of element buffered in the queue.
 * 3. isEmpty() should return true if there is no element buffered in the queue, false otherwise.
 * 4. The amortized time complexity of all operations should be O(1)
 */
public class DequeBy3Stacks {
	private Deque<Integer> left;
	private Deque<Integer> right;
	private Deque<Integer> buffer;

	public DequeBy3Stacks() {
	    left = new LinkedList<>();
	    right = new LinkedList<>();
	    buffer = new LinkedList<>(); 
	}

    public void offerFirst(int element) {
    	left.offerFirst(element);
    }
    
    public void offerLast(int element) {
    	right.offerFirst(element);
    }
    
    public Integer pollFirst() {
    	if (left.isEmpty()) {
    		balance(left, right, buffer);
    	}
    	return left.pollFirst();
    }
    
    public Integer pollLast() {
    	if (right.isEmpty()) {
    		balance(right, left, buffer);
    	}
    	return right.pollFirst();
    }
    
    public Integer peekFirst() {
    	if (left.isEmpty()) {
    		balance(left, right, buffer);
    	}
    	return left.peekFirst();
    }
    
    public Integer peekLast() {
    	if (right.isEmpty()) {
    		balance(right, left, buffer);
    	}
    	return right.peekFirst();
    }
    
    public int size() {
    	return left.size() + right.size();
    }
    
    public boolean isEmpty() {
    	return size() == 0;
    }
    
    private void balance(Deque<Integer> to, Deque<Integer> from, Deque<Integer> buffer) {
    	int size = from.size();
    	for (int i = 0; i < size / 2; i++) { // move n/2 elements from the non-empty stack to the buffer stack.
    		buffer.offerFirst(from.pollFirst());
    	}
    	while (!from.isEmpty()) {
    		to.offerFirst(from.pollFirst()); // move the rest n/2 elements from the non-empty stack to the empty stack.
    	}
    	while (!buffer.isEmpty()) {
    		from.offerFirst(buffer.pollFirst()); // move the first n/2 elements back from the buffer stack.
    	}
    }
}