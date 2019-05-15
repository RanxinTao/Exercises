package arrays_nPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all common elements in 3 sorted arrays.
 * 
 * Assumptions:
 * 1. The 3 given sorted arrays are not null.
 * 2. There could be duplicate elements in each of the arrays.
 * 
 * Examples:
 * A = {1, 2, 2, 3}, B = {2, 2, 3, 5}, C = {2, 2, 4}, the common elements are [2, 2]
 * 
 * Time: O(a + b + c) where a, b, c is the length of array a, array b, array c respectively
 * Space: O(1)
 */
public class CommonElementsInThreeSortedArrays {
	public List<Integer> common(int[] a, int[] b, int[] c) {
		List<Integer> res = new ArrayList<>();
		int ai = 0;
		int bi = 0;
		int ci = 0;
		while (ai < a.length && bi < b.length && ci < c.length) {
			if (a[ai] == b[bi] && a[ai] == c[ci]) {
				res.add(a[ai]);
				ai++;
				bi++;
				ci++;
			} else if (a[ai] <= b[bi] && a[ai] <= c[ci]) { // case 1: a is the smallest
				ai++;
			} else if (b[bi] <= a[ai] && b[bi] <= c[ci]) { // case 2: b is the smallest
				bi++;
			} else { // case 3: c is the smallest
				ci++;
			}
		}
		return res;
	}
}
