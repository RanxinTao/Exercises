package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import impl.TreeNode;

/**
 * Given a binary tree, get the vertically representation of it as a list of lists.
 * The columns should be from left to right, and for each column the nodes should be placed from top to bottom, from
 * left to right.
 * 
 * Examples:
 * Input:
 *      1              
 *     / \     
 *    2   3 
 *   / \ / \
 *  4  5,6  7
 *       \   \
 *        8   9 
 * Output:
 * [[4], // left most column
 *  [2], // 2nd left-most column
 *  [1, 5, 6], // 3rd left-most column, top -> bottom, left -> right
 *  [3, 8],
 *  [7],
 *  [9]]
 *  
 * Time: O(n)
 * Space: O(n)
 */
public class VerticalListOfBinaryTree {
	public List<List<Integer>> verticalPrint(TreeNode root) {
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
	
	private List<List<Integer>> mapToList(Map<Integer, List<Integer>> verticalNds) {
		int minPos = Integer.MAX_VALUE;
		for (int pos : verticalNds.keySet()) {
			minPos = Math.min(minPos, pos);
		}
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < verticalNds.size(); i++) {
			res.add(verticalNds.get(minPos++));
		}
		return res;
	}
	
	/*public List<List<Integer>> verticalPrint(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		Map<Integer, List<Integer>> verticalNds = new HashMap<>(); // map the horizontal position to node list (all nodes that has the certain horizontal position)
		Map<TreeNode, Integer> ndToPos = new HashMap<>(); // map node to its horizontal position (relative horizontal distance to root), this queue can actually be replaced by another queue.
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		ndToPos.put(root, 0);
		while (!q.isEmpty()) {
			TreeNode curNd = q.poll();
			int curPos = ndToPos.get(curNd);
			verticalNds.putIfAbsent(curPos, new ArrayList<>());
			verticalNds.get(curPos).add(curNd.key);
			if (curNd.left != null) {
				q.offer(curNd.left);
				ndToPos.put(curNd.left, curPos - 1);
			}
			if (curNd.right != null) {
				q.offer(curNd.right);
				ndToPos.put(curNd.right, curPos + 1);
			}
		}
		return mapToArray(verticalNds);
	}*/
	
	public static void main(String[] args) {
		VerticalListOfBinaryTree test = new VerticalListOfBinaryTree();
		TreeNode first = new TreeNode(1); TreeNode second = new TreeNode(2); TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4); TreeNode fifth = new TreeNode(5); TreeNode sixth = new TreeNode(6);
		TreeNode seventh = new TreeNode(7); TreeNode eighth = new TreeNode(8); TreeNode ninth = new TreeNode(9);
		first.left = second; first.right = third; second.left = fourth; second.right = fifth; third.left = sixth;
		third.right = seventh; sixth.right = eighth; seventh.right = ninth;
		System.out.println(test.verticalPrint(first));
	}
}
