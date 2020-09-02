package slidingWindow;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a
 * contiguous subarray of which the sum >= s. If there isn't one, return 0 instead.
 * 
 * Examples:
 * 1. Given the array [2, 3, 1, 2, 4, 3] and s = 7, the subarray [4, 3] has the minimal length under
 * the problem constraint.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int num, int[] nums) {
		int minLen = Integer.MAX_VALUE;
		int sum = 0;
		int l = 0; // inclusive
		for (int r = 0; r < nums.length; r++) { // r is also inclusive
			sum += nums[r];
			while (sum >= num) { // sum >= num, remove as many numbers as possible from left and update result
				minLen = Math.min(minLen, r - l + 1);
				sum -= nums[l++];		
			} // after this loop, it is guaranteed that sum < num
		}
		return minLen < Integer.MAX_VALUE ? minLen : 0;
	}
	
	public static void main(String[] args) {
		MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
		int[] nums = {2, 3, 1, 2, 4, 3};
		int num = 7; // 2
		/* int[] nums = {6};
		int num = 9; // 0 */
		System.out.println(test.minSubArrayLen(num, nums));
	}
}
