package tree_pathSum;

import impl.TreeNode;

/**
 * Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node to any 
 * node (the start node and the end node can be the same). 
 * (path from any node to any node)
 * 
 * Assumptions:
 * root is not null.
 * Examples:
 *      -1
 *      / \
 *     2   11
 *        /  \
 *       6  -14
 * one example of paths could be -14 -> 11 -> -1 -> 2, another example could be the node 11 itself
 * The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18
 */
public class MaximumPathSumII {
	public int maxPathSum(TreeNode root) {
		int[] max = new int[] { Integer.MIN_VALUE };
		helper(root, max);
		return max[0];
	}

	private int helper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int leftSum = helper(root.left, max);
		int rightSum = helper(root.right, max);
		leftSum = leftSum > 0 ? leftSum : 0;
		rightSum = rightSum > 0 ? rightSum : 0;
		max[0] = Math.max(max[0], leftSum + root.key + rightSum);
		return Math.max(leftSum, rightSum) + root.key;
	}
}
