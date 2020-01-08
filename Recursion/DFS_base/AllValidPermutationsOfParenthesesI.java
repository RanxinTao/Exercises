package DFS_base;

import java.util.ArrayList;
import java.util.List;

/**
 * Given N pairs of parentheses "()", return a list with all the valid permutations.
 * 
 * Assumptions: 
 * N >= 0
 * Examples:
 * 1. N = 1, all valid permutations are ["()"]
 * 2. N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
 * 3. N = 0, all valid permutations are [""]
 * 
 * Time: O(2^n)
 * Space: O(n)
 */
public class AllValidPermutationsOfParenthesesI {
	public List<String> validParentheses(int n) {
		List<String> res = new ArrayList<>();
		validParentheses(n, n, new char[n * 2], 0, res);
		return res;
	}

	private void validParentheses(int leftRemain, int rightRemain, char[] cur, int index, List<String> res) {
		if (leftRemain == 0 && rightRemain == 0) {
			res.add(new String(cur));
			return;
		}
		if (leftRemain > 0) {
			cur[index] = '(';
			validParentheses(leftRemain - 1, rightRemain, cur, index + 1, res);
		}
		if (rightRemain > leftRemain) {
			cur[index] = ')';
			validParentheses(leftRemain, rightRemain - 1, cur, index + 1, res);
		}
	}
}
