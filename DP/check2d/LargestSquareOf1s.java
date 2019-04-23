package check2d;

/**
 * Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), 
 * return the length of the largest square.
 * 
 * Assumptions: matrix is not null and has size of N * N, N >= 0
 * Examples:
 * {{0, 0, 0, 0},
 *  {1, 1, 1, 1},
 *  {0, 1, 1, 1},
 *  {1, 0, 1, 1}}
 * the largest square of 1s has length of 2
 * 
 * Time: O(n^2)
 * Space: O(n^2)
 */
public class LargestSquareOf1s {
	public int largest(int[][] matrix) {
		int n = matrix.length;		
		int[][] largest = new int[n][n]; // largest[i][j] means the largest square of 1s with right bottom corner as matrix[i][j]
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					largest[i][j] = matrix[i][j];
				} else if (matrix[i][j] == 1) {
					largest[i][j] = Math.min(largest[i - 1][j - 1], Math.min(largest[i][j - 1], largest[i - 1][j])) + 1;
				}
				maxLen = Math.max(maxLen, largest[i][j]); //update result
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		LargestSquareOf1s test = new LargestSquareOf1s();
		int[][] matrix = {{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {1, 0, 1, 1}};
		System.out.println(test.largest(matrix));
	}
}
