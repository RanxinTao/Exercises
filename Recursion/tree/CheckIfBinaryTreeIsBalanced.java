package tree;

import impl.TreeNode;

public class CheckIfBinaryTreeIsBalanced {
	public boolean isBalanced(TreeNode root) {
		return helper(root) != -1;
	}

	private int helper(TreeNode root) {
		// base case
		if (root == null) {
			return 0;
		}
		// left child, right child
		int leftDepth = helper(root.left);
		int rightDepth = helper(root.right);
		// current level
		if (leftDepth == -1 || rightDepth == -1) {
			return -1;
		} else if (Math.abs(leftDepth - rightDepth) > 1) {
			return -1;
		} else {
			return Math.max(leftDepth, rightDepth) + 1;
		}
	}
}
