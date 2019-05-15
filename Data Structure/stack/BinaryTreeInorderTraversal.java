package stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import impl.TreeNode;

/**
 * Implement an iterative, in-order traversal of a given binary tree, return the list of keys of each node in the tree
 * as it is in-order traversed.
 * 
 * Examples:
 *      5
 *     / \
 *    3   8
 *   / \   \
 *  1  4   11
 * In-order traversal is [1, 3, 4, 5, 8, 11]
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) is the binary tree is balanced.
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inOrder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		// corner case
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);
		TreeNode prev = null;
		while (!stack.isEmpty()) {
			// we do not pop the current node because it will be visited after left subtree
			TreeNode cur = stack.peekFirst();
			// 1. if we are going down, either from prev.left or prev.right
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null) {
					stack.offerFirst(cur.left);	
				} else {
					res.add(cur.key);
					stack.pollFirst();
					if (cur.right != null) {
						stack.offerFirst(cur.right);
					}
				}
			// 2. if we are going up
			} else {
				res.add(cur.key);
				stack.pollFirst();
				if (cur.right != null) {
					stack.offerFirst(cur.right);
				}
			}
			prev = cur;
		}
		return res;
	}
	
	public static void main(String[] args) {
		BinaryTreeInorderTraversal test = new BinaryTreeInorderTraversal();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(8);
		root.right.left.right = new TreeNode(9);
		System.out.println(test.inOrder(root));
	}
}
