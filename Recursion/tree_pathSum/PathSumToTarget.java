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
 *      /    
 *     3     
 * 1. If target = 17, There exists a path 11 + 6, the sum of the path is target.
 * 2. If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.
 * 3. If target = 10, There does not exist any paths sum of which is target.
 * 4. If target = 11, There exists a path only containing the node 11.
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) is the binary tree is balanced.
 */
public class PathSumToTarget {
	public boolean exist(TreeNode root, int target) {
		Set<Integer> prefixSums = new HashSet<>();
		prefixSums.add(0);
		return existPathSumToTarget(root, target, 0, prefixSums);
	}

	private boolean existPathSumToTarget(TreeNode root, int target, int curPathSum, Set<Integer> prefixSums) {
		if (root == null) {
			return false;
		}
		curPathSum += root.key;
		if (prefixSums.contains(curPathSum - target)) {
			return true;
		}
		boolean needRemove = prefixSums.add(curPathSum); // there may be duplicate prefix values, add() will return false if already contains the element
		boolean leftRes = existPathSumToTarget(root.left, target, curPathSum, prefixSums);
		boolean rightRes = existPathSumToTarget(root.right, target, curPathSum, prefixSums);
		if (needRemove) {
			prefixSums.remove(curPathSum);
		}
		return leftRes || rightRes;
	}
}
