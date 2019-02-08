package stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import impl.TreeNode;

/**
 * Implement an iterative, pre-order traversal of a given binary tree, return the list of keys of each node in the tree
 * as it is pre-order traversed.
 * 
 * Examples:
 *      5
 *     / \
 *    3   8
 *   / \   \
 *  1  4   11
 * Pre-order traversal is [5, 3, 1, 4, 8, 11]
 * 
 * Time: O(n), Space: worst O(n), O(logn) is the binary tree is balanced.
 */
public class BinaryTreePreorderTraversal {
	public List<Integer> preOrder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			res.add(cur.key);
			if (cur.right != null) {
				stack.offerFirst(cur.right);
			}
			if (cur.left != null) {
				stack.offerFirst(cur.left);
			}
		}
		return res;
	}
}
