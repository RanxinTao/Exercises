package array2Pointers_moveTowards;

/**
 * Given a non-negative integer array representing the heights of a list of adjacent bars. 
 * Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the 
 * histogram.
 * 
 * Assumptions:
 * The given array is not null
 * 
 * Examples:
 * {2, 1, 3, 2, 4}, the amount of water can be trapped is 1 + 1 = 2 (at index 1, 1 unit of water 
 * can be trapped and index 3, 1 unit of water can be trapped)
 * 
 * Time: O(n)
 * Space: O(1)
 * 
 * Reference: https://www.cnblogs.com/grandyang/p/4402392.html provides an easier solution but we
 * need to traverse two passes.
 * 
 * Note: this problem is also in the topic
 */
public class MaxWaterTrappedI {
	public int maxTrapped(int[] array) {
		int res = 0;
		int left = 0;
		int right = array.length - 1;
		while (left + 1 < right) { // It needs at least 3 bars to trap water
			if (array[left] < array[right]) {
				int min = array[left]; // bottle neck
				left++;
				while (left < right && array[left] < min) { // as long as there is a bottle neck in the left, no matter how high a bar exists
					res += (min - array[left]); // in the middle, the water trapped is still limited by the bottle neck in the left
					left++;
				}
			} else {
				int min = array[right];
				right--;
				while (left < right && array[right] < min) {
					res += (min - array[right]);
					right--;
				}
			}
		}
		return res;
	}
}
