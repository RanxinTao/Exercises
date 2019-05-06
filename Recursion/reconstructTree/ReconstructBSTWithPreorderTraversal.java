package reconstructTree;

import impl.TreeNode;

/**
 * Given the preorder traversal sequence of a binary search tree, reconstruct the original tree.
 * 
 * Assumptions:
 * 1. The given sequence is not null
 * 2. There are no duplicate keys in the binary search tree
 * Examples:
 * preorder traversal = {5, 3, 1, 4, 8, 11}
 * the corresponding binary search tree is
 *       5
 *      / \
 *     3   8
 *    / \   \
 *   1   4  11  
 */
public class ReconstructBSTWithPreorderTraversal {
	public TreeNode reconstruct(int[] pre) {
		return reconstruct(pre, 0, pre.length - 1);
	}

	private TreeNode reconstruct(int[] pre, int left, int right) {
		if (left > right) {
			return null;
		}
		TreeNode root = new TreeNode(pre[left]);
		left++;
		int pi = left;
		while (pi < pre.length && pre[pi] < root.key) {
			pi++;
		}
		root.left = reconstruct(pre, left, pi - 1);
		root.right = reconstruct(pre, pi, right);
		return root;
	}
}
