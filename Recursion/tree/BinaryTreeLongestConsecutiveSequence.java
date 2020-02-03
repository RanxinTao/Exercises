package tree;

import impl.TreeNode;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child
 * connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 * 
 * Examples:
 * 1.
 *  1
 *   \
 *    3
 *   / \
 *  2   4
 *       \ 
 *        5
 * Longest consecutive sequence path is 3-4-5, so return 3
 * 2.
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 * Longest consecutive sequence path is 2-3, not 3-2-1, so return 2
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) if the binary tree is balanced.
 */
public class BinaryTreeLongestConsecutiveSequence {
	public int longestConsecutive(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] globalMax = new int[1];
		longestConsecutive(root, 1, globalMax);
		return globalMax[0];
	}
	
	private void longestConsecutive(TreeNode root, int localMax, int[] globalMax) {
		globalMax[0] = Math.max(globalMax[0], localMax);
		if (root.left != null) {
			localMax = root.left.key == root.key + 1 ? localMax + 1 : 1;			 
			longestConsecutive(root.left, localMax, globalMax);
		}
		if (root.right != null) {
			localMax = root.right.key == root.key + 1 ? localMax + 1 : 1;
			longestConsecutive(root.right, localMax, globalMax);
		}
	}
}
