package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import impl.TreeNode;

/**
 * Given a binary tree, return the right view of it. Right view of a Binary Tree is list of nodes visible when tree is
 * visited from Right side, the order of the nodes in the list should be from top to bottom level of the original tree.
 * 
 * Examples:
 *          1              
 *        /   \     
 *       2     3 
 *      / \   / \
 *     4   5 6   7
 *    /       \
 *   9         8
 *  / \
 * 10 11
 * the right view is [1, 3, 7, 8, 11]
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class RightViewOfBinaryTree {
	public List<Integer> rightView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			res.add(queue.peek().key);
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode curNode = queue.poll();
				if (curNode.right != null) {
					queue.offer(curNode.right);
				}
				if (curNode.left != null) {
					queue.offer(curNode.left);
				}
			}
		}
		return res;
	}
}
