package tree_pathSum;

import impl.TreeNode;

/**
 * Given a binary tree in which each node contains an integer number. Find the maximum possible subpath sum (both the 
 * starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, and the subpath 
 * is allowed to contain only one node).
 * (path from any node to any node and they can only be on the path from root to one of the leaf nodes)
 * 
 * Assumptions:
 * root is not null.
 * Examples:
 *      -5
 *      / \
 *     2   11
 *        /  \
 *       6   14
 *           /
 *          -3
 * The maximum path sum is 11 + 14 = 25
 */
public class MaximumPathSumIII {
	public int maxPathSum(TreeNode root) {
		int[] max = new int[] { Integer.MIN_VALUE };
		helper(root, max);
		return max[0];
	}

	private int helper(TreeNode root, int[] res) {
		if (root == null) {
			return 0;
		}
		int leftSum = helper(root.left, res);
		int rightSum = helper(root.right, res);
		leftSum = leftSum > 0 ? leftSum : 0;
		rightSum = rightSum > 0 ? rightSum : 0;
		int curRes = Math.max(leftSum, rightSum) + root.key;
		res[0] = Math.max(res[0], curRes);
		return curRes;
	}
}
