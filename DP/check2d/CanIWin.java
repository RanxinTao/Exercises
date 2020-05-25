package check2d;

/**
 * There is an array of positive integers, in which each integer represents a piece of Pizza's size, you and your
 * friend take turns to pick pizza from either end of the array. The winner is the one who gets larger total sum of
 * all pizza. Returns whether you will win the game if you start first.
 * 
 * Examples:
 * Input: [2, 1, 100, 3] Output: True
 * Explanation: To win the game, you pick 2 first, then your friend will pick either 1 or 3, after that you could
 * pick 100. In the end you could get 2 + 100 = 102, while your friend could only get 1 + 3 = 4.
 * 
 * Induction rule:
 * dp[i][j] represents the maximum total sum I can eat from ith pizza to jth pizza.
 * dp[i][j] = max(nums[i] + min(dp[i + 2][j], dp[i + 1][j - 1]), 
 *                nums[j] + min(dp[i + 1][j - 1], dp[i][j - 2]))
 * Base cases:
 * dp[i, j] = nums[i], if i == j
 * dp[i, j] = max[nums[i], nums[j]], if j == i + 1
 * 
 * Time: O(n^2)
 * Space: O(n^2)
 * 
 * Reference: 
 * 1. https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
 */
public class CanIWin {
	public boolean canWin(int[] nums) {
		int total = 0;
		for (int num : nums) {
			total += num;
		}
		int[][] dp = new int[nums.length][nums.length];
		for (int j = 0; j < dp.length; j++) {
			for (int i = j; i >= 0; i--) {
				if (i == j) {
					dp[i][j] = nums[i];
				} else if (j == i + 1) {
					dp[i][j] = Math.max(nums[i], nums[j]);
				} else {
					dp[i][j] = Math.max(nums[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]), 
							nums[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
				}
			}
		}
		int myMax = dp[0][nums.length - 1];
		return myMax >= total - myMax; // Note: ties count towards wins in this problem
	}
	
	public static void main(String[] args) {
		CanIWin test = new CanIWin();
		int[] nums = {2, 1, 100, 3};
		System.out.println(test.canWin(nums));
	}
}
