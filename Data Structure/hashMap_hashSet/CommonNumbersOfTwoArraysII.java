package hashMap_hashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find all numbers that appear in both of two unsorted arrays.
 * 
 * Assumptions: 
 * 1. Both of the two arrays are not null.
 * 2. In any of the two arrays, there could be duplicate numbers.
 * 
 * Examples:
 * A = {1, 2, 3, 2}, B = {3, 4, 2, 2, 2}, return [2, 2, 3] (there are both two 2s in A and B)
 */
public class CommonNumbersOfTwoArraysII {
	public List<Integer> common(List<Integer> A, List<Integer> B) {
		List<Integer> res = new ArrayList<>();
		List<Integer> shorter = A;
		List<Integer> longer = B;
		if (A.size() > B.size()) {
			shorter = B;
			longer = A;
		}
		Map<Integer, Integer> map = buildMap(shorter);
		for (int num : longer) {
			Integer count = map.get(num);
			if (count != null && count != 0) {
				res.add(num);
				map.put(num, count - 1);
			}
		}
		Collections.sort(res);
		return res;
	}

	private Map<Integer, Integer> buildMap(List<Integer> list) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : list) {
			Integer count = map.get(num);
			if (count == null) {
				map.put(num, 1);
			} else {
				map.put(num, count + 1);
			}
		}
		return map;
	}
	
	public static void main(String[] args) {
		CommonNumbersOfTwoArraysII test = new CommonNumbersOfTwoArraysII();
		List<Integer> A = Arrays.asList(1,2,3,4,5,6,7,8);
		List<Integer> B = Arrays.asList(3,4,2,2,2);
		System.out.println(test.common(A, B));
	}
}
