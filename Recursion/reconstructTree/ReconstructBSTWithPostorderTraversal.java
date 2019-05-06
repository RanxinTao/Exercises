package reconstructTree;

import impl.TreeNode;

/**
 * Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.
 * 
 * Assumptions:
 * 1. The given sequence is not null
 * 2. There are no duplicate keys in the binary search tree
 * Examples:
 * postorder traversal = {1, 4, 3, 11, 8, 5}
 * the corresponding binary search tree is
 *       5
 *      / \
 *     3   8
 *    / \   \
 *   1   4  11
 * 
 * Time: O(n^2)
 * Space: worst O(n), O(logn) if the binary tree is balanced.
 */
public class ReconstructBSTWithPostorderTraversal {
	public TreeNode reconstruct(int[] post) {
		return reconstruct(post, 0, post.length - 1);
	}

	private TreeNode reconstruct(int[] post, int left, int right) {
		if (left > right) {
			return null;
		}
		TreeNode root = new TreeNode(post[right]);
		int index = left;
		while (post[index] < root.key) { // after this, index will be at the 1st element > root.key (not >= because no duplicate keys)
			index++;
		}
		root.left = reconstruct(post, left, index - 1);
		root.right = reconstruct(post, index, right - 1);
		return root;
	}
}
