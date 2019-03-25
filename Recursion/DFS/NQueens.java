package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.
 * Return a list of ways of putting the N Queens. Each way is represented by a list of the Queen's y index for x indices
 * of 0 to (N - 1)
 * 
 * Assumptions: N > 0
 * Examples:
 * N = 4, there are two ways of putting 4 queens: [1, 3, 0, 2] and [2, 0, 3, 1]
 * 
 * Time: O(n!)
 * Space: O(n)
 */
public class NQueens {
	public List<List<Integer>> nqueens(int n) {
		List<List<Integer>> res = new ArrayList<>();
		putQueenAtRow(n, 0, new ArrayList<>(), res, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
		return res;
	}

	private void putQueenAtRow(int n, int curRow, List<Integer> curRes, List<List<Integer>> res, 
			boolean[] usedCols, boolean[] usedDiags, boolean[] usedRevDiags) {
		if (curRow == n) {
			res.add(new ArrayList<>(curRes));
			return;
		}
		for (int col = 0; col < n; col++) {
			if (isValid(n, curRow, col, usedCols, usedDiags, usedRevDiags)) {
				curRes.add(col);
				markUsed(n, curRow, col, true, usedCols, usedDiags, usedRevDiags);
				putQueenAtRow(n, curRow + 1, curRes, res, usedCols, usedDiags, usedRevDiags);
				curRes.remove(curRes.size() - 1);
				markUsed(n, curRow, col, false, usedCols, usedDiags, usedRevDiags);
			}
		}
	}

	private boolean isValid(int n, int row, int col, 
			boolean[] usedCols, boolean[] usedDiags, boolean[] usedRevDiags) {
		return !usedCols[col] && !usedDiags[row + col] && !usedRevDiags[row - col + n - 1];
	}

	private void markUsed(int n, int row, int col, boolean bool, 
			boolean[] usedCols, boolean[] usedDiags, boolean[] usedRevDiags) {
		usedCols[col] = bool;
		usedDiags[row + col] = bool;
		usedRevDiags[row - col + n - 1] = bool;
	}
	
	public static void main(String[] args) {
		NQueens test = new NQueens();
		int n = 4;
		System.out.println(test.nqueens(n));
	}
}
