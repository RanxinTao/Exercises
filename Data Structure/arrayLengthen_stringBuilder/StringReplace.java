package arrayLengthen_stringBuilder;
/**
 * Given an original string input, and two strings S and T, replace all occurrences of S in input with T.
 * 
 * Assumptions: 
 * 1. input, S and T are not null
 * 2. S is not empty string
 * 
 * Examples:
 * 1. input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
 * 2. input = "dodododo", S = "dod", T = "a", input becomes "aoao"
 * 
 * Time: O(st) from indexOf()
 * Space: O(1), but O(s + occurrence * t) in Java
 */
public class StringReplace {
	public String replace(String input, String source, String target) {
		StringBuilder sb = new StringBuilder();
		int fromIndex = 0;
		int matchIndex = input.indexOf(source);
		while (matchIndex != -1) {
			sb.append(input, fromIndex, matchIndex).append(target);
			fromIndex = matchIndex + source.length();
			matchIndex = input.indexOf(source, fromIndex);
		}
		sb.append(input, fromIndex, input.length());
		return sb.toString();
	}
	
	public static void main(String[] args) {
		StringReplace test = new StringReplace();
		String input = "appledogapple";
		String s = "apple";
		String t = "cat";
		System.out.println(test.replace(input, s, t));
	}
}
