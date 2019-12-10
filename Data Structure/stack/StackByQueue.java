package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a stack containing integers using queue(s). The stack should provide push(x), pop(), top(), and isEmpty()
 * operations. If the stack is empty, then top() and pop() will return null.
 * 
 * Time: push: O(n), pop: O(1)
 * Space: push: O(1), pop: O(1)
 */
public class StackByQueue {
	private Queue<Integer> queue;

	public StackByQueue() {
	    queue = new LinkedList<>();
	}

    public void push(int x) { // Push element x onto stack.
    	queue.offer(x);
    	for (int i = 1; i <= queue.size() - 1; i++) {
         	queue.offer(queue.poll());
        } 
    }
    
    public Integer pop() { // Removes the element on top of the stack and returns that element.
        return queue.poll();
    }

    
    public Integer top() { // Get the top element.
        return queue.peek();
    }

    
    public boolean isEmpty() { // Returns whether the stack is empty.
    	return queue.isEmpty();
    }
}
