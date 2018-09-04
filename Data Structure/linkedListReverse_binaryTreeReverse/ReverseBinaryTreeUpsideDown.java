package linkedListReverse_binaryTreeReverse;

import impl.TreeNode;

/**
 * Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree 
 * with left leaf nodes as the root.
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
 */
public class ReverseBinaryTreeUpsideDown {
	public TreeNode reverse(TreeNode root) {
		TreeNode prev = null;
		TreeNode prevRight = null;
		while (root != null) {
			TreeNode next = root.left;
			TreeNode right = root.right;
			root.left = prev;
			root.right = prevRight;
			prev = root;
			prevRight = right;
			root = next;
		}
		return prev;
	}
}
