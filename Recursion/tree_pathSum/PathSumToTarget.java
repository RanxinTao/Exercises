package tree_pathSum;

import java.util.HashSet;
import java.util.Set;

import impl.TreeNode;

/**
 * Given a binary tree in which each node contains an integer number. Determine if there exists a path (the path can only 
 * be from one node to itself or to any of its descendants), the sum of the numbers on the path is the given target number.
 * 
 * Examples:
 *       5
 *      / \
 *     2   11
 *        /  \
 *       6   14
 *           /
 *          3
 * If target = 17, There exists a path 11 + 6, the sum of the path is target.
 * If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.
 * If target = 10, There does not exist any paths sum of which is target.
 * If target = 11, There exists a path only containing the node 11.
 */
public class PathSumToTarget {
	public boolean exist(TreeNode root, int target) {
		Set<Integer> prefixSums = new HashSet<>();
		prefixSums.add(0);
		return helper(root, target, 0, prefixSums);
	}

	private boolean helper(TreeNode root, int target, int pathSum, Set<Integer> prefixSums) {
		if (root == null) {
			return false;
		}
		pathSum += root.key;
		if (prefixSums.contains(pathSum - target)) {
			return true;
		}
		// there may be duplicate prefix values
		boolean needRemove = prefixSums.add(pathSum);
		boolean leftRes = helper(root.left, target, pathSum, prefixSums);
		boolean rightRes = helper(root.right, target, pathSum, prefixSums);
		if (needRemove) {
			prefixSums.remove(pathSum);
		}
		return leftRes || rightRes;
	}
}
