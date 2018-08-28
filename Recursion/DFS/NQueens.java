package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Assumptions: n > 0
 */
public class NQueens {
	public List<List<Integer>> nqueens(int n) {
		List<List<Integer>> res = new ArrayList<>();
		DFS(n, 0, new ArrayList<>(), res, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
		return res;
	}

	private void DFS(int n, int curRow, List<Integer> curRes, List<List<Integer>> res, 
			boolean[] usedCols, boolean[] usedDiags, boolean[] usedRevDiags) {
		if (curRow == n) {
			res.add(new ArrayList<>(curRes));
			return;
		}
		for (int col = 0; col < n; col++) {
			if (isValid(n, curRow, col, usedCols, usedDiags, usedRevDiags)) {
				curRes.add(col);
				markUsed(n, curRow, col, true, usedCols, usedDiags, usedRevDiags);
				DFS(n, curRow + 1, curRes, res, usedCols, usedDiags, usedRevDiags);
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
