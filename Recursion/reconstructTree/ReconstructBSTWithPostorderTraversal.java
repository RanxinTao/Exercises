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
 */
public class ReconstructBSTWithPostorderTraversal {
	public TreeNode reconstruct(int[] post) {
		return helper(post, 0, post.length - 1);
	}

	private TreeNode helper(int[] post, int left, int right) {
		if (left > right) {
			return null;
		}
		TreeNode root = new TreeNode(post[right]);
		right--;
		int pi = left;
		// after this while loop, pIndex will be at the first element > root.key (not >= because no duplicate keys)
		while (post[pi] < root.key) {
			pi++;
		}
		root.left = helper(post, left, pi - 1);
		root.right = helper(post, pi, right);
		return root;
	}
}
