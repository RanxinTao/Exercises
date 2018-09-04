package hashMap_hashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<Integer, Integer> countA = new HashMap<>();
		for (int num : A) {
			Integer count = countA.get(num);
			if (count != null) {
				countA.put(num, count + 1);
			} else {
				countA.put(num, 1);
			}
		}
		for (int num : B) {
			Integer count = countA.get(num);
			if (count != null && count > 0) {
				res.add(num);
				if (--count == 0) {
					countA.remove(num);
				} else {
					countA.put(num, count);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(1, 1, 2, 4, 4, 6, 6, 6);
		List<Integer> b = Arrays.asList(1, 3, 5, 5, 6, 6);
		CommonNumbersOfTwoSortedArrays test = new CommonNumbersOfTwoSortedArrays();
		System.out.println(test.common(a, b));
	}
}
