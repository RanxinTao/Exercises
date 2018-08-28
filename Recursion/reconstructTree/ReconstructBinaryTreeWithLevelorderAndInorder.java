package reconstructTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import impl.TreeNode;

/**
 * Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
 * 
 * Assumptions:
 * 1. The given sequences are not null and they have the same length
 * 2. There are no duplicate keys in the binary tree
 * Examples:
 * levelorder traversal = {5, 3, 8, 1, 4, 11}
 * inorder traversal = {1, 3, 4, 5, 8, 11}
 * the corresponding binary search tree is
 *       5
 *      / \
 *     3   8
 *    / \   \
 *   1   4  11  
 */
public class ReconstructBinaryTreeWithLevelorderAndInorder {
	public TreeNode reconstruct(int[] in, int[] level) {
		Map<Integer, Integer> inIndexes = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			inIndexes.put(in[i], i);
		}
		List<Integer> levelList = new ArrayList<>();
		for (int num : level) {
			levelList.add(num);
		}
		return helper(inIndexes, levelList);
	}

	private TreeNode helper(Map<Integer, Integer> inIndexes, List<Integer> level) {
		if (level.isEmpty()) {
			return null;
		}
		TreeNode root = new TreeNode(level.get(0));
		List<Integer> leftLevel = new ArrayList<>();
		List<Integer> rightLevel = new ArrayList<>();
		for (int i = 1; i < level.size(); i++) {
			int num = level.get(i);
			if (inIndexes.get(num) < inIndexes.get(root.key)) {
				leftLevel.add(num);
			} else {
				rightLevel.add(num);
			}
		}
		root.left = helper(inIndexes, leftLevel);
		root.right = helper(inIndexes, rightLevel);
		return root;
	}
}
