package array2Pointers_oppositeDirection;

/**
 * Assumptions: input is not null
 */
public class ReverseString {
	public String reverse(String input) {
		if (input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		for (int left = 0, right = array.length - 1; left < right; left++, right--) {
			char tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
		}
		return new String(array);
	}
}
