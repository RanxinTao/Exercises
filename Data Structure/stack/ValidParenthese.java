package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[', ']', determine if the input
 * string is valid. The brackets must close in the correct order.
 * characters.
 * 
 * Examples:
 * 1. "()", "()[]{}", and "[{()}()]" are all valid.
 * 2. "(]" and "([)]" are not valid.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class ValidParenthese {
	public boolean isValid(String input) {
		Deque<Character> stack = new LinkedList<>();
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			if (cur == '(' || cur == '[' || cur == '{') {
				stack.offerFirst(cur);
			} else if (stack.isEmpty()) { // Don't forget to check empty here!
				return false;
			} else {
				char prev = stack.pollFirst();
				if (!match(prev, cur)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	private boolean match(char l, char r) {
		return (l == '(' && r == ')') || (l == '[' && r == ']') || (l == '{' && r == '}');
	}
	
	public static void main(String[] args) {
		ValidParenthese test = new ValidParenthese();
		String input = "))(";
		System.out.println(test.isValid(input));
	}
}
