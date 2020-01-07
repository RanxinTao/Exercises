package DFS;

/**
 * In a 2D black image there are some disjoint white objects with arbitrary shapes, find the number of disjoint white 
 * objects in an efficient way. By disjoint, it means there is no white pixels that can connect the two objects, 
 * there are four directions to move to a neighbor pixel (left, right, up, down).
 * Black is represented by 1¡¯s and white is represented by 0¡¯s.
 * 
 * Assumptions:
 * 1. The given image is represented by a integer matrix and all the values in the matrix are 0 or 1
 * 2. The given matrix is not null
 * 
 * Examples:
 * the given image is
 * 0  0  0  1
 * 1  0  1  1
 * 1  1  0  0
 * 0  1  0  0
 * there are 3 disjoint white objects.
 */
public class DisjointWhiteObjects {
	public int whiteObjects(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0 && !visited[i][j]) {
					DFS(i, j, matrix, visited);
					res++;
				}
			}
		}
		return res;
	}

	private void DFS(int i, int j, int[][] matrix, boolean[][] visited) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
			return;
		}
		if (visited[i][j] || matrix[i][j] != 0) {
			return;
		}
		visited[i][j] = true;
		DFS(i + 1, j, matrix, visited);
		DFS(i - 1, j, matrix, visited);
		DFS(i, j + 1, matrix, visited);
		DFS(i, j - 1, matrix, visited);
	}
}
