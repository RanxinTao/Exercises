package binarySearchTreeIterative;

import impl.TreeNode;

/**
 * In a binary search tree, find the node containing the closest number to the given target number.
 * 
 * Assumptions:
 * 1. The given root is not null.
 * 2. There are no duplicate keys in the binary search tree.
 * 
 * Examples:
 *     5
 *    / \
 *   2  11
 *     /  \
 *    6   14
 * 1. closest number to 4 is 5
 * 2. closest number to 10 is 11
 * 3. closest number to 6 is 6
 * 
 * Time: worst O(n), O(logn) is the binary tree is balanced.
 * Space: O(1)
 */
public class ClosestNumberInBinarySearchTree {
	public int closest(TreeNode root, int target) {
		int closest = root.key;
		while (root != null) {
			if (target < root.key) {
				if (root.key - target < Math.abs(closest - target)) {
					closest = root.key;
				}
				root = root.left;
			} else if (target == root.key) {
				return target;
			} else { // target > root.key
				if (target - root.key < Math.abs(closest - target)) {
					closest = root.key;
				}
				root = root.right;
			}
		}
		return closest;
	}
}
