package check1_largest_longestSub;

/**
 * Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.
 * 
 * Assumptions: 
 * 1. array is not null and has length >= 1
 * 2. the subarray must contain at least one element
 * Examples:
 * 1. {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
 * 2. {-2, -1, -3}, the largest subarray sum is -1
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class LargestSubArraySum {
	public int largestSum(int[] array) {
		int localMax = array[0];
		int globalMax = array[0];		
		for (int i = 1; i < array.length; i++) {
			localMax = Math.max(array[i], array[i] + localMax);
			globalMax = Math.max(localMax, globalMax);
		}
		return globalMax;
	}
	
	public static void main(String[] args) {
		LargestSubArraySum test = new LargestSubArraySum();
		int[] array = {2, -1, 4, -2, 1};
		System.out.println(test.largestSum(array));
	}
}
