package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a gym with k pieces of equipment and some obstacles. We bought a chair and wanted to put this chair into 
 * the gym such that the sum of the shortest path cost from the chair to the k pieces of equipment is minimal. 
 * The gym is represented by a char matrix, 'E' denotes a cell with equipment, 'O' denotes a cell with an obstacle, 
 * 'C' denotes a cell without any equipment or obstacle. You can only move to neighboring cells (left, right, up, down) 
 * if the neighboring cell is not an obstacle. The cost of moving from one cell to its neighbor is 1. 
 * You can NOT put the chair on a cell with equipment or obstacle.
 * 
 * Assumptions:
 * 1. There is at least one equipment in the gym
 * 2. The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed to be not null
 * 3. It is GUARANTEED that each 'C' cell is reachable from all 'E' cells.
 * 4. If there does not exist such place to put the chair, just return {-1, -1}
 * 
 * Examples:
 * {{ 'E', 'O', 'C' },
 *  { 'C', 'E', 'C' },
 *  { 'C', 'C', 'C' }}
 * we should put the chair at (1, 0), so that the sum of cost from the chair to the two equipment is 1 + 1 = 2, which is minimal.
 * 
 * Time: O(emn), where e is the number of 'E' cells
 * Space: O(mn)
 */
public class PlaceToPutTheChairI {
	public List<Integer> putChair(char[][] gym) {
		int m = gym.length;
		int n = gym[0].length;
		int[][] costs = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (gym[i][j] == 'E') {		
					addCost(costs, gym, i, j); // BFS from every equipment
				}
			}
		}
		List<Integer> res = Arrays.asList(-1, -1); // must initialize values, otherwise cannot use set() directly below
		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (gym[i][j] == 'C' && costs[i][j] < minCost) { // only when costs[i][j] < minCost we can update the list
					minCost = costs[i][j];
					res.set(0, i);
					res.set(1, j);
				}
			}
		}
		return res;
	}

	private void addCost(int[][] costs, char[][] gym, int i, int j) {
		int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
		int m = gym.length;
		int n = gym[0].length;
		Queue<Integer> q = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];
		q.offer(i * n + j);
		visited[i][j] = true;
		int cost = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int cord = q.poll();
				i = cord / n;
				j = cord % n;
				for (int[] dir : dirs) {
					int neiI = i + dir[0];
					int neiJ = j + dir[1];
					if (neiI >= 0 && neiI < m && neiJ >= 0 && neiJ < n && gym[neiI][neiJ] != 'O' && !visited[neiI][neiJ]) {
						costs[neiI][neiJ] += cost; // either update here or update right after dequeue, both ok for this problem, but for Problem "Walls And Gates", must update here
						q.offer(neiI * n + neiJ);
						visited[neiI][neiJ] = true; // updating visited must be right after enqueue
					}
				}
			}
			cost++;
		}
	}

	public static void main(String[] args) {
		char[][] gym = new char[][] {{ 'E', 'C', 'E', 'O', 'C' }, 
			                         { 'E', 'O', 'C', 'C', 'E' },
				                     { 'O', 'O', 'E', 'C', 'C' }, 
				                     { 'C', 'O', 'C', 'E', 'E' }, 
				                     { 'E', 'C', 'C', 'C', 'C' }};
		PlaceToPutTheChairI test = new PlaceToPutTheChairI();
		System.out.println(test.putChair(gym));
	}
}
