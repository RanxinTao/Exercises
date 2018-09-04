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
		List<Integer> shorter = a;
		List<Integer> longer = b;
		if (a.size() > b.size()) {
			shorter = b;
			longer = a;
		}
		Set<Integer> set = new HashSet<>(shorter);
		for (int num : longer) {
			if (set.contains(num)) {
				res.add(num);
			}
		}
		Collections.sort(res);
		return res;
	}
	
	/*public List<Integer> common(List<Integer> a, List<Integer> b) {
		List<Integer> res = new ArrayList<>();
		List<Integer> shorter = a;
		List<Integer> longer = b;
		if (a.size() > b.size()) {
			shorter = b;
			longer = a;
		}
		Collections.sort(shorter);
		for (int num : longer) {
			if (binarySearch(shorter, num)) {
				res.add(num);
			}
		}
		Collections.sort(res);
		return res;
	}

	private boolean binarySearch(List<Integer> list, int target) {
		int left = 0;
		int right = list.size() - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (list.get(mid) == target) {
				return true;
			} else if (list.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}*/
}
