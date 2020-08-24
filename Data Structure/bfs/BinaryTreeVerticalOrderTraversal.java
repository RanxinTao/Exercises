package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import impl.TreeNode;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to buttom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 * 
 * Examples:
 * 1. Given binary tree [3, 9, 20, null, null, 15, 7],
 *    3              
 *   / \     
 *  9  20 
 *     / \
 *    15  7
 * return its vertical order traversal as: [9, 3, 15, 20, 7].
 * 2. Given binary tree [3, 9, 8, 4, 0, 1, 7],
 *     3              
 *    / \     
 *   9   8 
 *  / \ / \
 * 4  0,1  7
 * return its vertical order traversal as: [4, 9, 3, 0, 1, 8, 7].
 * 3. Given binary tree [3, 9, 8, 4, 0, 1, 7, null, null, null, 2, 5] (0's right child is 2 and 1's left child is 5),
 *     3              
 *    / \     
 *   9   8 
 *  / \ / \
 * 4  0,1  7
 *    / \
 *   5   2
 * return its vertical order traversal as: [4, 9, 5, 3, 0, 1, 8, 2, 7].
 *  
 * Time: O(n)
 * Space: O(n)
 */
public class BinaryTreeVerticalOrderTraversal {
	public List<Integer> verticalOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		Map<Integer, List<Integer>> verticalNds = new HashMap<>(); // map the horizontal position to node list (all nodes that has the certain horizontal position)
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>(); // track the horizontal positions of nodes in q1
		q1.offer(root);
		q2.offer(0);
		while (!q1.isEmpty()) {
			TreeNode curNd = q1.poll();
			int curPos = q2.poll();
			verticalNds.putIfAbsent(curPos, new ArrayList<>());
			verticalNds.get(curPos).add(curNd.key);
			if (curNd.left != null) {
				q1.offer(curNd.left);
				q2.offer(curPos - 1);
			}
			if (curNd.right != null) {
				q1.offer(curNd.right);
				q2.offer(curPos + 1);
			}
		}
		return mapToList(verticalNds);
	}
	
	private List<Integer> mapToList(Map<Integer, List<Integer>> verticalNds) {
		int minPos = Integer.MAX_VALUE;
		for (int pos : verticalNds.keySet()) {
			minPos = Math.min(minPos, pos);
		}
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < verticalNds.size(); i++) {
			res.addAll(verticalNds.get(minPos++));
		}
		return res;
	}
}
