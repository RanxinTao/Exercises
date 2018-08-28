package kthElement_topK_heap;

import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are 
 * also sorted in ascending order. Find the Kth smallest number in it.
 * 
 * Assumptions: 
 * 1. the matrix is not null, N > 0 and M > 0
 * 2. K > 0 and K <= N * M
 * Examples:
 * { {1, 3,  5,  7},
 *   {2, 4,  8,  9},
 *   {3, 5, 11, 15},
 *   {6, 8, 13, 18} }
 * the 5th smallest number is 4, the 8th smallest number is 6
 * 
 * Time: O(klogk)
 */
public class KthSmallestInSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		PriorityQueue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>() {
			public int compare(Cell c1, Cell c2) {
				if (matrix[c1.row][c1.col] == matrix[c2.row][c2.col]) {
					return 0;
				}
				return matrix[c1.row][c1.col] < matrix[c2.row][c2.col] ? -1 : 1;
			}
		});
		boolean[][] visited = new boolean[rows][cols];
		minHeap.offer(new Cell(0, 0));
		visited[0][0] = true;
		for (int i = 0; i < k - 1; i++) {
			Cell cur = minHeap.poll();
			if (cur.row + 1 < rows && !visited[cur.row + 1][cur.col]) {
				minHeap.offer(new Cell(cur.row + 1, cur.col));
				visited[cur.row + 1][cur.col] = true;
			}
			if (cur.col + 1 < cols && !visited[cur.row][cur.col + 1]) {
				minHeap.offer(new Cell(cur.row, cur.col + 1));
				visited[cur.row][cur.col + 1] = true;
			}
		}
		Cell c = minHeap.peek();
		return matrix[c.row][c.col];
	}

	static class Cell {
		int row;
		int col;

		Cell(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
