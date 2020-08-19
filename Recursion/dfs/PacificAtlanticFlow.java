package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an m * n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean"
 * touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean. The order of returned grid
 * coordinates does not matter.
 * 
 * Examples:
 * 1. Given the following 4 * 4 matrix:
 * Pacific ~   ~   ~   ~
 *    ~    1   2   2  (3)  *
 *    ~    3   2   3  (4)  *
 *    ~    2   4  (5)  3   *
 *    ~   (6) (7)  1   4   *
 *         *   *   *   * Atlantic
 * Output: [0, 3], [1, 3], [2, 2], [3, 0], [3, 1]
 * 
 * Time: O(4^mn)
 * Space: O(mn)
 */
public class PacificAtlanticFlow {
	static int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		List<List<Integer>> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		boolean[][] pac = new boolean[matrix.length][matrix[0].length];
		boolean[][] atl = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			dfsFromOcean(matrix, pac, Integer.MIN_VALUE, i, 0);
			dfsFromOcean(matrix, atl, Integer.MIN_VALUE, i, matrix[0].length - 1);
		}
		for (int j = 0; j < matrix[0].length; j++) {
			dfsFromOcean(matrix, pac, Integer.MIN_VALUE, 0, j);
			dfsFromOcean(matrix, atl, Integer.MIN_VALUE, matrix.length - 1, j);
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (pac[i][j] && atl[i][j]) {
					res.add(Arrays.asList(i, j));
				}
			}
		}
		return res;
	}
	
	private void dfsFromOcean(int[][] matrix, boolean[][] visited, int height, int i, int j) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || matrix[i][j] < height) {
			return;
		}
		visited[i][j] = true;
		for (int[] d : dirs) {
			dfsFromOcean(matrix, visited, matrix[i][j], i + d[0], j + d[1]);
		}
	}
	
	/*public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		List<List<Integer>> res = new ArrayList<>();
	    for (int i = 0; i < matrix.length; i++) {
	    	for (int j = 0; j < matrix[0].length; j++) {
	    		if (getFlowDest(matrix, new int[matrix.length][matrix[0].length], new boolean[matrix.length][matrix[0].length], i, j) == 3) {
	    			List<Integer> item = new ArrayList<>();
	    			item.add(i);
	    			item.add(j);
	    			res.add(item);
	    		}
	    	}
	    }
	    return res;
	}
	
	private int getFlowDest(int[][] matrix, int[][] flowDests, boolean[][] visited, int i, int j) {
		if (visited[i][j]) {
			return flowDests[i][j];
		}
		visited[i][j] = true;
		int res = 0;
		if (i == 0 || j == 0) {
			res += 1;
		}
		if (i == matrix.length - 1 || j == matrix[0].length - 1) {
			res += 2;
		}
		if (res == 3) {
			flowDests[i][j] = 3; // 0 means can't flow to either ocean, 1 means Pacific, 2 means Atlantic, 3 means both
			return res;
		}
		int upRes = j - 1 >= 0 && matrix[i][j - 1] <= matrix[i][j] ? getFlowDest(matrix, flowDests, visited, i, j - 1) : 0;
		int downRes = j + 1 < matrix[0].length && matrix[i][j + 1] <= matrix[i][j] ? getFlowDest(matrix, flowDests, visited, i, j + 1) : 0;
		int leftRes = i - 1 >= 0 && matrix[i - 1][j] <= matrix[i][j] ? getFlowDest(matrix, flowDests, visited, i - 1, j) : 0;
		int rightRes = i + 1 < matrix.length && matrix[i + 1][j] <= matrix[i][j] ? getFlowDest(matrix, flowDests, visited, i + 1, j) : 0;
		Set<Integer> resSet = new HashSet<>(Arrays.asList(upRes, downRes, leftRes, rightRes, res));
		if (resSet.contains(3) || (resSet.contains(1) && resSet.contains(2))) {
			flowDests[i][j] = 3;
			return 3;
		} else if (resSet.contains(1)) {
			flowDests[i][j] = 1;
			return 1;
		} else if (resSet.contains(2)) {
			flowDests[i][j] = 2;
			return 2;
		} else {
			flowDests[i][j] = 0;
			return 0;
		}
	}*/
	
	public static void main(String[] args) {
		PacificAtlanticFlow test = new PacificAtlanticFlow();
		int[][] matrix = {{1, 2, 2, 3}, {3, 2, 3, 4}, {2, 4, 5, 3}, {6, 7, 1, 4}};
		System.out.println(test.pacificAtlantic(matrix));
	}
}
