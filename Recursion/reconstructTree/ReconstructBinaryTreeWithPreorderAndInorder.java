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
 *   
 * Time: O(n)
 * Space: O(n)
 */
public class ReconstructBinaryTreeWithPreorderAndInorder {
	public TreeNode reconstruct(int[] in, int[] pre) {
		Map<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			inMap.put(in[i], i);
		}
		return reconstruct(pre, 0, pre.length - 1, inMap, 0);
	}

	private TreeNode reconstruct(int[] pre, int preLeft, int preRight, Map<Integer, Integer> inMap, int inLeft) {
		if (preLeft > preRight) {
			return null;
		}
		TreeNode root = new TreeNode(pre[preLeft]);
		int inRootIndex = inMap.get(root.key);
		int leftLen = inRootIndex - inLeft;
		root.left = reconstruct(pre, preLeft + 1, preLeft + leftLen, inMap, inLeft);
		root.right = reconstruct(pre, preLeft + leftLen + 1, preRight, inMap, inRootIndex + 1);
		return root;
	}
}	
