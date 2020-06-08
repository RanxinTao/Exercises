package check1_other;

/**
 * You are a skilled robber planing to rob house along a street. Each house has a certain amount of gold in it, but if you rob
 * two adjacent houses the security system will automatically contact the police.
 * Given a list of non-negative integers representing the amount of gold in each house, return the maximum amount of gold you
 * can rob without being caught.
 * 
 * Examples: 
 * 1. Input: {1, 5, 6, 7}, Output: 12
 * Explanation: You can either rob house 0 and house 2 (1 + 6 = 7) or you can rob house 1 and 3 (5 + 7 = 12)
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class HouseRobber {
	public int rob(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		int prevMax1 = 0; // max money can get if rob the current house
		int prevMax2 = num[0]; // max money can get if not rob the current house
		for (int i = 1; i < num.length; i++) {
			int curMax = Math.max(prevMax2, prevMax1 + num[i]);
			prevMax1 = prevMax2;
			prevMax2 = curMax;
		}
		return prevMax2;
	}
	
	/*public int rob(int[] num) {
		if (num.length <= 1) {
			return num.length == 0 ? 0 : num[0];
		}
		int[] max = new int[num.length];
		max[0] = num[0];
		max[1] = Math.max(num[0], num[1]);
		for (int i = 2; i < num.length; i++) {
			max[i] = Math.max(max[i - 1], max[i - 2] + num[i]);
		}
		return max[num.length - 1];
	}*/
	
	public static void main(String[] args) {
		HouseRobber test = new HouseRobber();
		int[] num = new int[] {1, 5, 6, 7};
		System.out.println(test.rob(num));
	}
}
