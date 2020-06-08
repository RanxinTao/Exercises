package check1_other;

/**
 * This is an extension of House Robber.
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not
 * get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the
 * neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximunm amount of money
 * you can rob tonight without alerting the police.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class HouseRobberII {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length <= 2) { // A circle has at least 3 houses
			return rob(nums, 0, nums.length - 1);
		}
		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}
	
	private int rob(int[] num, int start, int end) {
		int prevMax1 = 0; // max money can get if rob the current house
		int prevMax2 = num[start]; // max money can get if not rob the current house
		for (int i = start + 1; i <= end; i++) {
			int curMax = Math.max(prevMax2, prevMax1 + num[i]);
			prevMax1 = prevMax2;
			prevMax2 = curMax;
		}
		return prevMax2;
	}
	
	public static void main(String[] args) {
		HouseRobberII test = new HouseRobberII();
		int[] num = new int[] {11, 12, 5, 8, 3, 10, 5, 7, 13, 8};
		System.out.println(test.rob(num));
	}
}
