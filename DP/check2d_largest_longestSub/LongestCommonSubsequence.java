package check2d_largest_longestSub;

/**
 * Find the length of longest common subsequence of two given strings.
 * 
 * Assumptions:
 * s and t are not null
 * Examples:
 * s = ¡°abcde¡±, t = ¡°cbabdfe¡±, the longest common subsequence of s and t is {¡®a¡¯, ¡®b¡¯, ¡®d¡¯, ¡®e¡¯}, the length is 4.
 */
public class LongestCommonSubsequence {
	public int longest(String s, String t) {
		if (s.length() == 0 || t.length() == 0) {
			return 0;
		}
		// indicates the length of longest common substring for s (0 to i) and t (0 to j)
		int[][] lcs = new int[s.length()][t.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < t.length(); j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = s.charAt(i) == t.charAt(j) ? 1 : 0;
				} else {
					lcs[i][j] = s.charAt(i) == t.charAt(j) ? lcs[i - 1][j - 1] + 1 : Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		return lcs[s.length() - 1][t.length() - 1];
	}
	
	public static void main(String[] args) {
		LongestCommonSubsequence test = new LongestCommonSubsequence();
		String s = "e";
		String t = "e";
		System.out.println(test.longest(s, t));
	}
	
	/*public int longest(String s, String t) {
		if (s.length() == 0 || t.length() == 0) {
			return 0;
		}
		return longest(s, s.length() - 1, t, t.length() - 1, new HashMap<Integer, Integer>());
	}

	private int longest(String s, int si, String t, int ti, Map<Integer, Integer> cache) {
		if (si < 0 || ti < 0) {
			return 0;
		}
		int key = getKey(si, ti, t.length());
		if (cache.containsKey(key)) {
			return cache.get(key);
		} else {
			int maxLen = 0;
			if (s.charAt(si) == t.charAt(ti)) {
				maxLen = longest(s, si - 1, t, ti - 1, cache) + 1;
			} else {
				maxLen = Math.max(longest(s, si - 1, t, ti, cache), longest(s, si, t, ti - 1, cache));
			}
			cache.put(key, maxLen);
			return maxLen;
		}
	}

	private int getKey(int si, int ti, int t_len) {
		return si * t_len + ti;
	}*/
}
