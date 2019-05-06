package reconstructTree;

import java.util.ArrayList;
import java.util.List;

import impl.TreeNode;

/**
 * Given the levelorder traversal sequence of a binary search tree, reconstruct the original tree.
 * 
 * Assumptions:
 * 1. The given sequence is not null
 * 2. There are no duplicate keys in the binary search tree
 * Examples:
 * levelorder traversal = {5, 3, 8, 1, 4, 11}
 * the corresponding binary search tree is
 *       5
 *      / \
 *     3   8
 *    / \   \
 *   1   4  11  
 */
public class ReconstructBSTWithLevelOrderTraversal {
	public TreeNode reconstruct(int[] level) {
		List<Integer> levelList = new ArrayList<>();
		for (int num : level) {
			levelList.add(num);
		}
		return reconstruct(levelList);
	}

	private TreeNode reconstruct(List<Integer> level) {
		if (level.isEmpty()) {
			return null;
		}
		TreeNode root = new TreeNode(level.get(0));
		List<Integer> leftLevel = new ArrayList<>();
		List<Integer> rightLevel = new ArrayList<>();
		for (int i = 1; i < level.size(); i++) {
			int num = level.get(i);
			if (num < root.key) {
				leftLevel.add(num);
			} else {
				rightLevel.add(num);
			}
		}
		root.left = reconstruct(leftLevel);
		root.right = reconstruct(rightLevel);
		return root;
	}
}
