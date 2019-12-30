package tree_LCA;

import impl.KnaryTreeNode;

/**
 * Given two nodes in a K-nary tree, find their lowest common ancestor.
 * 
 * Assumptions:
 * 1. There is no parent pointer for the nodes in the K-nary tree.
 * 2. The given two nodes are guaranteed to be in the K-nary tree.
 * 
 * Examples:
 *       5
 *      / \
 *     9  12
 *    /|\  \
 *   1 2 3  14
 * 1. The lowest common ancestor of 2 and 14 is 5. 
 * 2. The lowest common ancestor of 2 and 9 is 9.
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) if the K-nary tree is balanced.
 */
public class LowestCommonAncestorV {
	public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
		if (root == null) {
			return null;
		}
		if (root == a || root == b) {
			return root;
		}
		KnaryTreeNode tmp = null;
		for (KnaryTreeNode child : root.children) {
			KnaryTreeNode res = lowestCommonAncestor(child, a, b);
			if (res != null) {
				tmp = tmp == null ? res : root;
			}
		}
		return tmp;
	}
}
