package array2Pointers_moveTowards;

/**
 * Given an bianry matrix of N * N (the only elements in the matrix are 0s and 1s), each of the indices
 * represents one person.
 * matrix[i][j] = 1 if and only if person i knows person j (this is single direction, only if matrix[j][i] = 1
 * such that person j knows person i).
 * Determine if there is one celebrity among all N persons, a celebrity is defined as:
 * 1. He does not know any other person.
 * 2. All the other persons know him.
 * Return the celebrity's index, if there exist one (there could be at most one celebrity, why?), return -1
 * otherwise.
 * 
 * Assumptions:
 * 1. The given matrix is not null and N >= 2.
 * 
 * Examples:
 * 1. matrix = {{0, 1, 1},
 *              {0, 0, 0},
 *              {1, 1, 0}}
 * The celebrity is person 1, since person 0 and person 2 all know him, but person 1 does not know person 0
 * or person 2
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class CelebrityProblem {
	public int celebrity(int[][] matrix) {
		int n = matrix.length;
		int l = 0;
		int r = n - 1;
		while (l < r) {
			if (knows(l, r, matrix)) { // i knows j
				l++; // if i knows j, i cannot be the celebrity
			} else { // l does not know r
				r--; // if l does not know r, r cannot be the celebrity
			}
		} // so far, there is only 1 person left, which is l or r (doesn't matter because l == r now). All other people have been excluded.
		for (int i = 0; i < n; i++) { // However, l does not have to be the celebrity, so we need to verify
			if (i != l && (knows(l, i, matrix) || !knows(i, l, matrix))) { // if l knows i or i does not know l, then there is no celebrity
				return -1;
			}
		}
		return l;
	}
	
	private boolean knows(int i, int j, int[][] matrix) { // return if person i knows person j
		return matrix[i][j] == 1;
	}
}
