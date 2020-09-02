package subarraySum;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, determine whether there exists a contiguous sub-array in the array, which sums
 * to a target number.
 * 
 * Assumptions:
 * 1. The given array is not null and its length is > 0.
 * 
 * Examples:
 * 1. array = {1, 5, 2, 3}, target = 10, return true since the sum of subarray {5, 2, 3} is 10
 * 2. array = {1, 5, 2, 3}, target = 4, return false.
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class SubarraySumToTarget {
	public boolean sumToTarget(int[] array, int target) {
		Set<Integer> prefixSums = new HashSet<>();
		prefixSums.add(0); // always add 0 to prefix sums first
		int sum = 0;
		for (int i = 0; i < array.length; i++) {	
			sum += array[i];
			int diff = sum - target; // target + a prefix sum if exists should be = sum
			if (prefixSums.contains(diff)) { // check if such prefix sum exists
				return true;
			}
			prefixSums.add(sum); // must be added at last, in case target = 0, diff will be = sum, if added to set before, will always return true
		}
		return false;
	}
	
	public static void main(String[] args) {
		SubarraySumToTarget test = new SubarraySumToTarget();
		int[] array = {1, 2, 4, 8, 16};
		int target = 0;
		System.out.println(test.sumToTarget(array, target));
	}
}
