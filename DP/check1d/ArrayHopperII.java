package check1d;

/**
 * Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the
 * maximum jump distance from index i (you can only jump towards the end of the array). Determine the minimum number
 * of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.
 * 
 * Assumptions: array is not null and has length >= 1
 * Examples:
 * 1. {3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array).
 * 2. {2, 1, 1, 0, 2}, not able to reach the end of array, return -1 in this case.
 * 
 * Induction rule:
 *     dp[i] = Math.min(dp[i + 1], dp[i + 2], dp[i + 3], ...) + 1 (dp[i + 1] != -1 && dp[i + 2] != -1 && dp[i + 3] != -1 &&...)
 * 		     = -1 												  (all dp[] == -1)
 * 
 * Time: O(n^2)
 * Space: O(n)
 */
public class ArrayHopperII {
	// dp from left to right
	public int minJump(int[] array) {
		int[] minJump = new int[array.length];
		for (int i = 1; i < minJump.length; i++) {
			minJump[i] = -1;
			for (int j = 0; j <= i - 1; j++) {
				if (minJump[j] != -1 && j + array[j] >= i) { // minJump[j] = -1 means unreachable
					if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) {
						minJump[i] = minJump[j] + 1;
					}
				}
			}
		}
		return minJump[minJump.length - 1];
	}
	
	// dp from right to left
	/*public int minJump(int[] array) {
		int[] minJump = new int[array.length];
		for (int i = minJump.length - 2; i >= 0; i--) {
			minJump[i] = -1;
			for (int jump = 1; jump <= array[i] && i + jump < minJump.length; jump++) {
				if (minJump[i + jump] != -1 && (minJump[i] == -1 || minJump[i] > minJump[i + jump] + 1)) {
					minJump[i] = minJump[i + jump] + 1;
				}
			}
		}
		return minJump[0];
	}*/
	
	public static void main(String[] args) {
		ArrayHopperII test = new ArrayHopperII();
		int[] array = {3, 3, 1, 0, 4};
		System.out.println(test.minJump(array));
	}
}
