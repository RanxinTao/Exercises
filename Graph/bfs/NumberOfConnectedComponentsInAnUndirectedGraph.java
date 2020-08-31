package bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 * 
 * Assumptions:
 * 1. No duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as
 * [1, 0] and thus will not appear together in edges.
 * 
 * Examples:
 * 1. 0       3
 *    |       |
 *    1 - 2   4
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * 2. 0       4 
 *    |       |
 *    1 - 2 - 3
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 * 
 * Time: O(n + e), where n is the number of nodes and e is the number of edges
 * Space: O(n)
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph { // a typical BFS implementation in graph
	public int countComponents(int n, int[][] edges) {
		List<List<Integer>> adjList = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new LinkedList<>());
		}
		for (int[] edge : edges) {
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}
		int res = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				bfs(i, visited, adjList);
				res++;
			}
		}
		return res;
	}
	
	private void bfs(int i, boolean[] visited, List<List<Integer>> adjList) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		visited[i] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int cur = q.poll(); // graph node
				List<Integer> adjs = adjList.get(cur);
				for (int adj :  adjs) {
					if (!visited[adj]) {
						q.offer(adj);
						visited[adj] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		NumberOfConnectedComponentsInAnUndirectedGraph test = new NumberOfConnectedComponentsInAnUndirectedGraph();
		/*int n = 5;
		int[][] edges = {{0, 1}, {1, 2}, {3, 4}}; // 2 */
		int n = 5;
		int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}}; // 1
		System.out.println(test.countComponents(n, edges));
	}
}
