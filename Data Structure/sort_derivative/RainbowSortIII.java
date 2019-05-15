package sort_derivative;

/**
 * Given an array of balls with k different colors denoted by numbers 1 to k, sort the balls.
 * 
 * Assumptions:
 * 1. The input array is not null.
 * 2. k is guaranteed to be >= 1 and k << logn.
 * 
 * Examples:
 * k = 1, {1} is sorted to {1}
 * k = 3, {1, 3, 2, 1, 2} is sorted to {1, 1, 2, 2, 3}
 * k = 5, {3, 1, 5, 5, 1, 4, 2} is sorted to {1, 1, 2, 3, 4, 5, 5}
 * 
 * Algorithm: Counting sort
 */
public class RainbowSortIII {
	public int[] rainbowSort(int[] array, int k) {
		int[] counts = new int[k];
		for (int num : array) {
			counts[num - 1]++;
		}
		int index = 0;
		for (int i = 0; i < counts.length; i++) {
			int count = counts[i];
			while (count > 0) {
				array[index] = i + 1;
				index++;
				count--;
			}
		}
		return array;
	}
}
