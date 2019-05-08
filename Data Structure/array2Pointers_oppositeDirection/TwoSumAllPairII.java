package array2Pointers_oppositeDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all pairs of elements in a given array that sum to the pair the given target number. 
 * Return all the distinct pairs of values.
 * 
 * Assumptions:
 * 1. The given array is not null and has length of at least 2.
 * 2. The order of the values in the pair does not matter.
 * 
 * Examples:
 * A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
 * 
 * Time: O(nlogn)
 * Space: O(logn)
 */
public class TwoSumAllPairII {	
	public List<List<Integer>> allPairs(int[] array, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int sum = array[left] + array[right];
			if (sum < target) {
				left++;
			} else if (sum == target) {
				List<Integer> item = new ArrayList<>();
				item.add(array[left]);
				item.add(array[right]);
				res.add(item);
				left++;
				while (left < right && array[left] == array[left - 1]) { // ignore all the consecutive duplicate values
					left++;
				}
				right--;
			} else {
				right--;
			}
		}
		return res;
	}
}
