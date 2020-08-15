package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 * 
 * Assumptions: 
 * 1. You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1]
 * is the same as [1, 0] and thus will not appear together in edges.
 * 
 * Examples:
 * 1. Given n = 5, and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * 2. Given n = 5, and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * 
 * Thoughts: This problem is equivalent to check if there is a cycle in the undirected graph. We know if it
 * is a tree, then starting from any node of the tree, we can traverse the whole tree, meaning that we can reach 
 * every tree node once and only once. In this problem, the tree does not have to be a binary tree, it can be
 * a knary tree.
 * 
 * Time: O(n + e), where n is the number of graph nodes, and e is the number of edges.
 * Space: worst O(n + e) because of a visited array and the adjacent list, O(logn) if it is a tree and the tree is balanced.
 */
public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		List<List<Integer>> adjList = new LinkedList<>();
		for (int i = 0; i < n; i++) { // initialize the adjacency list with n empty linked lists
			adjList.add(new LinkedList<>());
		}
		for (int[] edge : edges) { // add edges into the adjacency list
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		} // adjacency list is ready now
		boolean[] visited = new boolean[n];
		if (hasCycle(adjList, visited, 0, -1)) { // -1 is a dummy parent here
			return false;
		}
		for (boolean v : visited) { // after DFS from node 0, all nodes are expected to be visited, otherwise it is not a tree. E.g., {{0, 1}, {2, 3}}
			if (!v) {
				return false;
			}
		}
		return true;
	}
	
	private boolean hasCycle(List<List<Integer>> adjList, boolean[] visited, int cur, int parent) { // check if has cycle while traversing using DFS'
		visited[cur] = true;
		List<Integer> adjs = adjList.get(cur);
		for (int adj : adjs) {
			if (adj !=  parent) {
				if (visited[adj] || hasCycle(adjList, visited, adj, cur)) { // if an adjacent is visited before, or its adjacents have cycle, return true
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		GraphValidTree test = new GraphValidTree();
		int n = 5;
		//int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
		int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		System.out.println(test.validTree(n, edges));
	}
}
