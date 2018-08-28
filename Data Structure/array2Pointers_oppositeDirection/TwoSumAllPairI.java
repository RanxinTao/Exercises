package array2Pointers_oppositeDirection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find all pairs of elements in a given array that sum to the given target number. Return all the pairs of indices.
 * 
 * Assumptions:
 * The given array is not null and has length of at least 2.
 * Examples:
 * A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]
 * A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]
 */
public class TwoSumAllPairI {
	public List<List<Integer>> allPairs(int[] array, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			int diff = target - array[i];
			List<Integer> indices = map.get(diff);
			if (indices != null) {
				for (int j : indices) {
					List<Integer> item = new ArrayList<>();
					item.add(i);
					item.add(j);
					res.add(item);
				}
			}
			indices = map.get(array[i]);
			if (indices == null) {
				indices = new ArrayList<>();
				indices.add(i);
				map.put(array[i], indices);
			} else {
				indices.add(i);
			}
		}
		return res;
	}
}
