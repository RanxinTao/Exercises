package DFS_base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/**
 * Given all valid permutations of l pairs of (), m pairs of <> and n pairs of {}
 * 
 * Assumptions: l, m, n >= 0
 * Examples:
 * 1. l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]
 * 
 * Time: O(2^(l + m + n))
 * Space: O(l + m + n)
 */
public class AllValidPermutationsOfParenthesesII {
	public List<String> validParentheses(int l, int m, int n) {
		char[] ps = {'(', ')', '<', '>', '{', '}'};
		List<String> res = new ArrayList<>();
		helper(new int[] {l, l, m, m, n, n}, new LinkedList<>(), new char[2 * (l + m + n)], 0, res, ps);
		return res;
	}

	private void helper(int[] remain, Deque<Character> stack, char[] cur, int index, List<String> res, char[] ps) {
		if (index == cur.length) {
			res.add(new String(cur));
			return;
		}
		for (int i = 0; i < remain.length; i++) { // iterate all parentheses
			if (i % 2 == 0) { // if it is a left parenthesis
				if (remain[i] > 0) {
					cur[index] = ps[i];
					stack.offerFirst(ps[i]);
					remain[i]--;
					helper(remain, stack, cur, index + 1, res, ps);
					stack.pollFirst();
					remain[i]++;
				}
			} else { // if it is a right parenthesis
				if (!stack.isEmpty() && stack.peekFirst() == ps[i - 1]) {
					cur[index] = ps[i];
					stack.pollFirst();
					remain[i]--;
					helper(remain, stack, cur, index + 1, res, ps);
					stack.offerFirst(ps[i - 1]);
					remain[i]++;
				}
			}
		}
	}

	/*public List<String> validParentheses(int l, int m, int n) {
		// Assumptions: l, m, n >= 0
		List<String> res = new ArrayList<>();
		helper(l, l, m, m, n, n, new LinkedList<>(), new char[2 * (l + m + n)], 0, res);
		return res;
	}

	private void helper(int ll, int lr, int ml, int mr, int nl, int nr, Deque<Character> stack, char[] cur, int index,
			List<String> res) {
		if (index == cur.length) {
			res.add(new String(cur));
			return;
		}
		if (ll > 0) {
			cur[index] = '(';
			stack.offerFirst('(');
			helper(ll - 1, lr, ml, mr, nl, nr, stack, cur, index + 1, res);
			stack.pollFirst();
		}
		if (lr > ll) {
			if (!stack.isEmpty() && stack.peekFirst() == '(') {
				cur[index] = ')';
				stack.pollFirst();
				helper(ll, lr - 1, ml, mr, nl, nr, stack, cur, index + 1, res);
				stack.offerFirst('(');
			}
		}
		if (ml > 0) {
			cur[index] = '[';
			stack.offerFirst('[');
			helper(ll, lr, ml - 1, mr, nl, nr, stack, cur, index + 1, res);
			stack.pollFirst();
		}
		if (mr > ml) {
			if (!stack.isEmpty() && stack.peekFirst() == '[') {
				cur[index] = ']';
				stack.pollFirst();
				helper(ll, lr, ml, mr - 1, nl, nr, stack, cur, index + 1, res);
				stack.offerFirst('[');
			}
		}
		if (nl > 0) {
			cur[index] = '{';
			stack.offerFirst('{');
			helper(ll, lr, ml, mr, nl - 1, nr, stack, cur, index + 1, res);
			stack.pollFirst();
		}
		if (nr > nl) {
			if (!stack.isEmpty() && stack.peekFirst() == '{') {
				cur[index] = '}';
				stack.pollFirst();
				helper(ll, lr, ml, mr, nl, nr - 1, stack, cur, index + 1, res);
				stack.offerFirst('{');
			}
		}
	}*/

	public static void main(String[] args) {
		AllValidPermutationsOfParenthesesII test = new AllValidPermutationsOfParenthesesII();
		System.out.println(test.validParentheses(1, 1, 0));
	}
}
