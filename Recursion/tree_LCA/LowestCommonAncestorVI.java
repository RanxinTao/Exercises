package tree_LCA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import impl.KnaryTreeNode;

/**
 * Given M nodes in a K-nary tree, find their lowest common ancestor.
 * 
 * Assumptions:
 * 1. M >= 2.
 * 1. There is no parent pointer for the nodes in the K-nary tree.
 * 2. The given M nodes are guaranteed to be in the K-nary tree.
 * 
 * Examples:
 *       5
 *      / \
 *     9  12
 *    /|\  \
 *   1 2 3  14
 * 1. The lowest common ancestor of 2, 3, 14 is 5. 
 * 2. The lowest common ancestor of 2, 3, 9 is 9.
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) if the K-nary tree is balanced.
 */
public class LowestCommonAncestorVI {
	public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
		return lowestCommonAncestor(root, new HashSet<>(nodes));
	}
	
	private KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, Set<KnaryTreeNode> nodes) {
		if (root == null) {
			return null;
		}
		if (nodes.contains(root)) {
			return root;
		}
		KnaryTreeNode tmp = null;
		for (KnaryTreeNode child : root.children) {
			KnaryTreeNode res = lowestCommonAncestor(child, nodes);
			if (res != null) {
				tmp = tmp == null ? res : root;
			}
		}
		return tmp;
	}
}
