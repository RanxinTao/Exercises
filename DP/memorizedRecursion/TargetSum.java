package memorizedRecursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an int array and a target number, for each number in the given array, you can assign symbol "+" or "-" to
 * that number. Return number of ways to add symbol to all elements in the given array so that the sum of them equals
 * to target.
 * 
 * Examples:
 * 1. nums = [1, 0], target = 1
 * Output: 2
 * Explanation: + 1 + 0 = 1; + 1 - 0 = 1
 * 
 * Thoughts: First, this problem can be solved by DFS. We can also realize that during DFS, a lot of redundant function 
 * calls could be made with the same value of idx, and the same value of sum, since the same values could be obtained 
 * through multiple paths in the recursion tree. In order to remove this redundancy, we make use of memorization to
 * store the results which have been calculated earlier.
 * Reference: https://leetcode.com/problems/target-sum/solution/
 * 
 * Time: O(mn), where n is the length of the array, and m is the range of sum
 * Space: O(mn)
 * Because the first number can be assigned "+" or "-", the rest part should be = target - nums[0] or target + nums[0], 
 * so there are two branches, and each branch generates two more branches. Therefore, without memorization, the time 
 * complexity is 2^n. However, with memorization, for every recursion level, the target value is maximum +sum of nums
 * and minimum -sum of nums, the hashmap stores at most that many values, and there are n recursion levels, so the time
 * complexity becomes mn.
 */
public class TargetSum {
	public int waysToTargetSum(int[] nums, int target) {
		return waysToTargetSum(nums, target, 0, new HashMap<>());
	}
	
	private int waysToTargetSum(int[] nums, int target, int idx, Map<List<Integer>, Integer> memo) {
		if (idx == nums.length) {
			return target == 0 ? 1 : 0;
		}
		List<Integer> key = Arrays.asList(idx, target);
		Integer value = memo.get(key);
		if (value != null) {
			return value;
		}
		int numWays = waysToTargetSum(nums, target - nums[idx], idx + 1, memo) + waysToTargetSum(nums, target + nums[idx], idx + 1, memo);
		memo.put(key, numWays);
		return numWays;
	}
	
	/*public int waysToTargetSum(int[] nums, int target) {
		return waysToTargetSum(nums, target, 0);
	}
	
	private int waysToTargetSum(int[] nums, int target, int idx) {
		if (idx == nums.length) {
			return target == 0 ? 1 : 0;
		}
		return waysToTargetSum(nums, target - nums[idx], idx + 1) + waysToTargetSum(nums, target + nums[idx], idx + 1);
	}*/
	
	public static void main(String[] args) {
		TargetSum test = new TargetSum();
		int[] nums = {13, 9, 8, 5, 11, 15, 16, 9, 15, 7, 0, 10, 11, 9, 12, 1};
		int target = 25;
		System.out.println(test.waysToTargetSum(nums, target));
		
	}
}
