package array2Pointers_oppositeDirection;

/**
 * Reverse a given string
 * 
 * Assumptions: input is not null
 * 
 * Time: O(n)
 * Space: O(1), but O(n) in Java
 */
public class ReverseString {
	public String reverse(String input) {
		char[] array = input.toCharArray();
		for (int left = 0, right = array.length - 1; left < right; left++, right--) {
			char tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
		}
		return new String(array);
	}
}
