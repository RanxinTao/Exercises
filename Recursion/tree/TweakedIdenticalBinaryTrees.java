package tree;

import impl.TreeNode;

/**
 * Determine whether two given binary trees are identical assuming any number of 'tweak's are allowed.
 * A tweak is defined as a swap of the children of one node in the tree. 
 * 
 * Examples:
 *      5              5
 *     / \            / \  
 *    3   8   and    8   3
 *   / \                / \
 *  1  4                1  4
 * the two binary trees are tweaked identical.
 * 
 * Time: O(n), Space: worst O(n), O(logn) is the binary tree is balanced.
 */
public class TweakedIdenticalBinaryTrees {
	public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if (one.key != two.key) {
			return false;
		} else {
			return (isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left))
					|| (isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right));
		}
	}
}
