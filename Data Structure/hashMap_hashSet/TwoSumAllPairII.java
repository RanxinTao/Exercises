package hashMap_hashSet;

import java.util.ArrayList;
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
 * 
 * Examples:
 * A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class TwoSumAllPairII {
	public List<List<Integer>> allPairs(int[] array, int target) {
		Set<Integer> set = new HashSet<>();
		Set<List<Integer>> res = new HashSet<>();
		for (int num : array) {
			int diff = target - num;
			if (set.contains(diff)) {
				List<Integer> item = new ArrayList<>();
				item.add(num);
				item.add(diff);
				res.add(item); // will automatically deduplicate
			} else {
				set.add(num);
			}
		}
		return new ArrayList<>(res); // convert set to list
	}
}
