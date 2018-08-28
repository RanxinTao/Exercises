package DFS_base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Assumptions: l, m, n >= 0
 */
public class AllValidPermutationsOfParenthesesII {
	public List<String> validParentheses(int l, int m, int n) {
		char[] PS = {'(', ')', '[', ']', '{', '}'};
		List<String> res = new ArrayList<>();
		helper(new int[] {l,l,m,m,n,n}, new LinkedList<>(), new char[2 * (l + m + n)], 0, res, PS);
		return res;
	}

	private void helper(int[] remain, Deque<Character> stack, char[] cur, int index, List<String> res, char[] PS) {
		if (index == cur.length) {
			res.add(new String(cur));
			return;
		}
		for (int i = 0; i < remain.length; i++) {
			if (i % 2 == 0) {
				if (remain[i] > 0) {
					cur[index] = PS[i];
					stack.offerFirst(PS[i]);
					remain[i]--;
					helper(remain, stack, cur, index + 1, res, PS);
					stack.pollFirst();
					remain[i]++;
				}
			} else {
				if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
					cur[index] = PS[i];
					stack.pollFirst();
					remain[i]--;
					helper(remain, stack, cur, index + 1, res, PS);
					stack.offerFirst(PS[i - 1]);
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
