package check2d;

/**
 * There is a robot on top left corner of the matrix, it can only move down or right. The matrix is represented by either 0 (path) or 
 * 1 (obstacle). For obstacle, robot can not move through. Find the number of possible ways for robot to move to right down corner.
 * 
 * Examples:
 * 1. Input: [
 *   [0, 0, 0],
 *   [0, 1, 0],
 *   [0, 0, 0]
 * ]
 * Output: 2
 * 
 * Time: O(mn)
 * Space: O(mn)
 */
public class PossiblePathsWithObstacles {
	public int possiblepath(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] nPaths = new int[row][col];
		nPaths[row - 1][col - 1] = matrix[row - 1][col - 1] == 1 ? 0 : 1;
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				if (i == row - 1 && j == col - 1) {
					continue;
				} else if (i == row - 1) {
					nPaths[i][j] = matrix[i][j] == 0 ? nPaths[i][j + 1] : 0;
				} else if (j == col - 1) {
					nPaths[i][j] = matrix[i][j] == 0 ? nPaths[i + 1][j] : 0;
				} else {
					nPaths[i][j] = matrix[i][j] == 0 ? nPaths[i][j + 1] + nPaths[i + 1][j] : 0;
				}
			}
		}
		return nPaths[0][0];
	}
	
	public static void main(String[] args) {
		PossiblePathsWithObstacles test = new PossiblePathsWithObstacles();
		int[][] matrix = {{0 , 0 , 0}, {0, 1, 0}, {0, 0, 0}};
		System.out.println(test.possiblepath(matrix));
	}
}
