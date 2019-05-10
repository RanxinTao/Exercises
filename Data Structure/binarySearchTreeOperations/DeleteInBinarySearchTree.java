package binarySearchTreeOperations;

import impl.TreeNode;

/**
 * Delete the target key K in the given binary search tree if the binary search tree contains K. After deletion the 
 * binary search tree's property should be maintained. Return the root of the binary search tree. 
 * 
 * Assumptions:
 * There are no duplicate keys in the binary search tree.
 * 
 * Time: worst O(n), O(logn) is the binary tree is balanced.
 * Space: O(1)
 */
public class DeleteInBinarySearchTree {
	public TreeNode deleteTree(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (key < root.key) {
			root.left = deleteTree(root.left, key);
		} else if (key == root.key) {
			if (root.left != null && root.right != null) {
				int smallest = deleteSmallestNode(root.right, root);
				root.key = smallest;
			} else {
				return root.left == null ? root.right : root.left;
			}
		} else { // key > root.key
			root.right = deleteTree(root.right, key);
		}
		return root;
	}

	private int deleteSmallestNode(TreeNode cur, TreeNode pre) { // This function will: 1. delete the smallest node; 2. return its key
		if (cur.left == null) {
			pre.right = cur.right;
			return cur.key;
		}
		while (cur.left != null) {
			pre = cur;
			cur = cur.left;
		}
		pre.left = cur.right; // the smallest node can have at most one child which is the right child
		return cur.key;
	}
}
