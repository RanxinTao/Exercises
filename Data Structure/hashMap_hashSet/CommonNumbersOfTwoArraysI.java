package hashMap_hashSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find all numbers that appear in both of the two unsorted arrays, return the common numbers in increasing order.
 *
 * Assumptions:
 * 1. Both arrays are not null.
 * 2. There are no duplicate numbers in each of the two arrays respectively.
 * 
 * Examples:
 * A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
 * A = {}, B = {3, 1, 4}, return []
 */
public class CommonNumbersOfTwoArraysI {
	public List<Integer> common(List<Integer> a, List<Integer> b) {
		List<Integer> res = new ArrayList<>();
		// assume a is shorter than b, if not, swap a and b
		if (a.size() > b.size()) {
			List<Integer> tmp = a;
			a = b;
			b = tmp;
		}
		Set<Integer> set = new HashSet<>(a);
		for (int num : b) {
			if (set.contains(num)) {
				res.add(num);
			}
		}
		Collections.sort(res);
		return res;
	}
}
