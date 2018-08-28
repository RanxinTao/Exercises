package reconstructTree;

import java.util.HashMap;
import java.util.Map;

import impl.TreeNode;

/**
 * Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
 * 
 * Assumptions:
 * 1. The given sequences are not null and they have the same length
 * 2. There are no duplicate keys in the binary tree
 * Examples:
 * preorder traversal = {5, 3, 1, 4, 8, 11}
 * inorder traversal = {1, 3, 4, 5, 8, 11}
 * the corresponding binary search tree is
 *       5
 *      / \
 *     3   8
 *    / \   \
 *   1   4  11  
 */
public class ReconstructBinaryTreeWithPreorderAndInorder {
	public TreeNode reconstruct(int[] in, int[] pre) {
		Map<Integer, Integer> inIndexes = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			inIndexes.put(in[i], i);
		}
		return helper(pre, 0, pre.length - 1, inIndexes, 0, in.length - 1);
	}

	private TreeNode helper(int[] pre, int preLeft, int preRight, Map<Integer, Integer> inIndexes, int inLeft, int inRight) {
		if (inLeft > inRight) {
			return null;
		}
		TreeNode root = new TreeNode(pre[preLeft]);
		preLeft++;
		int inIndex = inIndexes.get(root.key);
		int leftLen = inIndex - inLeft;
		root.left = helper(pre, preLeft, preLeft + leftLen - 1, inIndexes, inLeft, inIndex - 1);
		root.right = helper(pre, preLeft + leftLen, preRight, inIndexes, inIndex + 1, inRight);
		return root;
	}
}	
