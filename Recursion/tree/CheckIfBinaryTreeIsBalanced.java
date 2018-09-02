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
		// left child
		int leftHeight = helper(root.left);
		// if left subtree is already not balanced, we do not need to continue
		if (leftHeight == -1) {
			return -1;
		}
		// right child
		int rightHeight = helper(root.right);
		// current level
		if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}
