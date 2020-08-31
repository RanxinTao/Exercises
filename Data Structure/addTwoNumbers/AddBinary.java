package addTwoNumbers;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * Examples:
 * 1. Input: a = "11", b = "1"	Output: "100"
 * 
 * Time: O(a + b)
 * Space: O(a + b)
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder builder = new StringBuilder();
		int carry = 0;
		for (int ai = a.length() - 1, bi = b.length() - 1; ai >= 0 || bi >= 0; ai--, bi--) {
			int sum = (ai >= 0 ? a.charAt(ai) - '0' : 0) + (bi >= 0 ? b.charAt(bi) - '0' : 0) + carry;
			carry = sum / 2;
			sum = sum % 2;
			builder.append(sum);
		}
		if (carry != 0) {
			builder.append(carry);
		}
		builder.reverse();
		return builder.toString();
	}
	
	public static void main(String[] args) {
		AddBinary test = new AddBinary();
		String a = "11";
		String b = "1";
		System.out.println(test.addBinary(a, b));
	}
}
