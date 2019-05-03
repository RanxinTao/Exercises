package tree_LCA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import impl.TreeNode;

/**
 * Given K nodes in a binary tree, find their lowest common ancestor.
 * 
 * Assumptions:
 * 1. K >= 2
 * 2. There is no parent pointer for the nodes in the binary tree
 * 3. The given K nodes are guaranteed to be in the binary tree
 * Examples:
 *       5
 *      / \
 *     9  12
 *    / \  \
 *   2   3  14
 * 1. The lowest common ancestor of 2, 3, 14 is 5. 
 * 2. The lowest common ancestor of 2, 3, 9 is 9
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) if the binary tree is balanced.
 */
public class LowestCommonAncestorIV {
	public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
		return lowestCommonAncestor(root, new HashSet<>(nodes));
	}

	private TreeNode lowestCommonAncestor(TreeNode root, Set<TreeNode> nodes) {
		if (root == null) {
			return null;
		}
		if (nodes.contains(root)) {
			return root;
		}
		TreeNode leftSolu = lowestCommonAncestor(root.left, nodes);
		TreeNode rightSolu = lowestCommonAncestor(root.right, nodes);
		if (leftSolu != null && rightSolu != null) {
			return root;
		}
		return leftSolu == null ? rightSolu : leftSolu;
	}
}
