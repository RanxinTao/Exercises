package check1_largest_longestSub;

/**
 * Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.
 * 
 * Assumptions: array is not null
 * Examples: 
 * {0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.  
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class LongestConsecutive1s {
	public int longest(int[] array) {
		int localMax = 0;
		int globalMax = 0;
		for (int i = 0; i < array.length; i++) {
			localMax = array[i] == 1 ? localMax + 1 : 0;
			globalMax = Math.max(localMax, globalMax);
		}
		return globalMax;
	}
	
	/*public int longest(int[] array) {
		int local_max = 0;
		int global_max = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1) {
				local_max++;
			} else {
				global_max = Math.max(local_max, global_max);
				local_max = 0;	
			}
		}
		return Math.max(global_max, local_max);
	}*/
	
	public static void main(String[] args) {
		LongestConsecutive1s test = new LongestConsecutive1s();
		int[] array = {0, 1, 0, 1, 1, 1, 0};
		System.out.println(test.longest(array));
	}
}
