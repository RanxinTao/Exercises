package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
 * Thoughts: BFS from all the gates simultaneously.
 * 
 * Time: O(mn)
 * Space: O(mn)
 */
public class WallsAndGates {
	public int[][] wallsAndGates(int[][] rooms) {
		if (rooms.length == 0 || rooms[0].length == 0) {
			return rooms;
		}
		int m = rooms.length;
		int n = rooms[0].length;
		Queue<Cell> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) { // enqueue the gate
					q.add(new Cell(i, j));
				}
			}
		} // queue is ready now
		int dist = 1; // the distance from the room to its nearest gate
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				Cell cur = q.poll();
				List<Cell> neis = getNeis(cur, rooms);
				for (Cell nei : neis) {
					if (rooms[nei.i][nei.j] == Integer.MAX_VALUE) { // no need to maintain a visited array, INF means not visited.
						rooms[nei.i][nei.j] = dist;
						q.add(nei);
					}
				}
			}
			dist++;
		}
		return rooms;
	}
	
	private List<Cell> getNeis(Cell cur, int[][] rms) { // only get room neighbors
		List<Cell> neis = new ArrayList<>();
		if (cur.i - 1 >= 0 && rms[cur.i - 1][cur.j] == Integer.MAX_VALUE) {
			neis.add(new Cell(cur.i - 1, cur.j));
		}
		if (cur.i + 1 < rms.length && rms[cur.i + 1][cur.j] == Integer.MAX_VALUE) {
			neis.add(new Cell(cur.i + 1, cur.j));
		}
		if (cur.j - 1 >= 0 && rms[cur.i][cur.j - 1] == Integer.MAX_VALUE) {
			neis.add(new Cell(cur.i, cur.j - 1));
		}
		if (cur.j + 1 < rms[0].length && rms[cur.i][cur.j + 1] == Integer.MAX_VALUE) {
			neis.add(new Cell(cur.i, cur.j + 1));
		}
		return neis;
	}
	
	static class Cell {
		int i;
		int j;
		
		public Cell(int i, int j) {
			this.i = i;
			this.j = j;
		}
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
