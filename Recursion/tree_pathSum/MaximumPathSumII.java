package tree_pathSum;

import impl.TreeNode;

/**
 * Path from any node to any node:
 * Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node to any 
 * node (the start node and the end node can be the same). 
 * 
 * Assumptions: root is not null.
 * Examples:
 *      -1
 *      / \
 *     2   11
 *        /  \
 *       6  -14
 * one example of paths could be -14 -> 11 -> -1 -> 2, another example could be the node 11 itself
 * The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) is the binary tree is balanced.
 */
public class MaximumPathSumII {
	public int maxPathSum(TreeNode root) {
		int[] maxRes = new int[] { Integer.MIN_VALUE };
		maxPathSumChildNodeToRoot(root, maxRes);
		return maxRes[0];
	}

	private int maxPathSumChildNodeToRoot(TreeNode root, int[] maxRes) {
		if (root == null) {
			return 0;
		}
		int leftSum = maxPathSumChildNodeToRoot(root.left, maxRes);
		int rightSum = maxPathSumChildNodeToRoot(root.right, maxRes);
		leftSum = leftSum > 0 ? leftSum : 0;
		rightSum = rightSum > 0 ? rightSum : 0;
		maxRes[0] = Math.max(maxRes[0], leftSum + root.key + rightSum);
		return Math.max(leftSum, rightSum) + root.key;
	}
}
