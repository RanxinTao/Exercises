package tree;

import impl.TreeNode;

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
		// left child, right child
		} else {
			return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
		}
	}
}
