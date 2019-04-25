package tree_pathSum;

import impl.TreeNode;

/**
 * Path from one leaf node to another leaf node:
 * Given a binary tree in which each node contains an integer number. Find the maximum possible sum from one leaf node 
 * to another leaf node. If there is no such path available, return Integer.MIN_VALUE.
 * 
 * Examples:
 *      -15
 *      / \
 *     2   11
 *        /  \
 *       6   14
 * the maximum path sum is 6 + 11 + 14 = 31
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) is the binary tree is balanced.
 */
public class MaximumPathSumI {
	public int maxPathSum(TreeNode root) {
		int[] maxRes = new int[] { Integer.MIN_VALUE };
		maxPathSumLeafToRoot(root, maxRes);
		return maxRes[0];
	}

	private int maxPathSumLeafToRoot(TreeNode root, int[] maxRes) {
		if (root == null) {
			return 0;
		}
		int leftSum = maxPathSumLeafToRoot(root.left, maxRes);
		int rightSum = maxPathSumLeafToRoot(root.right, maxRes);
		if (root.left != null && root.right != null) {
			maxRes[0] = Math.max(maxRes[0], leftSum + root.key + rightSum);
			return Math.max(leftSum, rightSum) + root.key;
		}
		return root.left == null ? rightSum + root.key : leftSum + root.key;
	}
}
