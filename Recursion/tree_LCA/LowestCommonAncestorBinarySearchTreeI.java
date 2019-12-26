package tree_LCA;

import impl.TreeNode;

/**
 * Given two nodes in a binary search tree, find their lowest common ancestor.
 * 
 * Assumptions:
 * 1. There is no parent pointer for the nodes in the binary search tree
 * 2. There are no duplicate keys in the binary search tree
 * 3. The given two nodes are guaranteed to be in the binary search tree
 * Examples:
 *       5
 *      / \
 *     2  12
 *    / \  \
 *   1   3  14
 * 1. The lowest common ancestor of 1 and 14 is 5. 
 * 2. The lowest common ancestor of 1 and 3 is 2
 * 
 * Time: worst O(n), O(logn) if the binary tree is balanced.
 * Space: worst O(n), O(logn) if the binary tree is balanced.
 */
public class LowestCommonAncestorBinarySearchTreeI {
	public TreeNode lca(TreeNode root, int p, int q) {
		if (p < root.key && q < root.key) {
			return lca(root.left, p, q);
		} else if (p > root.key && q > root.key) {
			return lca(root.right, p, q);
		} else {
			return root;
		}
	}
}
