package binarySearchTreeOperations;

import impl.TreeNode;

/**
 * Delete the target key K in the given binary search tree if the binary search tree contains K. After deletion the binary 
 * search tree's property should be maintained.Return the root of the binary search tree. 
 * 
 * Assumptions:
 * There are no duplicate keys in the binary search tree.
 */
public class DeleteInBinarySearchTree {
	public TreeNode delete(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (key == root.key) {
			if (root.left != null && root.right != null) {
				int smallest = deleteSmallest(root.right, root);
				root.key = smallest;
			} else {
				return root.left == null ? root.right : root.left;
			}
		} else if (key < root.key) {
			root.left = delete(root.left, key);
		} else {
			root.right = delete(root.right, key);
		}
		return root;
	}

	// Note that the smallest node can have at most one child which is the right child
	// This function will: 1. delete the smallest node; 2. return its key
	private int deleteSmallest(TreeNode cur, TreeNode pre) {
		if (cur.left == null) {
			pre.right = cur.right;
			return cur.key;
		}
		while (cur.left != null) {
			pre = cur;
			cur = cur.left;
		}
		pre.left = cur.right;
		return cur.key;
	}
}
