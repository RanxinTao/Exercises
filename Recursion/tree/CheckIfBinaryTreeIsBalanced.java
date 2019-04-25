package tree;

import impl.TreeNode;

/**
 * Check if a given binary tree is balanced. A balanced binary tree is one in
 * which the depths of every node's left and right subtree differ by at most 1
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) is the binary tree is balanced.
 */
public class CheckIfBinaryTreeIsBalanced {
	public boolean isBalanced(TreeNode root) {
		return getHeightIfBalanced(root) != -1;
	}

	private int getHeightIfBalanced(TreeNode root) {
		// base case
		if (root == null) {
			return 0;
		}
		// left child
		int leftHeight = getHeightIfBalanced(root.left);
		// if left subtree is already not balanced, we do not need to continue
		if (leftHeight == -1) {
			return -1;
		}
		// right child
		int rightHeight = getHeightIfBalanced(root.right);
		// current level
		if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}
