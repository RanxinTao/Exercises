package hashMap_hashSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array of length L, find all numbers that occur more than 1/K * L times if any exist.
 * 
 * Assumptions:
 * 1. The given array is not null or empty
 * 2. K >= 2
 * Examples:
 * A = {1, 2, 1, 2, 1}, K = 3, return [1, 2]
 * A = {1, 2, 1, 2, 3, 3, 1}, K = 4, return [1, 2, 3]
 * A = {2, 1}, K = 2, return []
 */
public class MajorityNumberIII {
	public List<Integer> majority(int[] array, int k) {
		Map<Integer, Integer> counts = new HashMap<>();
		for (int num : array) {
			Integer count = counts.get(num);
			if (count == null) {
				counts.put(num, 1);
			} else {
				counts.put(num, count + 1);
			}
		}
		List<Integer> res = new ArrayList<>();
		for (int candidate : counts.keySet()) {
			int count = counts.get(candidate);
			if (count > array.length / k) {
				res.add(candidate);
			}
		}
		return res;
	}
}
