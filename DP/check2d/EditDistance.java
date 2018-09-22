package check2d;

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
		// minDist[i][j] represents the minimum edit distance to transform substring(0, i) of one to substring(0, j) of two
		int[][] minDist = new int[one.length() + 1][two.length() + 1];
		for (int i = 0; i < minDist.length; i++) {
			for (int j = 0; j < minDist[0].length; j++) {
				if (i == 0) {
					minDist[i][j] = j;
				} else if (j == 0) {
					minDist[i][j] = i;
				} else if (one.charAt(i - 1) == two.charAt(j - 1)) {
					minDist[i][j] = minDist[i - 1][j - 1];
				} else {
					minDist[i][j] = Math.min(minDist[i - 1][j - 1], Math.min(minDist[i - 1][j], minDist[i][j - 1])) + 1;
				}
			}
		}
		return minDist[one.length()][two.length()];
	}
	
	public static void main(String[] args) {
		EditDistance test = new EditDistance();
		String one = "sigh";
		String two = "asith";
		System.out.println(test.editDistance(one, two));
	}
}
