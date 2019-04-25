package tree_LCA;

import impl.TreeNodeP;

/**
 * Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.
 * 
 * Assumptions:
 * 1. There is parent pointer for the nodes in the binary tree
 * 2. The given two nodes are NOT guaranteed to be in the binary tree
 * Examples:
 *       5
 *      / \
 *     9  12
 *    / \  \
 *   2   3  14
 * 1. The lowest common ancestor of 2 and 14 is 5. 
 * 2. The lowest common ancestor of 2 and 9 is 9. 
 * 3. The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
 * 
 * Time: worst O(n), O(logn) is the binary tree is balanced.
 * Space: O(1)
 */
public class LowestCommonAncestorII {
	public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
		if (one == two) {
			return one;
		}
		int len1 = length(one);
		int len2 = length(two);
		return len1 <= len2 ? mergeNode(one, two, len2 - len1) : mergeNode(two, one, len1 - len2);
	}

	private TreeNodeP mergeNode(TreeNodeP shorter, TreeNodeP longer, int diff) {
		while (diff > 0) {
			longer = longer.parent;
			diff--;
		}
		while (longer != shorter) {
			longer = longer.parent;
			shorter = shorter.parent;
		}
		return longer;
	}

	private int length(TreeNodeP node) {
		int length = 0;
		while (node != null) {
			node = node.parent;
			length++;	
		}
		return length;
	}
}
