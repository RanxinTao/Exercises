package commonNumbers_intersectionOfArrays;

import java.util.ArrayList;
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
 * 
 * Time: O(a + b), if the result does not have to be sorted
 * Space: O(min(a, b))
 */
public class CommonNumbersOfTwoArraysII {
	public List<Integer> common(int[] A, int[] B) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> countA = buildMap(A);
		for (int num : B) {
			int count = countA.getOrDefault(num, 0);
			if (count > 0) {
				res.add(num);
				countA.put(num, count - 1);
			}
		}
		Collections.sort(res);
		/*int[] resArr = new int[res.size()];
		for (int i = 0; i < res.size(); i++) { // use this to return an array, there is no built-in method to convert a primitive array list to array
			resArr[i] = res.get(i);
		}*/
		return res;
	}

	private Map<Integer, Integer> buildMap(int[] nums) {
		Map<Integer, Integer> res = new HashMap<>();
		for (int num : nums) {
			res.put(num, res.getOrDefault(num, 0) + 1);
		}
		return res;
	}
	
	public static void main(String[] args) {
		CommonNumbersOfTwoArraysII test = new CommonNumbersOfTwoArraysII();
		int[] A = {1, 2, 2, 3, 4, 5, 6, 7, 8};
		int[] B = {3, 4, 2, 2, 2};
		System.out.println(test.common(A, B));
	}
}
