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
	private Deque<Integer> temp;

	public DequeBy3Stacks() {
	    left = new LinkedList<>();
	    right = new LinkedList<>();
	    temp = new LinkedList<>(); 
	}

    public void offerFirst(int element) {
    	left.offerFirst(element);
    }
    
    public void offerLast(int element) {
    	right.offerFirst(element);
    }
    
    public Integer pollFirst() {
    	return left.size() == 0 ? findBottomOfStack(right, true) : left.pollFirst();
    }
    
    public Integer pollLast() {
    	return right.size() == 0 ? findBottomOfStack(left, true) : right.pollFirst();
    }
    
    public Integer peekFirst() {
    	return left.size() == 0 ? findBottomOfStack(right, false) : left.peekFirst();
    }
    
    public Integer peekLast() {
    	return right.size() == 0 ? findBottomOfStack(left, false) : right.peekFirst();
    }
    
    public int size() {
    	return left.size() + right.size();
    }
    
    public boolean isEmpty() {
    	return size() == 0;
    }
    
    private Integer findBottomOfStack(Deque<Integer> stack, boolean poll) {
    	if (!stack.isEmpty()) {
    		int size = stack.size();
    		for (int i = 1; i <= size - 1; i++) {
    			temp.offerFirst(stack.pollFirst());
    		}
    		int bottom = poll ? stack.pollFirst() : stack.peekFirst();
    		for (int i = 1; i <= size - 1; i++) {
    			stack.offerFirst(temp.pollFirst());
    		}
    		return bottom;
    	}
    	return null;
    }
}