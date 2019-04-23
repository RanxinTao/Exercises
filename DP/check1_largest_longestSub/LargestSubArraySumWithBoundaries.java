package check1_largest_longestSub;

import impl.Utils;

/**
 * Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.
 * 
 * Assumptions: 
 * 1. array is not null and has length >= 1
 * 2. the subarray must contain at least one element
 * Examples:
 * {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
 * {-2, -1, -3}, the largest subarray sum is -1
 */
public class LargestSubArraySumWithBoundaries {
	public int[] largestSum(int[] array) {
		int localMax = array[0];
		int globalMax = array[0];
		int localLeft = 0;
		int globalLeft = 0;
		int globalRight = 0;
		for (int i = 1; i < array.length; i++) { // i can also be used as localRight
			if (localMax < 0) {
				localMax = array[i];
				localLeft = i;
			} else {
				localMax += array[i];
			}
			if (globalMax < localMax) {
				globalMax = localMax;
				globalLeft = localLeft;
				globalRight = i;
			}
		}
		return new int[] {globalMax, globalLeft, globalRight};
	}
	
	public static void main(String[] args) {
		LargestSubArraySumWithBoundaries test = new LargestSubArraySumWithBoundaries();
		int[] array = {-2, -1, -3};
		Utils.printArray(test.largestSum(array));
	}
}
