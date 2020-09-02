package array2Pointers_moveTowards;

import java.util.Arrays;

/**
 * Determine if there exists a set of four elements in a given array that sum to the given target number.
 * 
 * Assumptions:
 * The given array is not null and has length of at least 4
 * 
 * Examples:
 * 1. A = {1, 2, 2, 3, 4}, target = 9, return true (1 + 2 + 2 + 4 = 8)
 * 2. A = {1, 2, 2, 3, 4}, target = 12, return false
 * 
 * Time: O(n^3)
 * Space: O(logn)
 */
public class FourSum {
	public boolean exist(int[] array, int target) {
		Arrays.sort(array);
		for (int i = 0; i < array.length - 3; i++) {
			for (int j = i + 1; j < array.length - 2; j++) {
				int left = j + 1;
				int right = array.length - 1;
				int newTarget = target - array[i] - array[j];
				while (left < right) {
					int sum = array[left] + array[right];
					if (sum < newTarget) {
						left++;
					} else if (sum == newTarget) {
						return true;
					} else {
						right--;
					}
				}
			}
		}
		return false;
	}
}
