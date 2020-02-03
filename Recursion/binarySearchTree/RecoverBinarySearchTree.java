package binarySearchTree;

import impl.TreeNode;

/**
 * Given a Binary Search Tree with only two nodes swapped. Try to find them and recover the binary search tree.
 * 
 * Examples:
 * input:          output:
 *      4                4
 *     / \              / \
 *    2   6            2   6
 *   / \ / \          / \ / \
 *  1  5 3  7        1  3 5  7
 */
public class RecoverBinarySearchTree {
	public TreeNode recover(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode[] swapped = new TreeNode[2];
		TreeNode[] pre = new TreeNode[] { new TreeNode(Integer.MIN_VALUE) };
		inorder(root, pre, swapped);
		// swap the two nodes back
		int tmp = swapped[0].key;
		swapped[0].key = swapped[1].key;
		swapped[1].key = tmp;
		return root;
	}

	private void inorder(TreeNode root, TreeNode[] pre, TreeNode[] swapped) {
		if (root == null) {
			return;
		}
		inorder(root.left, pre, swapped);
		// the two nodes may be adjacent or not, and if not adjacent, there will be two pairs in the reverse order
		if (root.key < pre[0].key) {
			if (swapped[0] == null) {
				swapped[0] = pre[0];
			}
			swapped[1] = root;
		}
		pre[0] = root;
		inorder(root.right, pre, swapped);
	}
}
