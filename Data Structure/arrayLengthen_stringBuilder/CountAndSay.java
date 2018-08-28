package arrayLengthen_stringBuilder;

/**
 * Given a sequence of number: 1, 11, 21, 1211, 111221, бн, The rule of generating the number in the sequence is as follow:
 * 1 is "one 1" so 11, 11 is "two 1s" so 21, 21 is "one 2 followed by one 1" so 1211.
 * Find the nth number in this sequence.
 * 
 * Assumptions: 
 * n starts from 1, the first number is "1", the second number is "11"
 */
public class CountAndSay {
	public String countAndSay(int n) {
		StringBuilder sb = new StringBuilder("1");
		while (n > 1) {
			sb = helper(sb);
			n--;
		}
		return sb.toString();
	}

	private StringBuilder helper(StringBuilder input) {
		StringBuilder output = new StringBuilder();
		char last = input.charAt(0);
		int count = 1;
		for (int i = 1; i < input.length(); i++) {
			char cur = input.charAt(i);
			if (cur == last) {
				count++;
			} else {
				output.append(count);
				output.append(last);
				last = cur;
				count = 1;
			}
		}
		output.append(count);
		output.append(last);
		return output;
	}
}
