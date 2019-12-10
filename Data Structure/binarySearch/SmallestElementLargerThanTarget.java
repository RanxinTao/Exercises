package binarySearch;

/**
 * Given a target integer T and an integer array A sorted in ascending order, find the index of the smallest element in
 * A that is larger than T or return -1 if there is no such index. 
 * 
 * Assumptions:
 * There can be duplicate elements in the array
 * 
 * Examples:
 * 1. A = {1, 2, 3}, T = 1, return 1
 * 2. A = {1, 2, 3}, T = 3, return -1
 * 3. A = {1, 2, 2, 2, 3}, T = 1, return 1
 * 
 * Time: O(logn)
 * Space: O(1)
 */
public class SmallestElementLargerThanTarget { // compared to lastOccurrence
	public int smallestElementLargerThanTarget(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left < array.length ? left : -1;
	}
	
	public static void main(String[] args) {
		SmallestElementLargerThanTarget test = new SmallestElementLargerThanTarget();
		int[] array = {1,2,2,2,3};
		int target = 1;
		System.out.println(test.smallestElementLargerThanTarget(array, target));
	}
}
