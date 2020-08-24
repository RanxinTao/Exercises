package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import impl.TreeNode;

/**
 * Given a binary tree, get the top view of it. Top view of a binary tree is the set of nodes visible when the tree is
 * viewed from the top. A node x belongs to the output if x is the topmost node at its column. The nodes in the output
 * list should be from left to right. 
 * 
 * Examples:
 * 1.
 *      1              
 *     / \     
 *    2   3 
 *   / \ / \
 *  4 (5,6) 7
 * the top view is [4, 2, 1, 3, 7]
 * 
 * 2.
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 *       \
 *        5 
 *         \
 *          6
 * the top view is [2, 1, 3, 6]
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class TopViewOfBinaryTree {
	public List<Integer> topView(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		Map<Integer, Integer> distToVal = new HashMap<>();
		Map<TreeNode, Integer> nodeToDist = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		nodeToDist.put(root, 0);
		while (!queue.isEmpty()) {
			TreeNode curNode = queue.poll();
			int curDist = nodeToDist.get(curNode);
			distToVal.putIfAbsent(curDist, curNode.key);
			if (curNode.left != null) {
				queue.offer(curNode.left);
				nodeToDist.put(curNode.left, curDist - 1);
			}
			if (curNode.right != null) {
				queue.offer(curNode.right);
				nodeToDist.put(curNode.right, curDist + 1);
			}
		}
		return Arrays.asList(mapToArray(distToVal));
	}
	
	private Integer[] mapToArray(Map<Integer, Integer> distToVal) {
		int minDist = Integer.MAX_VALUE;
		for (int dist : distToVal.keySet()) {
			minDist = Math.min(minDist, dist);
		}
		Integer[] res = new Integer[distToVal.size()];
		for (int dist : distToVal.keySet()) {
			res[dist - minDist] = distToVal.get(dist);
		}
		return res;
	}
	
	public static void main(String[] args) {
		TopViewOfBinaryTree test = new TopViewOfBinaryTree();
		TreeNode first = new TreeNode(1); TreeNode second = new TreeNode(2); TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4); TreeNode fifth = new TreeNode(5); TreeNode sixth = new TreeNode(6);
		TreeNode seventh = new TreeNode(7);
		first.left = second; first.right = third; second.left = fourth; second.right = fifth; third.left = sixth;
		third.right = seventh;
		System.out.println(test.topView(first));
	}
}
