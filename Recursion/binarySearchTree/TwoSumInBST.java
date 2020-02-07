package binarySearchTree;

import java.util.Deque;
import java.util.LinkedList;

import impl.TreeNode;

/**
 * Given a binary search tree and a target number, find out whether there are a pair of TreeNodes that the sum of their
 * values equals to the given target.
 * 
 * Examples:
 * root = [4, 2, 5, 1, 3]
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 * 1. target = 8, output = true
 * 2. target = 1, output = false
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) if the binary tree is balanced
 */
public class TwoSumInBST {
	public boolean existSumBST(TreeNode root, int target) {
		Deque<TreeNode> inorder = new LinkedList<>();
		Deque<TreeNode> revInorder = new LinkedList<>();
		pushBranch(root, inorder, false);
		pushBranch(root, revInorder, true);
		while (inorder.peekFirst() != revInorder.peekFirst()) {
			int sum = inorder.peekFirst().key + revInorder.peekFirst().key;
			if (sum == target) {
				return true;
			} else if (sum < target) {
				TreeNode cur = inorder.pollFirst();
				pushBranch(cur.right, inorder, false);
			} else {
				TreeNode cur = revInorder.pollFirst();
				pushBranch(cur.left, revInorder, true);
			}
		}
		return false;
	}
	
	private void pushBranch(TreeNode root, Deque<TreeNode> stack, boolean rev) {
		while (root != null) {
			stack.offerFirst(root);
			root = rev ? root.right : root.left;
		}
	}
	
	public static void main(String[] args) {
		TreeNode _4 = new TreeNode(4); TreeNode _2 = new TreeNode(2); TreeNode _5 = new TreeNode(5);
		TreeNode _1 = new TreeNode(1); TreeNode _3 = new TreeNode(3);
		_4.left = _2; _4.right = _5; _2.left = _1; _2.right = _3;
		TwoSumInBST test = new TwoSumInBST();
		System.out.println(test.existSumBST(_4, 1));
	}
}
