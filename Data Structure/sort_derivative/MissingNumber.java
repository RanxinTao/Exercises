package sort_derivative;

import impl.Utils;

/**
 * Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.
 * 
 * Assumptions:
 * The given array is not null, and N >= 1
 * 
 * Examples:
 * A = {2, 1, 4}, the missing number is 3
 * A = {1, 2, 3}, the missing number is 4
 * A = {}, the missing number is 1
 * 
 * Algorithm: Bucket sort
 * Time: O(n)
 * Space: O(1)
 */
public class MissingNumber {
	public int missing(int[] array) {
		// try to swap the numbers to its corresponding position. For the number x, the corresponding position is x - 1.
		for (int i = 0; i < array.length; i++) {
			// while array[i] is not i + 1, swap array[i] to its correct position if possible.
			while (array[i] != i + 1 && array[i] - 1 != array.length) {
				swap(array, i, array[i] - 1);
			}
		}
		// if the missing number is in range of 1 to n - 1, then it is at index i where array[i] != i + 1
		for (int i = 0; i < array.length; i++) {
			if (array[i] != i + 1) {
				return i + 1;
			}
		}
		// if all the numbers of 1 to n - 1 are in position, the missing number is n
		return array.length + 1;
	}
	
	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void main(String[] args) {
		MissingNumber test = new MissingNumber();
		int[] array = {2,1,3,6,4};
		System.out.println(test.missing(array));
		Utils.printArray(array);
	}
}
