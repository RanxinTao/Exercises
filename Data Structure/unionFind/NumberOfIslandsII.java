package unionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand
 * operation which turns the water at position (row, col) into a land. Given a list of positions to
 * operate, count the number of islands after each addLand operation.
 * An island is surrounded by water and is formed by connecting adjacent lands, horizontally or
 * vertically. You may assume all four edges of the grid are all surrounded by water.
 * 
 * Examples:
 * 1. Given m = 3, n = 3, position = [[0, 0], [0, 1], [1, 2], [2, 1]]. Initially, the 2d grid is filled
 * with water. (Assume 0 represents water and 1 represents land).
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * 1 0 0
 * 0 0 0	number of islands = 1
 * 0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * 1 1 0
 * 0 0 0	number of islands = 1
 * 0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * 1 1 0
 * 0 0 1	number of islands = 2
 * 0 0 0
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * 1 1 0
 * 0 0 1	number of islands = 3
 * 0 1 0
 * We return the result as an array: [1, 1, 2, 3]
 * 
 * Thoughts: using DFS when a new island is added, and updating the group (or id) of all the affected 
 * lands every time is able to solve this problem. But we can notice that DFS is actually not necessary, 
 * instead we can store all the parent relationship in a map so we don't have to iterate through all 
 * the affected lands, we can only update the one land (the root land). The algorithm is called union find.
 * 
 * Time: O(k^2) for DFS solution, where k is the length of the positions. because updateId method will cause 
 * 1 + 2 + ... + k.
 * Space: O(mn) for DFS solution
 * 
 * Reference: https://www.programcreek.com/2015/01/leetcode-number-of-islands-ii-java/
 */
public class NumberOfIslandsII {
	/*public List<Integer> numIslands(int m, int n, int[][] positions) { // optimal solution
		Map<Integer, Integer> parents = new HashMap<>(); // map an island to its direct parent
		List<Integer> res = new ArrayList<>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int cnt = 0;
		for (int[] pos : positions) {
			cnt++; // every time addLand() is performed we will have one more island
			int curIdx = n * pos[0] + pos[1]; // encode the index of the current island
			parents.put(curIdx, -1); // this step marks an island in (pos[0], pos[1]), instead of water
			for (int i = 0; i < 4; i++) {
				int x = pos[0] + dx[i];
				int y = pos[1] + dy[i];
				int neiIdx = n * x + y;
				if (x >= 0 && x < m && y >= 0 && y < n && parents.containsKey(neiIdx)) { // parents.containsKey(neiIdx) means it is an island, not water
					int root = getRoot(parents, neiIdx);
					if (root != curIdx) { // It is possible that the neigbor's root is already cur, e.g., a cycle, and the root has been set to cur before, in this case, we cannot do count - 1
						parents.put(root, curIdx);
						cnt--; // the new added island is connected to an existing one, so count - 1
					}
				}
			}
			res.add(cnt);
		}
		return res;
	}
	
	private int getRoot(Map<Integer, Integer> parents, int is) { // get the root island of the input island, the root is last added to the map
		while (parents.get(is) != -1) {
			is = parents.get(is); // the island now becomes its parent
		}
		return is;
	}*/
	
	public List<Integer> numIslands(int m, int n, int[][] positions) { // DFS solution, easy to understand
		List<Integer> res = new ArrayList<>();
		int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int[][] grid = new int[m][n]; // note: positions is not the grid map, check its definition
		int cnt = 0;
		int curId = 1; // because 0 means water, so in order to avoid using 0, id starts from 1
		for (int[] pos : positions) {
			cnt++;
			int i = pos[0];
			int j = pos[1];
			grid[i][j] = curId;
			for (int[] dir : dirs) {
				int neiI = i + dir[0];
				int neiJ = j + dir[1];
				if (neiI >= 0 && neiI < m && neiJ >= 0 && neiJ < n) {
					int neiId = grid[neiI][neiJ];
					if (neiId != 0 && neiId != curId) { // It is possible that the neiId == curId, e.g., a cycle, and the neighbor has been updated to curId, in this case, we cannot do count - 1
						updateId(grid, neiI, neiJ, curId); // update neighbor to curId
						cnt--;
					}
				}
			}
			curId++; // easy to forget, id must be increased by 1 every time
			res.add(cnt);
		}
		return res;
	}
	
	private void updateId(int[][] grid, int x, int y, int id) { // DFS
		if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y] == id || grid[x][y] == 0) { // grid[x][y] == id means visited before, == 0 means it is water
			return;
		}
		grid[x][y] = id;
		updateId(grid, x + 1, y, id);
		updateId(grid, x - 1, y, id);
		updateId(grid, x, y + 1, id);
		updateId(grid, x, y - 1, id);
	}
	
	public static void main(String[] args) {
		NumberOfIslandsII test = new NumberOfIslandsII();
		/*int m = 3;
		int n = 3;
		int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};*/
		int m = 4;
		int n = 7;
		int[][] positions = {{2, 4}, {1, 4}, {0, 1}, {1, 1}, {1, 5}, {0, 0}, {1, 0}};
		System.out.println(test.numIslands(m, n, positions));
	}
}
