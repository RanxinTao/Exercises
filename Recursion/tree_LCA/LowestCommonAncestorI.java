package tree_LCA;

import impl.TreeNode;

/**
 * Given two nodes in a binary tree, find their lowest common ancestor.
 * 
 * Assumptions:
 * 1. There is no parent pointer for the nodes in the binary tree
 * 2. The given two nodes are guaranteed to be in the binary tree
 * Examples:
 *       5
 *      / \
 *     9  12
 *    / \  \
 *   2   3  14
 * The lowest common ancestor of 2 and 14 is 5. The lowest common ancestor of 2 and 9 is 9
 */
public class LowestCommonAncestorI {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null) {
			return null;
		}
		if (root == one || root == two) {
			return root;
		}
		TreeNode leftSolu = lowestCommonAncestor(root.left, one, two);
		TreeNode rightSolu = lowestCommonAncestor(root.right, one, two);
		if (leftSolu != null && rightSolu != null) {
			return root;
		}
		return leftSolu == null ? rightSolu : leftSolu;
	}
}
