package BFS;

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
		Map<Integer, List<Integer>> distToVals = new HashMap<>();
		Map<TreeNode, Integer> nodeToDist = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		nodeToDist.put(root, 0);
		while (!queue.isEmpty()) {
			TreeNode curNode = queue.poll();
			int curDist = nodeToDist.get(curNode);
			distToVals.putIfAbsent(curDist, new ArrayList<>());
			distToVals.get(curDist).add(curNode.key);
			if (curNode.left != null) {
				queue.offer(curNode.left);
				nodeToDist.put(curNode.left, curDist - 1);
			}
			if (curNode.right != null) {
				queue.offer(curNode.right);
				nodeToDist.put(curNode.right, curDist + 1);
			}
		}
		return mapToArray(distToVals);
	}
	
	private List<List<Integer>> mapToArray(Map<Integer, List<Integer>> distToVals) {
		int minDist = Integer.MAX_VALUE;
		for (int dist : distToVals.keySet()) {
			minDist = Math.min(minDist, dist);
		}
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < distToVals.size(); i++, minDist++) {
			res.add(distToVals.get(minDist));
		}
		return res;
	}
	
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
