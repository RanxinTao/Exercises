package tree;

import impl.TreeNode;

/**
 * Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree with left 
 * leaf nodes as the root.
 * 
 * Examples:
 *     1
 *    / \
 *   2   5
 *  / \
 * 3   4
 * is reversed to
 *     3
 *    / \
 *   2   4
 *  / \   
 * 1   5
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class ReverseBinaryTreeUpsideDown {
	public TreeNode reverse(TreeNode root) {
		TreeNode prevRoot = null;
		TreeNode prevRight = null;
		while (root != null) {
			TreeNode nextRoot = root.left; // save the next level root
			TreeNode right = root.right; // save the next level right (also is the current level right)
			root.left = prevRoot; // change the current level left
			root.right = prevRight; // change the current level right
			prevRoot = root;
			prevRight = right;
			root = nextRoot;
		}
		return prevRoot;
	}
}
