package bfs;

import java.util.LinkedList;
import java.util.Queue;

import impl.TreeNode;

/**
 * Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree is
 * completely filled except possibly the last level. Furthermore, all nodes are as far left as possible
 * 
 * Examples:
 *      5              5
 *     / \            / \
 *    3   8          3   8 
 *   / \   \        / \   \
 *  1  4   11      1   4  11 
 * is completed    is not completed
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class CheckIfBinaryTreeIsCompleted {
	public boolean isCompleted(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		boolean missing = false;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			// check left child
			if (cur.left == null) {
				missing = true;
			} else if (missing) {
				return false;
			} else {
				queue.offer(cur.left);
			}
			// check right child
			if (cur.right == null) {
				missing = true;
			} else if (missing) {
				return false;
			} else {
				queue.offer(cur.right);
			}
		}
		return true;
	}
}
