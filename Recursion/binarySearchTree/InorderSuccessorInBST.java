package binarySearchTree;

import impl.TreeNode;

/**
 * Given a binary search tree and a target number, find the in-order successor of the given number in the tree, and
 * return its value. If there is no such node, the return -1;
 * 
 * Assumptions:
 * 1. There are no duplicate values in the BST.
 * 2. Value of all nodes in the BST are positive integer.
 * 3. The given value must be in the BST. (so the BST cannot be null)
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class InorderSuccessorInBST {
	public int inOrderSuccessor(TreeNode root, int p) {
		TreeNode succ = null;
		while (root != null) {
			if (p < root.key) {
				succ = root;
				root = root.left;
			} else if (p > root.key) {
				root = root.right;
			} else {
				break;
			}
		}
		if (root.right != null) {
			return findMin(root.right);
		} else {
			return succ == null ? -1 : succ.key;
		}
	}
	
	private int findMin(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root.key;
	}
	
	public static void main(String[] args) {
		TreeNode _20 = new TreeNode(20); TreeNode _8 = new TreeNode(8); TreeNode _22 = new TreeNode(22);
		TreeNode _4 = new TreeNode(4); TreeNode _12 = new TreeNode(12); TreeNode _10 = new TreeNode(10);
		TreeNode _14 = new TreeNode(14);
		_20.left = _8; _20.right = _22; _8.left = _4; _8.right = _12; _12.left = _10; _12.right = _14;
		InorderSuccessorInBST test = new InorderSuccessorInBST();
		System.out.println(test.inOrderSuccessor(_20, 8));
	}
}
