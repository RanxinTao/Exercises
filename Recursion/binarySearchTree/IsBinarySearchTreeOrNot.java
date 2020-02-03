package binarySearchTree;

import impl.TreeNode;

/**
 * Determine if a given binary tree is binary search tree. There should not be duplicate keys in binary search tree
 * (If there are duplicate keys, we should return false)
 * 
 * Assumptions:
 * You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.
 * 
 * Time: O(n), Space: O(n), O(logn) if the tree is balanced.
 */
public class IsBinarySearchTreeOrNot {
	public boolean isBST(TreeNode root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.key <= min || root.key >= max) {
			return false;
		}
		return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
	}
}