package tree;

import impl.TreeNode;

/**
 * Check if a given binary tree is symmetric
 * 
 * Examples:
 *      5              5
 *     / \            / \  
 *    3   3          3   3
 *   / \ / \        / \ / \
 *  1  4 4  1      1  4 1  4
 * is symmetric   is not symmetric
 * 
 * Time: O(n), Space: worst O(n), O(logn) is the binary tree is balanced.
 */
public class SymmetricBinaryTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		// base case
		if (left == null && right == null) {
			return true;
		} else if (left == null || right == null) {
			return false;
		} else if (left.key != right.key) {
			return false;
		// left child, right child, current level
		} else {
			return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
		}
	}
}
