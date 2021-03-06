package commonNumbers_intersectionOfArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find all numbers that appear in both of the two unsorted arrays, return the common numbers in increasing order.
 *
 * Assumptions:
 * 1. Both arrays are not null.
 * 2. There are no duplicate numbers in each of the two arrays respectively.
 * 
 * Examples:
 * 1. A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
 * 2. A = {}, B = {3, 1, 4}, return []
 * 
 * Time: O(blogb + alogb + aloga) < O(2blogb + alogb) = O((a + 2b)logb), if a is shorter than b
 * Space: O(logb), if a is shorter than b
 */
public class CommonNumbersOfTwoArraysIBinarySearch {
	public List<Integer> common(List<Integer> a, List<Integer> b) {
		List<Integer> res = new ArrayList<>();
		if (a.size() > b.size()) { // assume a is shorter than b, if not, swap a and b
			List<Integer> tmp = a;
			a = b;
			b = tmp;
		}
		Collections.sort(b);
		for (int num : a) {
			if (binarySearch(b, num)) {
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
	}
}
