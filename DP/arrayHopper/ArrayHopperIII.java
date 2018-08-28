package arrayHopper;

/**
 * Assumptions: array is not null and has length >= 1
 * Examples:
 * {1, 3, 2, 0, 2}, the minimum number of jumps needed is 3 (jump to index 1 then to the end of array, then jump out).
 * {3, 2, 1, 1, 0}, not able to jump out of array, return -1 in this case.
 * Induction rule:
 *     dp[i] = Math.min(dp[i + 1], dp[i + 2], dp[i + 3], ...) + 1 (dp[i + 1] != -1 && dp[i + 2] != -1 && dp[i + 3] != -1 &&...)
 * 		     = -1 												  (all dp[] == -1)
 */
public class ArrayHopperIII {
	public int minJump(int[] array) {
		int[] dp = new int[array.length + 1];
		for (int i = dp.length - 2; i >= 0; i--) {
			dp[i] = -1;
			for (int jump = 1; jump <= array[i] && i + jump < dp.length; jump++) {
				if (dp[i + jump] != -1 && (dp[i] == -1 || dp[i] > dp[i + jump] + 1)) {
					dp[i] = dp[i + jump] + 1;
				}
			}
		}
		return dp[0];
	}
	
	public static void main(String[] args) {
		ArrayHopperIII test = new ArrayHopperIII();
		int[] array = new int[] {1};
		System.out.println(test.minJump(array));
	}
}
