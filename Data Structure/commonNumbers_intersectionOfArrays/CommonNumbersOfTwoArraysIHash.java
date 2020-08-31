package commonNumbers_intersectionOfArrays;

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
 * 
 * Time: O(ab + aloga), if a is shorter than b
 * Space: O(a), if a is shorter than b
 */
public class CommonNumbersOfTwoArraysIHash {
	public List<Integer> common(int[] a, int[] b) {
		List<Integer> res = new ArrayList<>();	
		if (a.length > b.length) { // assume a is shorter than b, if not, swap a and b
			int[] tmp = a;
			a = b;
			b = tmp;
		}
		Set<Integer> set = new HashSet<>();
		for (int num : a) {
			set.add(num);
		}
		for (int num : b) {
			if (set.contains(num)) {
				res.add(num);
			}
		}
		Collections.sort(res);
		return res;
	}
}
