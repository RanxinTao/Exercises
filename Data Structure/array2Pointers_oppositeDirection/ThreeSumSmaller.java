package array2Pointers_oppositeDirection;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * 
 * Examples:
 * 1. Given nums = [-2, 0, 1, 3], and target = 2. Return 2 because there are two triplets which sums are less than 2:
 * [-2, 0, 1] and [-2, 0, 3]
 */
public class ThreeSumSmaller {
	public int threeSumSmaller(int[] num, int target) {
		int res = 0;
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				if (num[i] + num[left] + num[right] < target) {
					res += (right - left);
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		ThreeSumSmaller test = new ThreeSumSmaller();
		int[] array = {-2, 0, 1, 3};
		int target = 2;
		System.out.println(test.threeSumSmaller(array, target));
	}
}
