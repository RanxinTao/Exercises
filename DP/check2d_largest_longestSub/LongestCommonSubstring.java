package check2d_largest_longestSub;

/**
 * Find the longest common substring of two given strings.
 * 
 * Assumptions:
 * The two given strings are not null
 * 
 * Examples:
 * s = "abcde", t = "cdf", the longest common substring of s and t is "cd"
 * 
 * Time: O(st)
 * Space: O(st)
 */
public class LongestCommonSubstring {
	public String longestCommon(String s, String t) {
		int[][] lcs = new int[s.length()][t.length()]; // lcs[i][j] = the length of LCS of s (0 to i, i must include) and t (0 to j, j must include)
		int start = 0; // records the LCS's start position in s
		int longest = 0; // records the longest LCS's length
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < t.length(); j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = s.charAt(i) == t.charAt(j) ? 1 : 0;
				} else {
					lcs[i][j] = s.charAt(i) == t.charAt(j) ? lcs[i - 1][j - 1] + 1 : 0;
				}
				if (lcs[i][j] > longest) {
					longest = lcs[i][j];
					start = i - longest + 1;
				}
			}
		}
		return s.substring(start, start + longest);
	}
	
	public static void main(String[] args) {
		LongestCommonSubstring test = new LongestCommonSubstring();
		String s = "abcde";
		String t = "cdf";
		System.out.println(test.longestCommon(s, t));
	}
}
