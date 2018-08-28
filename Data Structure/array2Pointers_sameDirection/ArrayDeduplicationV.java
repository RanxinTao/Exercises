package array2Pointers_sameDirection;

import java.util.Arrays;

/**
 * Unsorted array, duplicate element only retain two:
 * Given an integer array(not guaranteed to be sorted), remove adjacent repeated elements. For each group of elements with the 
 * same value keep at most two of them. Do this in-place, using the left side of the original array and maintain the relative order 
 * of the elements of the array. Return the final array.
 *
 * Assumptions:
 * The given array is not null
 * Examples:
 * {1, 2, 2, 3, 3, 3} --> {1, 2, 2, 3, 3}
 * {2, 1, 2, 2, 2, 3} --> {2, 1, 2, 2, 3} 
 */
public class ArrayDeduplicationV {
	public int[] dedup(int[] array) {
		// elements start from 0 and array[end] (inclusive) are kept.
		int end = 0;
		int count = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[end] == array[i]) {
				if (count < 2) {
					end++;
					array[end] = array[i];
					count++;
				}
			} else {
				end++;
				array[end] = array[i];
				count = 1;
			}
		}
		return Arrays.copyOf(array, end + 1);
	}

	public static void main(String[] args) {
		ArrayDeduplicationV test = new ArrayDeduplicationV();
		int[] array = { 2, 3, 1, 2, 2, 2, 2, 3, 3, 3 };
		System.out.println(Arrays.toString(test.dedup(array)));
	}
}
