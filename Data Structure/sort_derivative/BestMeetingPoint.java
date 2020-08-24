package sort_derivative;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * A group of two or more people wants to meet and minimize the total travel distance.
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in
 * the group. The distance is calculated using Manhattan Distance, where 
 * distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * 
 * Examples:
 * 1. Given three people living at (0, 0), (0, 4), and (2, 2):
 * 1 - 0 - 0 - 0 - 1 (0, 4)
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0 (1, 4)
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0 (2, 4)
 * The point (0, 2) is an ideal meeting point, as the total travel distance of 2 + 2 + 2 = 6
 * is minimal. So return 6.
 * 
 * Thoughts: the reason why this problem does not need BFS is that the meeting point can be set
 * to anywhere in the grid, there is no obstacles where can't be the meeting point.
 * 
 * Time: O(mn), where m is the number of rows, and n is the number of columns
 * Space: O(m + n)
 */
public class BestMeetingPoint {
	public int minTotalDistance(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int nRow = grid.length;
		int nCol = grid[0].length;
		List<Integer> rows = new ArrayList<>(); // instead of storing x, y here, just store row number and column number. because x-coord is actually associated 		
		List<Integer> cols = new ArrayList<>(); // with col, and y is assoicated with row in a 2D array, to avoid confusion, just use row and col instead.
 		for (int i = 0; i < nRow; i++) {
			for (int j = 0; j < nCol; j++) {
				if (grid[i][j] == 1) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
 		if (rows.size() <= 1) { // means less than 2 people
 			return 0;
 		}
 		int mid = rows.size() / 2;
	    quickSelect(rows, 0, rows.size() - 1, mid);
	    quickSelect(cols, 0, cols.size() - 1, mid);
	    int rowMedian = rows.get(mid);
	    int colMedian = cols.get(mid);
	    int dist = 0;
	    for (int row : rows) {
	    	dist += Math.abs(row - rowMedian);
	    }
	    for (int col : cols) {
	    	dist += Math.abs(col - colMedian);
	    }
	    return dist;
	}
	
	private void quickSelect(List<Integer> list, int l, int r, int k) { // process array from index l to r such that all elements between l and k - 1 < arr[k] and all elements between k + 1 and r > arr[k] (both inclusive)
		int pIdx = partition(list, l, r); // now all elements from index l to pi - 1 < arr[pi] and all elements from index pi + 1 to r > arr[pi] (both inclusive)
		if (k > pIdx) { // if k > pi then index l to pi are ready (both inclusive) because they are < arr[k]
			quickSelect(list, pIdx + 1, r, k); // in this case, still need to handle pi + 1 to r such that all elements between pi + 1 and k - 1 < arr[k] and all elements between k + 1 and r > arr[k] (both inclusive)
		} else if (k < pIdx) { // if k < pi then index pi to r are ready (both inclusive) because they are > arr[k]
			quickSelect(list, l, pIdx - 1, k); // in this case, still need to handle l to pi - 1 such that all elements between l and k - 1 < arr[k] and all elements between k + 1 and pi - 1 > arr[k] (both inclusive)
		} else { // if k == pi, then it is done because all elements between l and k - 1 < arr[k] and all elements between k + 1 and r > arr[k] (both inclusive)
			return; 
		}
	}
	
	private int partition(List<Integer> list, int l, int r) {
		int pIdx = l + new Random().nextInt(r - l + 1); // pivot index
		int pivot = list.get(pIdx);
		Collections.swap(list, pIdx, r);
		pIdx = l;
		for (int i = l; i < r; i++) {
			if (list.get(i) < pivot) {
				Collections.swap(list, i, pIdx);
				pIdx++;
			}
		}
		Collections.swap(list, pIdx, r);
		return pIdx;
	}
	
	/*public int minTotalDistance(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int nRow = grid.length;
		int nCol = grid[0].length;
		List<Integer> rows = new ArrayList<>(); // instead of storing x, y here, just store row number and column number. because x-coord is actually associated 		
		List<Integer> cols = new ArrayList<>(); // with col, and y is assoicated with row in a 2D array, to avoid confusion, just use row and col instead.
 		for (int i = 0; i < nRow; i++) {
			for (int j = 0; j < nCol; j++) {
				if (grid[i][j] == 1) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
 		if (rows.size() <= 1) { // means less than 2 people
 			return 0;
 		}
	    Collections.sort(rows);
	    Collections.sort(cols);
	    int mid = rows.size() / 2;
	    int rowMedian = rows.get(mid);
	    int colMedian = cols.get(mid);
	    int dist = 0;
	    for (int row : rows) {
	    	dist += Math.abs(row - rowMedian);
	    }
	    for (int col : cols) {
	    	dist += Math.abs(col - colMedian);
	    }
	    return dist;
	}*/
	
	public static void main(String[] args) {
		BestMeetingPoint test = new BestMeetingPoint();
		int[][] grid = {{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
		//int[][] grid = {{0, 0, 0}};
		System.out.println(test.minTotalDistance(grid));
	}
}
