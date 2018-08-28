package tree;

import impl.TreeNode;

public class HeightOfBinaryTree {
	public int findHeight(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
		}
	}
}
