package largest_longestSub_0d;

/**
 * Assumptions: array is not null
 * Examples:
 * {7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.
 * {1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
 * Induction rule:
 *     dp[i] = 1			 (array[i] <= array[i - 1])
 * 		     = dp[i - 1] + 1 (array[i] > array[i - 1])
 */
public class LongestAscendingSubArray {	
	public int longest(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int global_max = 1;
		int local_max = 1;
		for (int i = 1; i < array.length; i++) {
			local_max = array[i - 1] < array[i] ? local_max + 1 : 1;
			global_max = Math.max(local_max, global_max);
		}
		return global_max;
	}
	
	/*public int longest(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int global_max = 1;
		int local_max = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				local_max++;
			} else {
				global_max = Math.max(local_max, global_max);
				local_max = 1;
			}			
		}
		return Math.max(local_max, global_max);
	}*/
	
	public static void main(String[] args) {
		LongestAscendingSubArray test = new LongestAscendingSubArray();
		int[] array = {1, 2, 3, 4, 5};
		System.out.println(test.longest(array));
	}
}
