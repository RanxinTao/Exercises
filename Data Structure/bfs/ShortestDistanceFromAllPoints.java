package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 * You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * 1. Each 0 marks an empty land which you can pass by freely.
 * 2. Each 1 marks a building which you cannot pass through.
 * 3. Each 2 marks an obstacle which you cannot pass through.
 * Note: There will be at least one building. If it is not possible to build such house according to the above rules,
 * return -1.
 * 
 * Examples:
 * 1. given three buildings at (0, 0), (0, 4), (2, 2), and an obstacle at (0, 2):
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (1, 2) is an ideal empty land to build a house, as the total travel distance of 3 + 3 + 1 = 7 is minimal.
 * So return 7.
 * 
 * Thoughts: this problem is similar to Problem "Place To Put The Chair".
 * 
 * Time: O(emn), where e is the number of empty lands
 * Space: O(mn)
 */
public class ShortestDistanceFromAllPoints {
	public int shortestDistance(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] dists = new int[m][n];
		int[][] nReach = new int[m][n]; // nReach[i][j] represents the total number of buildings can be reached starting from grid[i][j] 
		int nBldgs = 0; // the total number of buildings
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					addDist(grid, dists, nReach, i, j); // BFS from every building
					nBldgs++;
				}
			}
		}
		int minDist = Integer.MAX_VALUE;
		boolean hasSolu = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0 && nReach[i][j] == nBldgs) {
					hasSolu = true;
					minDist = Math.min(minDist, dists[i][j]);
				}
			}
		}
		return hasSolu ? minDist : -1;
	}
	
	private void addDist(int[][] grid, int[][] dists, int[][] nReach, int i, int j) { // BFS
		int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
		int m = grid.length;
		int n = grid[0].length;
		Queue<Integer> q = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];
		q.offer(i * n + j);
		visited[i][j] = true;
		int dist = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int cord = q.poll();
				i = cord / n;
				j = cord % n;
				dists[i][j] += dist;
				nReach[i][j]++;
				for (int[] dir : dirs) {
					int neiI = i + dir[0];
					int neiJ = j + dir[1];
					if (neiI >= 0 && neiI < m && neiJ >= 0 && neiJ < n && grid[neiI][neiJ] == 0 && !visited[neiI][neiJ]) {
						q.offer(neiI * n + neiJ);
						visited[neiI][neiJ] = true;
					}
				}
			}
			dist++;
		}
	}
	
	public static void main(String[] args) {
		ShortestDistanceFromAllPoints test = new ShortestDistanceFromAllPoints();
		int[][] grid = {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
		System.out.println(test.shortestDistance(grid));
	}
}
