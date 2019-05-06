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
 *   
 * Time: O(n^2)
 * Space: worst O(n), O(logn) if the binary tree is balanced.
 */
public class ReconstructBinaryTreeWithLevelorderAndInorder {
	public TreeNode reconstruct(int[] in, int[] level) {
		Map<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			inMap.put(in[i], i);
		}
		List<Integer> levelList = new ArrayList<>();
		for (int num : level) { // There is no shortcut for converting from int[] to List<Integer> as Arrays.asList does not deal with boxing and will just create a List<int[]>
			levelList.add(num);
		}
		return reconstruct(inMap, levelList);
	}

	private TreeNode reconstruct(Map<Integer, Integer> inMap, List<Integer> level) {
		if (level.isEmpty()) {
			return null;
		}
		TreeNode root = new TreeNode(level.get(0));
		List<Integer> leftLevel = new ArrayList<>();
		List<Integer> rightLevel = new ArrayList<>();
		for (int i = 1; i < level.size(); i++) {
			int num = level.get(i);
			if (inMap.get(num) < inMap.get(root.key)) {
				leftLevel.add(num);
			} else {
				rightLevel.add(num);
			}
		}
		root.left = reconstruct(inMap, leftLevel);
		root.right = reconstruct(inMap, rightLevel);
		return root;
	}
}
