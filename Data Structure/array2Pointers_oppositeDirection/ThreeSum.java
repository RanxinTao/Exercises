package array2Pointers_oppositeDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Determine if there exists three elements in a given array that sum to the given target number. 
 * Return all the triple of values that sums to target. 
 * 
 * Assumptions:
 * 1. The given array is not null and has length of at least 3
 * 2. No duplicate triples should be returned, order of the values in the tuple does not matter
 * 
 * Examples:
 * A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]
 * 
 * Time: O(n^2)
 * Space: O(logn)
 */
public class ThreeSum {
	public List<List<Integer>> allTriples(int[] array, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(array);
		for (int i = 0; i < array.length - 2; i++) {
			if (i > 0 && array[i] == array[i - 1]) {
				continue;
			}
			int left = i + 1;
			int right = array.length - 1;
			int newTarget = target - array[i];
			while (left < right) {
				int sum = array[left] + array[right];
				if (sum < newTarget) {
					left++;
				} else if (sum == newTarget) {
					List<Integer> item = new ArrayList<>();
					item.add(array[i]);
					item.add(array[left]);
					item.add(array[right]);
					res.add(item);
					left++;
					while (left < right && array[left] == array[left - 1]) {
						left++;
					}
					right--;
				} else {
					right--;
				}
			}
		}
		return res;
	}
}
