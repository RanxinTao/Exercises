package bfs;

import java.util.LinkedList;
import java.util.Queue;

import impl.Utils;

/**
 * You are given a m * n 2D grid initialized with these three possible values.
 * 1. -1: A wall or an obstacle.
 * 2. 0: A gate.
 * 3. INF: infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may
 * assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should
 * be filled with INF.
 * 
 * Examples:
 * 1. given the 2D grid:
 * INF -1   0   INF
 * INF INF INF  -1
 * INF -1  INF  -1
 *  0  -1  INF  INF
 * After running your function, the 2D grid should be:
 * 3 -1 0  1
 * 2  2 1 -1
 * 1 -1 2 -1
 * 0 -1 3  4
 * 
 * Thoughts: Instead of BFS from each gate one by one like in the Problem "Place To Put The Chair", just BFS from all 
 * the gates simultaneously, because we only need to find the distance to the nearest gate, not distance to all gates.
 * 
 * Time: O(mn)
 * Space: O(mn)
 */
public class WallsAndGates {
	public int[][] wallsAndGates(int[][] rooms) {
		if (rooms.length == 0 || rooms[0].length == 0) {
			return rooms;
		}
		int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
		int m = rooms.length;
		int n = rooms[0].length;
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) { // enqueue the gate
					q.offer(i * n + j);
				}
			}
		}
		int dist = 1; // the distance from the room to its nearest gate
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int cord = q.poll();
				int i = cord / n;
				int j = cord % n;
				for (int[] dir : dirs) {
					int neiI = i + dir[0];
					int neiJ = j + dir[1];
					if (neiI >= 0 && neiI < m && neiJ >= 0 && neiJ < n && rooms[neiI][neiJ] == Integer.MAX_VALUE) { // no need to maintain a visited array, INF means not visited.
						q.offer(neiI * n + neiJ);
						rooms[neiI][neiJ] = dist; // must update value here because we are using rooms[neiI][neiJ] == Integer.MAX_VALUE to check if visited, not updating here will add more to the queue for the next round.
					}
				}
			}
			dist++;
		}
		return rooms;
	}
	
	public static void main(String[] args) {
		WallsAndGates test = new WallsAndGates();
		int m = Integer.MAX_VALUE;
		int[][] rooms = {{m, -1, 0, m}, {m, m, m, -1}, {m, -1, m, -1}, {0, -1, m, m}};
		//int[][] rooms = {};
		rooms = test.wallsAndGates(rooms);
		Utils.print2dArray(rooms);
	}
}
