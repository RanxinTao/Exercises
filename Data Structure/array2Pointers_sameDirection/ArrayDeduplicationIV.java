package array2Pointers_sameDirection;

import impl.Utils;

/**
 * unsorted array, duplicate element not retain any, repeatedly deduplication
 * {1,2,3,3,3,2,2} ¡ú {1,2,2,2} ¡ú {1} 
 * Assumptions: array is not null
 */
public class ArrayDeduplicationIV {
	public int[] dedup(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		// we are using the left part of the original array as a stack, and top is the index of 
		// the top element of the stack.
	    // if the stack is empty (end == -1), we just push the element into the stack, or if the 
		// element is not the same as the top element, we can push the element into the stack as well.
	    // we first push array[0] into the stack.
	    int top = 0;
	    for (int i = 1; i < array.length; i++) {
	      if (top == -1 || array[top] != array[i]) {
	        top++;
	        array[top] = array[i];
	      // otherwise (the stack is not empty and the current element is same as the top element),
	      // we should skip all consecutive duplicates and remove the top element of the stack.
	      } else {
	          while (i + 1 < array.length && array[i + 1] == array[top]) {
	            i++;
	          }
	          // remove array[top] by top--
	          top--;
	      }
	    }
	    // copy the subarray to a new array
	    int[] res = new int[top + 1];
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
