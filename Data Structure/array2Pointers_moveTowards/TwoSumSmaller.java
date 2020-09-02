package array2Pointers_moveTowards;

import java.util.Arrays;

/**
 * Determine the number of pairs of elements in a given array that sum to a value smaller than the given target number.
 * 
 * Assumptions:
 * The given array is not null and has length of at least 2
 * 
 * Examples:
 * 1. A = {1, 2, 2, 4, 7}, target = 7, number of pairs is 6({1,2}, {1, 2}, {1, 4}, {2, 2}, {2, 4}, {2, 4})
 */
public class TwoSumSmaller {
	public int smallerPairs(int[] array, int target) {
		int res = 0;
		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			if (array[left] + array[right] < target) {
				res += (right - left);
				left++;
			} else {
				right--;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		TwoSumSmaller test = new TwoSumSmaller();
		int[] array = {1,2,2,4,7};
		int target = 7;
		System.out.println(test.smallerPairs(array, target));
	}
}
