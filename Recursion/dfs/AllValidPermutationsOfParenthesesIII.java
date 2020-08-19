package dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/**
 * Given all valid permutations of l pairs of (), m pairs of <> and n pairs of {}, subject to the priority restriction:
 * {} higher than <> higher than ().
 * 
 * Assumptions: 
 * 1. l, m, n >= 0
 * 2. l + m + n > 0
 * 
 * Examples:
 * 1. l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "<()>", "<>()"].
 * 2. l = 2, m = 0, n = 1, all the valid permutations are ["()(){}", "(){()}", "(){}()", "{()()}", "{()}()", "{}()()"].
 * 
 * Time: O(2^(l + m + n))
 * Space: O(l + m + n)
 */
public class AllValidPermutationsOfParenthesesIII {
	private static final char[] PS = {'(', ')', '<', '>', '{', '}'};
	
	public List<String> validParentheses(int l, int m, int n) {
		List<String> res = new ArrayList<>();
		char[] remain = new char[2 * (l + m + n)];
		addParenAtIdx(new int[] {l, l, m, m, n, n}, new LinkedList<>(), remain, 0, res);
		return res;
	}

	private void addParenAtIdx(int[] remain, Deque<Character> stack, char[] cur, int index, List<String> res) {
		if (index == cur.length) {
			res.add(new String(cur));
			return;
		}
		for (int i = 0; i < remain.length; i++) { // iterate all parentheses
			if (i % 2 == 0) { // if it is a left parenthesis
				if (remain[i] > 0 && (stack.isEmpty() || getPriority(stack.peekFirst()) > getPriority(PS[i]))) {
					cur[index] = PS[i];
					stack.offerFirst(PS[i]);
					remain[i]--;
					addParenAtIdx(remain, stack, cur, index + 1, res);
					stack.pollFirst();
					remain[i]++;
				}
			} else { // if it is a right parenthesis
				if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
					cur[index] = PS[i];
					stack.pollFirst();
					remain[i]--;
					addParenAtIdx(remain, stack, cur, index + 1, res);
					stack.offerFirst(PS[i - 1]);
					remain[i]++;
				}
			}
		}
	}
	
	private int getPriority(char left) { // return the priority of the left parenthesis: { = 3, < = 2, ( = 1
		switch (left) {
			case '{': return 3;
			case '<': return 2;
			case '(': return 1;
			default: return 0;
		}
	}

	public static void main(String[] args) {
		AllValidPermutationsOfParenthesesIII test = new AllValidPermutationsOfParenthesesIII();
		System.out.println(test.validParentheses(2, 0, 1));
	}
}
