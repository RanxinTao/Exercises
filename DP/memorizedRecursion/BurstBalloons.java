package memorizedRecursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to 
 * burst all the balloons. If you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are
 * adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *  
 * Assumptions:
 * 1. You may image nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 2. 0 <= n <= 500, 0 <= nums[i] <= 100
 * 
 * Examples:
 * 1. Given [3, 1, 5, 8], return 167
 * nums  = [3, 1, 5, 8] --> [3, 5, 8]
 * coins = 3 * 1 * 5 + 3 * 5 * 8.
 * 
 * Time: O(n^2), where n is the length of the array
 * Space: O(n^2)
 */
public class BurstBalloons {
	public int maxCoins(int[] nums) {
		return maxCoinsSub(nums, 0, nums.length - 1, new HashMap<>());
	}
	
	private int maxCoinsSub(int[] nums, int l, int r, Map<Integer, Integer> memo) {
		if (l > r) {
			return 0;
		}
		int key = l * nums.length + r;
		Integer value = memo.get(key);
		if (value != null) {
			return value;
		}
		int maxRes = Integer.MIN_VALUE;
		for (int i = l; i <= r; i++) { // let i be the last (NOT first) balloon to be burst between l and r, so its left and right balloons can be determined.
			int leftNum = l == 0 ? 1 : nums[l - 1]; // i is set to be the last balloon to be burst so the left half between l and i and the right half between i and r
			int rightNum = r == nums.length - 1 ? 1 : nums[r + 1]; // will be gone at that time, so the left ballon is nums[l - 1] and the right one is nums[r + 1]
			maxRes = Math.max(maxRes, leftNum * nums[i] * rightNum + maxCoinsSub(nums, l, i - 1, memo) + maxCoinsSub(nums, i + 1, r, memo));
		}
		memo.put(key, maxRes);
		return maxRes;
	}
	
	public static void main(String[] args) {
		BurstBalloons test = new BurstBalloons();
		int[] nums = {3, 1, 5, 8};
		System.out.println(test.maxCoins(nums));
	}
}
