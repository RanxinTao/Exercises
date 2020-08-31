package array1Pointer;

/**
 * Given a nested list of integers represented by a string without blank, parse the string and return
 * the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Note: there can be negative numbers.
 * 
 * Examples:
 * 1. Given the list "[[1,1],2,[1,1]", return 10. (four 1's at depth 2, one 2 at depth 1)
 * 2. Given the list "[1,[4,[6]]]", return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth
 * 3; 1 + 4 * 2 + 6 * 3 = 27)
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class NestedListWeightSum {
	public int depthSum(String nestlists) {
		int res = 0;
		int depth = 0;
		int num = 0;
		boolean negative = false;
		for (int i = 0; i < nestlists.length(); i++) {
			char cur = nestlists.charAt(i);
			if (cur == '[') {
				depth++;
			} else if (cur == ']') {
				res = negative ? res - num * depth : res + num * depth;
				num = 0;
				depth--;
				negative = false;
			} else if (Character.isDigit(cur)){
				num = num * 10 + cur - '0';
			} else if (cur == ',') {
				res = negative ? res - num * depth : res + num * depth;
				num = 0;
				negative = false;
			} else { // cur == '-'
				negative = true;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		NestedListWeightSum test = new NestedListWeightSum();
		//String nestlists = "[[1,1],2,[1,1]"; // 10
		//String nestlists = "[1,[4,[6]]]"; // 27
		//String nestlists = "[[[18,20],4]]";
		String nestlists = "[-1]";
		System.out.println(test.depthSum(nestlists));
	}
}
