package array2Pointers_sameDirection;

import impl.Utils;

/**
 * Unsorted array, duplicate element not retain any, plus repeatedly deduplication:
 * Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right. For each group 
 * of elements with the same value do not keep any of them. Do this in-place, using the left side of the original array.
 * Return the array after deduplication.
 * 
 * Assumptions:
 * The given array is not null
 * 
 * Examples:
 * 1. {1, 2, 3, 3, 3, 2, 2} -> {1, 2, 2, 2} -> {1}, return {1}
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class ArrayDeduplicationIV {
	// we are using the left part of the original array as a stack, and top is the index of the top element of the stack.
	// if the stack is empty (end == -1), we just push the element into the stack, or if the element is not the same 
	// as the top element, we can push the element into the stack as well. we start by pushing array[0] into the stack.
	public int[] dedup(int[] array) {
		if (array.length <= 1) {
			return array;
		}
	    int top = 0; // push array[0] into the stack first
	    for (int i = 1; i < array.length; i++) {
	      if (top == -1 || array[top] != array[i]) { // if the stack is empty or the element is not the same as the top element
	        top++;
	        array[top] = array[i];     
	      } else { // otherwise (if the stack is not empty and the current element is same as the top element)
	          while (i + 1 < array.length && array[i + 1] == array[top]) { 
	            i++; // skip all consecutive duplicates
	          }
	          top--; // remove the top element of the stack.
	      }
	    }
	    int[] res = new int[top + 1]; // copy the subarray to a new array
	    for (int i = 0; i <= top; i++) {
	      res[i] = array[i];
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		ArrayDeduplicationIV test = new ArrayDeduplicationIV();
		int[] array = {1,2,2,2,3,3,3,2};
		Utils.printArray(test.dedup(array));
	}
}
