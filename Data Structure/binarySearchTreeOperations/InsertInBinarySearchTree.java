package binarySearchTreeOperations;

import impl.TreeNode;

/**
 * Insert a key in a binary search tree if the binary search tree does not already contain the key. Return the root of 
 * the binary search tree.
 * 
 * Assumptions:
 * 1. There are no duplicate keys in the binary search tree.
 * 2. If the key is already existed in the binary search tree, you do not need to do anything
 * 
 * Examples:
 *     5
 *    / \
 *   3   8
 *  / \
 * 1   4
 * insert 11, the tree becomes
 *     5
 *    / \
 *   3   8
 *  / \   \
 * 1   4  11
 * insert 11, the tree becomes
 *      5
 *    /   \
 *   3     8
 *  / \   / \
 * 1   4 6  11
 */
public class InsertInBinarySearchTree {
	public TreeNode insert(TreeNode root, int key) {
		if (root == null) {
			return new TreeNode(key);
		}
		TreeNode cur = root;
		while (key != cur.key) {
			if (key < cur.key) {
				if (cur.left != null) {
					cur = cur.left;
				} else {
					cur.left = new TreeNode(key);
					return root;
				}
			} else {
				if (cur.right != null) {
					cur = cur.right;
				} else {
					cur.right = new TreeNode(key);
					return root;
				}
			}
		}
		return root;
	}
}
