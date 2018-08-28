package DFS;
/**
 * Given an array of strings, find if all the strings can be chained to form a circle. Two string s1 and s2 can be chained,
 * iff the last letter of s1 is identical to the first letter of s2. For example, "abc" and "cd" can be chained, "abc" and
 * "dz" can not be chained.
 * 
 * Examples:
 * Input: arr[] = {"aaa", "bbb", "baa", "aab"}, Output: True
 * The given input strings can be chained to form a circle. The strings can be chained as "aaa", "aab", "bbb", and "baa"
 */
public class ChainedToCircle {
	public boolean canBeChainedToCircle(String[] input) {
		if (input == null || input.length == 0) {
			return false;
		}
		return helper(input, 0);
	}

	private boolean helper(String[] input, int index) {
		if (index == input.length) {
			String first = input[0];
			String last = input[input.length - 1];
			return canBeChained(last, first);
		}
		for (int i = index; i < input.length; i++) {
			String cur = input[i];
			if (index == 0 || canBeChained(input[index - 1], cur)) {
				swap(input, index, i);
				if (helper(input, index + 1)) {
					return true;
				}
				swap(input, index, i);
			}
		}
		return false;
	}
	
	private boolean canBeChained(String s1, String s2) {
		return s1.charAt(s1.length() - 1) == s2.charAt(0);
	}

	private void swap(String[] input, int i, int j) {
		String tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
	
	public static void main(String[] args) {
		//String[] input = {"aaa", "bbb", "baa", "aab"};
		String[] input = {"aba"};
		ChainedToCircle test = new ChainedToCircle();
		System.out.println(test.canBeChainedToCircle(input));
	}
}
