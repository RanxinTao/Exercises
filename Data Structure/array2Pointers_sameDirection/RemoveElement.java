package array2Pointers_sameDirection;

/**
 * Given an array and a value, remove all instances of that value in place and return a new array left elements. The
 * order of elements can not be changed.
 * 
 * Examples:
 * Input: [1, 2, 3, 1]
 * Value: 1
 * Output: [2, 3]
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class RemoveElement {
	public int[] removeElement(int[] input, int value) {
		int end = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] != value) {
				input[end] = input[i];
				end++;
			}
		}
		int[] res = new int[end];
		for (int i = 0; i < end; i++) {
			res[i] = input[i];
		}
		return res;
	}
}
