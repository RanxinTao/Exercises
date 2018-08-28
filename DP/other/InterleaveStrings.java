package other;

/**
 * Given three strings A, B and C. Determine if C can be created by merging A and B in a way that maintains 
 * the relative order of the characters in A and B.
 * 
 * Assumptions: 
 * none of A, B, C is null
 * Examples:
 * C = "abcde", A = "acd", B = "be", return true
 * C = "abcde", A = "adc", B = "be", return false
 */
public class InterleaveStrings {
	public boolean canMerge(String a, String b, String c) {	
		if (a.length() + b.length() != c.length()) {
			return false;
		}
		// indicates if a.substring(0, i) and b.substring(0, j) can be merged to c.substring(0, i + j)
		boolean[][] canMerge = new boolean[a.length() + 1][b.length() + 1];
		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				if (i == 0 && j == 0) {
					canMerge[i][j] = true;
				} else {
					if (i > 0 && a.charAt(i - 1) == c.charAt(i + j - 1)) {
						canMerge[i][j] |= canMerge[i - 1][j];
					}
					if (j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1)) {
						canMerge[i][j] |= canMerge[i][j - 1];
					}
				}
			}
		}
		return canMerge[a.length()][b.length()];
	}

	/*public boolean canMerge(String a, String b, String c) {
		if (a.length() + b.length() != c.length()) {
		  return false;
		}
		return canMerge(a, 0, b, 0, c, 0);
	}

	private boolean canMerge(String a, int ai, String b, int bi, String c, int ci) {
		if (ci == c.length()) {
			return true;
		}
		boolean canMerge = false;
		if (ai < a.length() && a.charAt(ai) == c.charAt(ci)) {
			canMerge |= canMerge(a, ai + 1, b, bi, c, ci + 1);
		}
		if (bi < b.length() && b.charAt(bi) == c.charAt(ci)) {
			canMerge |= canMerge(a, ai, b, bi + 1, c, ci + 1);
		}
		return canMerge;
	}*/

	public static void main(String[] args) {
		InterleaveStrings test = new InterleaveStrings();
		String a = "abgcd";
		String b = "bebgf";
		String c = "babebggcfd";
		System.out.println(test.canMerge(a, b, c));
	}
}
