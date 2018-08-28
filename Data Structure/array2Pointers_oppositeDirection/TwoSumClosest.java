package array2Pointers_oppositeDirection;

import java.util.Arrays;
import java.util.List;

/**
 * Find the pair of elements in a given array that sum to a value that is closest to the given target number. 
 * Return the values of the two numbers.
 * 
 * Assumptions:
 * The given array is not null and has length of at least 2
 * Examples:
 * A = {1, 4, 7, 13}, target = 7, closest pair is 1 + 7 = 8, return [1, 7].
 */
public class TwoSumClosest {
	public List<Integer> closest(int[] array, int target) {
		List<Integer> res = null;
		Arrays.sort(array);
		int minDiff = Integer.MAX_VALUE;
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int sum = array[left] + array[right];
			if (sum == target) {
				res = Arrays.asList(array[left], array[right]);
				return res;
			} else {
				int diff = Math.abs(target - sum);
				if (diff < minDiff) {
					minDiff = diff;
					res = Arrays.asList(array[left], array[right]);
				}
				if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		TwoSumClosest test = new TwoSumClosest();
		int[] array = {1,4,7,13};
		int target = 7;
		System.out.println(test.closest(array, target));
	}
}
