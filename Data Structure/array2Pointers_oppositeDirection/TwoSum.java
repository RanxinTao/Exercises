package array2Pointers_oppositeDirection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Determine if there exist two elements in a given array, the sum of which is the given target number.
 * 
 * Assumptions:
 * The given array is not null and has length of at least 2
 * 
 * Examples:
 * A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)
 * A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)
 * A = {2, 4, 1}, target = 4, return false
 */
public class TwoSum {
	/*public boolean existSum(int[] array, int target) {
		Set<Integer> set = new HashSet<>();
		for (int num : array) {
			int diff = target - num;
			if (set.contains(diff)) {
				return true;
			} else {
				set.add(num);
			}
		}
		return false;
	}*/
	
	public boolean existSum(int[] array, int target) {
		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int sum = array[left] + array[right];
			if (sum == target) {
				return true;
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}
}
