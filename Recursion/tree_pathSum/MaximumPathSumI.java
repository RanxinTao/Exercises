package tree_pathSum;

import impl.TreeNode;

/**
 * Given a binary tree in which each node contains an integer number. Find the maximum possible sum from one leaf node 
 * to another leaf node. If there is no such path available, return Integer.MIN_VALUE.
 * (path from one leaf node to another leaf node)
 * 
 * Examples:
 *      -15
 *      / \
 *     2   11
 *        /  \
 *       6   14
 * the maximum path sum is 6 + 11 + 14 = 31
 */
public class MaximumPathSumI {
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
		if (root.left != null && root.right != null) {
			max[0] = Math.max(max[0], leftSum + root.key + rightSum);
			return Math.max(leftSum, rightSum) + root.key;
		}
		return root.left == null ? rightSum + root.key : leftSum + root.key;
	}
}
