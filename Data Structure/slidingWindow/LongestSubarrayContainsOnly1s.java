package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers that contains only 0s and 1s and a positive integer k, you can flip at most k 0s to 1s,
 * return the longest subarray that contains only integer 1 after flipping.
 * 
 * Assumptions: 
 * 1. Length of given array is between [1, 20000].
 * 2. The given array only contains 1s and 0s.
 * 3. 0 <= k <= length of given array.
 * 
 * Examples:
 * 1. Input: array = [1, 1, 0, 0, 1, 1, 1, 0, 0, 0], k = 2, Output: 7
 * Explanation: flip 0s at index 2 and 3, then the array becomes [1, 1, 1, 1, 1, 1, 1, 0, 0 ,0], so that the length of longest
 * subarray that contains only integer 1 is 7.
 * 2. Input: array = {1, 1, 0, 0, 1, 1, 1, 0, 0, 0}, k = 0, Output: 3
 * Explanation: k is 0 so you can not flip any 0 to 1, then the length of longest subarray that contains only integer 1 is 3.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class LongestSubarrayContainsOnly1s {
	public int longestConsecutiveOnes(int[] nums, int k) {
		int longest = 0;
		int left = 0;
		int right = 0;
		int count0 = 0;
		while (right < nums.length) {
			if (left == right || count0 <= k) {
				if (nums[right] == 0) {
					count0++;
				}
				right++;
			} else { // count0 > k
				if (nums[left] == 0) {
					count0--;
				}
				left++;
			}
			if (count0 <= k) {
				longest = Math.max(longest, right - left);
			}
		}
		return longest;
	}
	
	public static void main(String[] args) {
		LongestSubarrayContainsOnly1s test = new LongestSubarrayContainsOnly1s();
		int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 0, 0};
		int k = 0;
		System.out.println(test.longestConsecutiveOnes(nums, k));
	}
}
