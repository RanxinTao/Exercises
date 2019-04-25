package tree_pathSum;

import impl.TreeNode;

/**
 * Path from any node to any node and they can only be on the path from root to one of the leaf nodes:
 * Given a binary tree in which each node contains an integer number. Find the maximum possible subpath sum (both the 
 * starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, and the 
 * subpath is allowed to contain only one node).
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
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) is the binary tree is balanced.
 */
public class MaximumPathSumIII {
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
		int curRes = Math.max(leftSum, rightSum) + root.key;
		maxRes[0] = Math.max(maxRes[0], curRes);
		return curRes;
	}
}
