package array2Pointers_sameDirection;

import impl.Utils;

/**
 * Given an array of integers, move all the 0s to the right end of the array. 
 * The relative order of the elements in the original array need to be maintained.
 * 
 * Assumptions: 
 * The given array is not null
 * 
 * Examples:
 * 1. {1} -> {1}
 * 2. {1, 0, 3, 0, 1} -> {1, 3, 1, 0, 0}
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class Move0sToTheEnd {
	public int[] moveZero(int[] array) {
		int end = 0; // all numbers on the left side of end are not 0
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				array[end] = array[i];
				end++;
			}
		}
		for (int i = end; i < array.length; i++) { // fill in the right part with 0
			array[i] = 0;
		}
		return array;
	}
	
	public static void main(String[] args) {
		Move0sToTheEnd test = new Move0sToTheEnd();
		int[] array = {1, 0, 3, 0, 1};
		Utils.printArray(test.moveZero(array));
	}
}