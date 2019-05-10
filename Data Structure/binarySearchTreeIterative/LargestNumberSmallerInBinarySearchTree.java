package binarySearchTreeIterative;

import impl.TreeNode;

/**
 * In a binary search tree, find the node containing the largest number smaller than the given target number.
 * If there is no such number, return INT_MIN.
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
 * 1. largest number smaller than 1 is Integer.MIN_VALUE(Java) or INT_MIN(c++)
 * 2. largest number smaller than 10 is 6
 * 3. largest number smaller than 6 is 5
 * 
 * Time: worst O(n), O(logn) is the binary tree is balanced.
 * Space: O(1)
 */
public class LargestNumberSmallerInBinarySearchTree {
	public int largestSmaller(TreeNode root, int target) {
		int largestSmaller = Integer.MIN_VALUE;
		while (root != null) {
			if (target <= root.key) {
				root = root.left;
			} else {
				largestSmaller = root.key; // no need to do res = Math.max(root.key, res), root.key must > res here
				root = root.right;
			}
		}
		return largestSmaller;
	}
}
