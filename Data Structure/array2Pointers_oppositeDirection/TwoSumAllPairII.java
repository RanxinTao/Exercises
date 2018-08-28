package array2Pointers_oppositeDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find all pairs of elements in a given array that sum to the pair the given target number. 
 * Return all the distinct pairs of values.
 * 
 * Assumptions:
 * The given array is not null and has length of at least 2.
 * The order of the values in the pair does not matter.
 * Examples:
 * A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
 */
public class TwoSumAllPairII {
	/*public List<List<Integer>> allPairs(int[] array, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		Set<List<Integer>> resultSet = new HashSet<>();
		for (int num : array) {
			int diff = target - num;
			if (set.contains(diff)) {
				List<Integer> item = new ArrayList<>();
				item.add(num);
				item.add(diff);
				dedup(item, resultSet);
			} else {
				set.add(num);
			}
		}
		// convert set to list
		for (List<Integer> item : resultSet) {
			res.add(item);
		}
		return res;
	}

	private void dedup(List<Integer> item, Set<List<Integer>> resultSet) {
		Collections.sort(item);
		resultSet.add(item);
	}*/
	
	public List<List<Integer>> allPairs(int[] array, int target) {
		Arrays.sort(array);
		List<List<Integer>> res = new ArrayList<>();
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int sum = array[left] + array[right];
			if (sum == target) {
				List<Integer> item = new ArrayList<>();
				item.add(array[left]);
				item.add(array[right]);
				res.add(item);
				left++;
				// ignore all the consecutive duplicate values when we want to determine the smaller element of the pair
				while (left < right && array[left] == array[left - 1]) {
					left++;
				}
				right--;
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return res;
	}
}
