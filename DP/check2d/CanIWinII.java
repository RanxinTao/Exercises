package check2d;

/**
 * There is an array of positive integers, in which each integer represents a piece of Pizza's size, you and your
 * friend take turns to pick pizza from either end of the array. Your friend follows a simple strategy: He will 
 * always pick the larger one he could get during his turn. The winner is the one who gets larger total sum of
 * all pizza. Returns the max amount of pizza you can get.
 * 
 * Assumption: If during your friend's turn, the leftmost pizza has the same size as the rightmost pizza, he will
 * pick the rightmost one.
 * 
 * Examples:
 * Input: [2, 1, 100, 3] Output: 102
 * Explanation: To win the game, you pick 2 first, then your friend will pick 3 (the larger one between 3 and 1), 
 * after that you could pick 100. In the end you could get 2 + 100 = 102, while your friend could only get 1 + 3 = 4.
 * 
 * Induction rule:
 * dp[i][j] represents the maximum total sum I can eat from ith pizza to jth pizza. Because the opponent always follows 
 * the greedy strategy:
 * dp[i][j] = max(nums[i] + dp[i + 2][j], nums[j] + dp[i + 1][j - 1]), if nums[i + 1] > nums[j] and nums[i] > nums[j - 1] 
 *            max(nums[i] + dp[i + 2][j], nums[j] + dp[i][j - 2]), if nums[i + 1] > nums[j] and nums[i] <= nums[j - 1]
 *            max(nums[i] + dp[i + 1][j - 1], nums[j] + dp[i + 1][j - 1]), if nums[i + 1] <= nums[j] and nums[i] > nums[j - 1] 
 *            max(nums[i] + dp[i + 1][j - 1], nums[j] + dp[i][j - 2])), if nums[i + 1] <= nums[j] and nums[i] <= nums[j - 1]       
 * Base cases:
 * dp[i, j] = nums[i], if i == j
 * dp[i, j] = max[nums[i], nums[j]], if j == i + 1
 * 
 * Time: O(n^2)
 * Space: O(n^2)
 */
public class CanIWinII {
	public int canWin(int[] nums) {
		int[][] dp = new int[nums.length][nums.length];
		for (int j = 0; j < dp.length; j++) {
			for (int i = j; i >= 0; i--) {
				if (i == j) {
					dp[i][j] = nums[i];
				} else if (j == i + 1) {
					dp[i][j] = Math.max(nums[i], nums[j]);
				} else {
					int res1 = nums[i] + (nums[i + 1] > nums[j] ? dp[i + 2][j] : dp[i + 1][j - 1]);
					int res2 = nums[j] + (nums[i] > nums[j - 1] ? dp[i + 1][j - 1] : dp[i][j - 2]);
					dp[i][j] = Math.max(res1, res2);
				}
			}
		}
		return dp[0][nums.length - 1];
	}
	
	public static void main(String[] args) {
		CanIWinII test = new CanIWinII();
		int[] nums = {2, 1, 100, 3};
		System.out.println(test.canWin(nums));
	}
}
