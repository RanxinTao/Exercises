package reconstructTree;

import java.util.HashMap;
import java.util.Map;

import impl.TreeNode;

/**
 * Given the postorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
 * 
 * Assumptions:
 * 1. The given sequences are not null and they have the same length
 * 2. There are no duplicate keys in the binary tree
 * Examples:
 * postorder traversal = {1, 4, 3, 11, 8, 5}
 * inorder traversal = {1, 3, 4, 5, 8, 11}
 * the corresponding binary search tree is
 *       5
 *      / \
 *     3   8
 *    / \   \
 *   1   4  11  
 */
public class ReconstructBinaryTreeWithPostorderAndInorder {
	public TreeNode reconstruct(int[] in, int[] post) {
		Map<Integer, Integer> inIndexes = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			inIndexes.put(in[i], i);
		}
		return helper(inIndexes, 0, in.length - 1, post, 0, post.length - 1);
	}

	private TreeNode helper(Map<Integer, Integer> inIndexes, int inLeft, int inRight, int[] post, int postLeft, int postRight) {
		if (inLeft > inRight) {
			return null;
		}
		TreeNode root = new TreeNode(post[postRight]);
		postRight--;
		int inIndex = inIndexes.get(root.key);
		int leftLen = inIndex - inLeft;
		root.left = helper(inIndexes, inLeft, inIndex - 1, post, postLeft, postLeft + leftLen - 1);
		root.right = helper(inIndexes, inIndex + 1, inRight, post, postLeft + leftLen, postRight);
		return root;
	}
}
