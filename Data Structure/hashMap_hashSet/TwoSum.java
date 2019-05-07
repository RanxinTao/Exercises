package hashMap_hashSet;

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
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class TwoSum {
	public boolean existSum(int[] array, int target) {
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
	}
}
