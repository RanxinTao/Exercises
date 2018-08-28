package binarySearchTreeOperations;

import impl.TreeNode;

/**
 * Find the target key K in the given binary search tree, return the node that contains the key if K is found, 
 * otherwise return null.
 * 
 * Assumptions:
 * There are no duplicate keys in the binary search tree.
 */
public class SearchInBinarySearchTree {
	public TreeNode search(TreeNode root, int key) {
		while (root != null) {
			if (key == root.key) {
				return root;
			} else if (key < root.key) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return null;
	}
}
