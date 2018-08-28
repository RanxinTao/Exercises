package binarySearchTreeIterative;

import impl.TreeNode;

/**
 * In a binary search tree, find the node containing the closest number to the given target number.
 * Assumptions:
 * 1. The given root is not null.
 * 2. There are no duplicate keys in the binary search tree.
 * Examples:
 *     5
 *    / \
 *   2  11
 *     /  \
 *    6   14
 * closest number to 4 is 5
 * closest number to 10 is 11
 * closest number to 6 is 6
 */
public class ClosestNumberInBinarySearchTree {
	public int closest(TreeNode root, int target) {
		int res = root.key;
		while (root != null) {
			if (target == root.key) {
				return target;
			} else if (target < root.key) {
				if (root.key - target < Math.abs(res - target)) {
					res = root.key;
				}
				root = root.left;
			} else { // target > root.key
				if (target - root.key < Math.abs(res - target)) {
					res = root.key;
				}
				root = root.right;
			}
		}
		return res;
	}
}
