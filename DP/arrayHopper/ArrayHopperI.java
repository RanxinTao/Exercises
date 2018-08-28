package arrayHopper;

/**
 * Assumptions: array is not null and has length >= 1
 * Examples:
 * {1, 3, 2, 0, 3}, able to reach the end of array (jump to index 1 then reach the end of the array)
 * {2, 1, 1, 0, 2}, not able to reach the end of array
 * Induction rule:
 *     dp[i] = true	 (dp[i + 1] == true || dp[i + 2] == true || dp[i + 3] == true ||...)
 * 		     = false (otherwise)
 */
public class ArrayHopperI {
	public boolean canJump(int[] array) {
		boolean[] dp = new boolean[array.length];
		dp[dp.length - 1] = true;
		for (int i = dp.length - 2; i >= 0; i--) {
			for (int jump = 1; jump <= array[i] && i + jump < dp.length; jump++) {
				if (dp[i + jump]) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[0];
	}
	
	public static void main(String[] args) {
		ArrayHopperI test = new ArrayHopperI();
		int[] array = {2, 1, 1, 0, 2};
		System.out.println(test.canJump(array));
	}
}
