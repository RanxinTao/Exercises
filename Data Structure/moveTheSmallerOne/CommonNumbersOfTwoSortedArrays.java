package moveTheSmallerOne;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).
 * 
 * Assumptions:
 * 1. In each of the two sorted arrays, there could be duplicate numbers.
 * 2. Both two arrays are not null.
 * 
 * Examples:
 * A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
 */
public class CommonNumbersOfTwoSortedArrays {
	public List<Integer> common(List<Integer> A, List<Integer> B) {
		List<Integer> res = new ArrayList<>();
		int ai = 0;
		int bi = 0;
		while (ai < A.size() && bi < B.size()) {
			if (A.get(ai) == B.get(bi)) {
				res.add(A.get(ai));
				ai++;
				bi++;
			} else if (A.get(ai) < B.get(bi)) {
				ai++;
			} else {
				bi++;
			}
		}
		return res;
	}
}
