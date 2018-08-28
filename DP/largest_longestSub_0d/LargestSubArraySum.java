package largest_longestSub_0d;

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
public class LargestSubArraySum {
	public int largestSum(int[] array) {
		int local_max = array[0];
		int global_max = array[0];		
		for (int i = 1; i < array.length; i++) {
			local_max = Math.max(array[i], array[i] + local_max);
			global_max = Math.max(local_max, global_max);
		}
		return global_max;
	}
	
	public static void main(String[] args) {
		LargestSubArraySum test = new LargestSubArraySum();
		int[] array = {2, -1, 4, -2, 1};
		System.out.println(test.largestSum(array));
	}
}
