package other;

/**
 * Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert 
 * operations needed to transform one string into the other.
 * 
 * Assumptions: both strings are not null
 * Examples:
 * string one: ¡°sigh¡±, string two : ¡°asith¡±
 * the edit distance between one and two is 2 (one insert ¡°a¡± at front then replace ¡°g¡± with ¡°t¡±).
 */
public class EditDistance {
	public int editDistance(String one, String two) {
		// dp[i][j] represents substring(0, i) in one and substring(0, j) in two
		int[][] dp = new int[one.length() + 1][two.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (one.charAt(i - 1) == two.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
			}
		}
		return dp[one.length()][two.length()];
	}
	
	public static void main(String[] args) {
		EditDistance test = new EditDistance();
		String one = "sigh";
		String two = "asith";
		System.out.println(test.editDistance(one, two));
	}
}
