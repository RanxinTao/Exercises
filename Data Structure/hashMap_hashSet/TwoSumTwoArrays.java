package hashMap_hashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays A and B, determine whether or not there exists a pair of elements, one drawn from each array, 
 * that sums to the given target number.
 * 
 * Assumptions: 
 * The two given arrays are not null and have length of at least 1
 * 
 * Examples:
 * A = {3, 1, 5}, B = {2, 8}, target = 7, return true(pick 5 from A and pick 2 from B)
 * A = {1, 3, 5}, B = {2, 8}, target = 6, return false
 */
public class TwoSumTwoArrays {
	public boolean existSum(int[] a, int[] b, int target) {
		int[] shorter = a;
		int[] longer = b;
		if (a.length > b.length) {
			shorter = b;
			longer = a;
		}
		Set<Integer> set = new HashSet<>();
		for (int num : shorter) {
			set.add(num);
		}
		for (int num : longer) {
			int diff = target - num;
			if (set.contains(diff)) {
				return true;
			}
		}
		return false;
	}
}
