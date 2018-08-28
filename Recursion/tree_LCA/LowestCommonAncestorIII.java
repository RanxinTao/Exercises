package tree_LCA;

import impl.TreeNode;

/**
 * Given two nodes in a binary tree, find their lowest common ancestor (the given two nodes are not guaranteed to be in the 
 * binary tree). Return null If any of the nodes is not in the tree.
 * 
 * Assumptions:
 * 1. There is no parent pointer for the nodes in the binary tree
 * 2. The given two nodes are not guaranteed to be in the binary tree
 * Examples:
 *       5
 *      / \
 *     9  12
 *    / \  \
 *   2   3  14
 * The lowest common ancestor of 2 and 14 is 5. The lowest common ancestor of 2 and 9 is 9. 
 * The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
 */
public class LowestCommonAncestorIII {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		TreeNode res = helper(root, one, two);
		if (res == null || (res == one && !exists(one, two)) || (res == two && !exists(two, one))) {
			return null;
		}
		return res;
	}

	private TreeNode helper(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null) {
			return null;
		} else if (root == one || root == two) {
			return root;
		} else {
			TreeNode leftSolu = helper(root.left, one, two);
			TreeNode rightSolu = helper(root.right, one, two);
			if (leftSolu != null && rightSolu != null) {
				return root;
			}
			return leftSolu == null ? rightSolu : leftSolu;
		}
	}

	private boolean exists(TreeNode root, TreeNode target) {
		if (root == null) {
			return false;
		} else if (root == target) {
			return true;
		} else {
			return exists(root.left, target) || exists(root.right, target);
		}
	}
}
