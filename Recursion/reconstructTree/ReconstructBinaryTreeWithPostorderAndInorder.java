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
 *   
 * Time: O(n)
 * Space: O(n)
 */
public class ReconstructBinaryTreeWithPostorderAndInorder {
	public TreeNode reconstruct(int[] in, int[] post) {
		Map<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			inMap.put(in[i], i);
		}
		return reconstruct(post, 0, post.length - 1, inMap, 0);
	}

	private TreeNode reconstruct(int[] post, int postLeft, int postRight, Map<Integer, Integer> inMap, int inLeft) {
		if (postLeft > postRight) {
			return null;
		}
		TreeNode root = new TreeNode(post[postRight]);
		int postRootIndex = inMap.get(root.key);
		int leftLen = postRootIndex - inLeft;
		root.left = reconstruct(post, postLeft, postLeft + leftLen - 1, inMap, inLeft);
		root.right = reconstruct(post, postLeft + leftLen, postRight - 1, inMap, postRootIndex + 1);
		return root;
	}
}
