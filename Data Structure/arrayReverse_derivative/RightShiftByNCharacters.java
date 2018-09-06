package arrayReverse_derivative;

/**
 * Assumptions:
 * 1. input is not null
 * 2. n >= 0
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class RightShiftByNCharacters {
	public String rightShift(String input, int n) {
		if (input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		reverse(array, 0, array.length - 1);
		n %= array.length;
		reverse(array, 0, n - 1);
		reverse(array, n, array.length - 1);
		return new String(array);
	}
	
	private void reverse(char[] array, int left, int right) {
		while (left < right) {
			char tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			left++;
			right--;
		}
	}
	
	public static void main(String[] args) {
		RightShiftByNCharacters test = new RightShiftByNCharacters();
		String input = "abcdefg";
		int n = 3;
		System.out.println(test.rightShift(input, n));
	}
	
	/*public String rightShift(String input, int n) {
		if (input.length() <= 1) {
			return input;
		}
		int len = input.length();
		char[] res = new char[len];
		for (int i = 0; i < len; i++) {
			int newIdx = (i + n) % len;
			res[newIdx] = input.charAt(i);
		}
		return new String(res);
	}*/
}
