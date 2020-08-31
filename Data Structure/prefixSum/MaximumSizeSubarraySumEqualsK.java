package prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
 * If there isn't one, return 0 instead.
 * Follow up: Can you do it in O(n) time?
 * 
 * Assumptions:
 * 1. The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 * 
 * Examples:
 * 1. Given nums = [1, -1, 5, -2, 3], k = 3, return 4. (because the subarray [1, -1, 5, -2] sums to
 * 3 and is the longest)
 * 2. Given nums = [-2, -1, 2, 1], k = 1, return 2. (because the subarray [-1, 2] sums to 1 and is
 * the longest)
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class MaximumSizeSubarraySumEqualsK {
	public int maxSubArrayLen(int[] nums, int k) {
		int maxLen = 0; // max size
		int sum = 0;
		Map<Integer, Integer> prefixSums = new HashMap<>(); // key: prefix sum before value index (inclusive), value: index
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i]; // accumulate sum
			if (sum == k) { // corner case: prefix sum = current sum - k = 0
				maxLen = i + 1;
			}
			Integer idx = prefixSums.get(sum - k); // target = sum - k
			if (idx != null) {
				maxLen = Math.max(maxLen, i - idx);
			}
			prefixSums.putIfAbsent(sum, i); // don't update if the value already exists because we want to keep the index as small as possible
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		MaximumSizeSubarraySumEqualsK test = new MaximumSizeSubarraySumEqualsK();
		/*int[] nums = {1, -1, 5, -2, 3};
		int k = 3; // return 4 */
		int[] nums = {-2, -1, 2, 1};
		int k = 1; // return 2
		System.out.println(test.maxSubArrayLen(nums, k));
	}
}
