package DFS_iterative;

public class InsertEmptySpaces {
	public void printAllPermutations(char[] str) {
		if (str == null || str.length == 0) {
			return;
		}
		helper(new StringBuilder(), str, 0);
	}

	private void helper(StringBuilder sb, char[] str, int level) {
		if (level == str.length - 1) {
			sb.append(str[level]);
			System.out.println(sb.toString());
			sb.deleteCharAt(sb.length() - 1);
			return;
		}
		sb.append(str[level]);
		sb.append(' ');
		helper(sb, str, level + 1);
		sb.deleteCharAt(sb.length() - 1);
		helper(sb, str, level + 1);
		sb.deleteCharAt(sb.length() - 1);
	}
	
	public static void main(String[] args) {
		InsertEmptySpaces test = new InsertEmptySpaces();
		char[] str = "ABC".toCharArray();
		test.printAllPermutations(str);
	}
}
