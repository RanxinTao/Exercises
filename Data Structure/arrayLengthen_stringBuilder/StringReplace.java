package arrayLengthen_stringBuilder;
/**
 * Assumptions: 
 * 1. input, s and t are not null.
 * 2. s is not empty
 * Examples:
 * input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
 * input = "dodododo", S = "dod", T = "a", input becomes "aoao"
 */
public class StringReplace {
	public String replace(String input, String s, String t) {
		if (input.length() == 0) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		int fromIndex = 0;
		int matchIndex = input.indexOf(s);
		while (matchIndex != -1) {
			sb.append(input, fromIndex, matchIndex).append(t);
			fromIndex = matchIndex + s.length();
			matchIndex = input.indexOf(s, fromIndex);
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
