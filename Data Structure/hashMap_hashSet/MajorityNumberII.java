package hashMap_hashSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array of length L, find all numbers that occur more than 1/3 * L times if any exist.
 * 
 * Assumptions:
 * The given array is not null
 * Examples:
 * A = {1, 2, 1, 2, 1}, return [1, 2]
 * A = {1, 2, 1, 2, 3, 3, 1}, return [1]
 * A = {1, 2, 2, 3, 1, 3}, return []
 */
public class MajorityNumberII {
	public List<Integer> majority(int[] array) {
		int candidate1 = 0;
		int candidate2 = 0;
		int count1 = 0;
		int count2 = 0;
		for (int num : array) {
			if (num == candidate1) {
				count1++;
			} else if (num == candidate2) {
				count2++;
			} else if (count1 == 0) {
				candidate1 = num;
				count1 = 1;
			} else if (count2 == 0) {
				candidate2 = num;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int num : array) {
			if (num == candidate1) {
				count1++;
			} else if (num == candidate2) {
				count2++;
			}
		}
		List<Integer> res = new ArrayList<>();
		if (count1 > array.length / 3) {
			res.add(candidate1);
		}
		if (count2 > array.length / 3) {
			res.add(candidate2);
		}
		Collections.sort(res);
		return res;
	}
}
