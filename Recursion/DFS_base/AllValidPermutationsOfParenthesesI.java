package DFS_base;

import java.util.ArrayList;
import java.util.List;

/**
 * Assumptions: n >= 0
 */
public class AllValidPermutationsOfParenthesesI {
	public List<String> validParentheses(int n) {
		List<String> res = new ArrayList<>();
		helper(n, n, new char[n * 2], 0, res);
		return res;
	}

	private void helper(int l, int r, char[] cur, int index, List<String> res) {
		if (l == 0 && r == 0) {
			res.add(new String(cur));
			return;
		}
		if (l > 0) {
			cur[index] = '(';
			helper(l - 1, r, cur, index + 1, res);
		}
		if (r > l) {
			cur[index] = ')';
			helper(l, r - 1, cur, index + 1, res);
		}
	}
}
