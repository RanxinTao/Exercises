package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a gym with k pieces of equipment without any obstacles. Let's say we bought a chair and wanted to put this 
 * chair into the gym such that the sum of the shortest path cost from the chair to the k pieces of equipment is minimal. 
 * The gym is represented by a char matrix, 'E' denotes a cell with equipment, ' ' denotes a cell without equipment. 
 * The cost of moving from one cell to its neighbor(left, right, up, down) is 1. You can put chair on any cell in the gym.
 * 
 * Assumptions:
 * 1. There is at least one equipment in the gym
 * 2. The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed to be not null
 * 
 * Examples:
 * { { 'E', ' ', ' ' },
 *   { ' ', 'E', ' ' },
 *   { ' ', ' ', 'E' } }
 * we should put the chair at (1, 1), so that the sum of cost from the chair to the two equipments is 2 + 0 + 2 = 4, which is minimal.
 * 
 * Time: O(emn), where e is the number of 'E' cells
 * Space: O(mn)
 */
public class PlaceToPutTheChairII {
	public List<Integer> putChair(char[][] gym) {
		int[][] costs = new int[gym.length][gym[0].length];
		for (int i = 0; i < gym.length; i++) {
			for (int j = 0; j < gym[0].length; j++) {
				if (gym[i][j] == 'E') {			
					addCost(costs, gym, i, j); // BFS from gym[i][j] which is E
				}
			}
		}
		int minCost = Integer.MAX_VALUE; 
		List<Integer> res = Arrays.asList(-1, -1);
		for (int i = 0; i < gym.length; i++) {
			for (int j = 0; j < gym[0].length; j++) {
				if (costs[i][j] < minCost) { // find the cell with smallest sum of path cost to all the 'E' cells
					minCost = costs[i][j];
					res.set(0, i);
					res.set(1, j);
				}
			}
		}
		return res;
	}

	private void addCost(int[][] costs, char[][] gym, int i, int j) {
		Queue<Cell> queue = new LinkedList<>();
		boolean[][] visited = new boolean[gym.length][gym[0].length];
		queue.offer(new Cell(i, j));
		visited[i][j] = true;
		int cost = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				Cell cur = queue.poll();
				costs[cur.i][cur.j] += cost;
				List<Cell> neis = getNeis(cur, gym);
				for (Cell nei : neis) {
					if (!visited[nei.i][nei.j]) {
						queue.offer(nei);
						visited[nei.i][nei.j] = true; // updating visited must be right after enqueue
					}
				}
			}
			cost++;
		}
	}

	private List<Cell> getNeis(Cell cur, char[][] gym) {
		List<Cell> neis = new ArrayList<>();
		if (cur.i - 1 >= 0) {
			neis.add(new Cell(cur.i - 1, cur.j));
		}
		if (cur.i + 1 < gym.length) {
			neis.add(new Cell(cur.i + 1, cur.j));
		}
		if (cur.j - 1 >= 0) {
			neis.add(new Cell(cur.i, cur.j - 1));
		}
		if (cur.j + 1 < gym[0].length) {
			neis.add(new Cell(cur.i, cur.j + 1));
		}
		return neis;
	}

	static class Cell {
		int i;
		int j;

		Cell(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) {
		char[][] gym = new char[][] { { 'E', ' ', ' ' }, { ' ', 'E', ' ' }, { ' ', ' ', 'E' } };
		PlaceToPutTheChairII test = new PlaceToPutTheChairII();
		System.out.println(test.putChair(gym));
	}
}
