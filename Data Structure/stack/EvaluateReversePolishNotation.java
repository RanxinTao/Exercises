package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation
 * 
 * Assumptions:
 * 1. Valid operators are +, -, *, /.
 * 2. Each operand may be an integer or another expression.
 * 
 * Examples:
 * 1. ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * 2. ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Deque<Integer> stack = new ArrayDeque<>();
		for (String token : tokens) {
			if (isOperator(token)) {
				stack.offerFirst(calculate(stack.pollFirst(), stack.pollFirst(), token));
			} else {
				stack.offerFirst(Integer.parseInt(token));
			}
		}
		return stack.peekFirst();
	}
	
	private int calculate(int operand1, int operand2, String operator) {
		switch (operator) {
			case "+": return operand1 + operand2;
			case "-": return operand2 - operand1;
			case "*": return operand1 * operand2;
			case "/": return operand2 / operand1;
			default: return 0;
		}
	}
	
	private boolean isOperator(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
	}
	
	public static void main(String[] args) {
		EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
		String[] tokens = {"0", "12", "4", "+", "-"};
		System.out.println(test.evalRPN(tokens));
	}
}
