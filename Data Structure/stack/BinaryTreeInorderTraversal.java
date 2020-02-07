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
		Deque<TreeNode> stack = new LinkedList<>();
		pushLeftBranch(root, stack); // push the whole left branch, so next time pop this node, we only handle itself and its right branch
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			res.add(cur.key);
			pushLeftBranch(cur.right, stack);
		}
		return res;
	}
	
	private void pushLeftBranch(TreeNode root, Deque<TreeNode> stack) {
		while (root != null) {
			stack.offerFirst(root);
			root = root.left;
		}
	}
	
	/*public List<Integer> inOrder(TreeNode root) {
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
	}*/
	
	public static void main(String[] args) {
		BinaryTreeInorderTraversal test = new BinaryTreeInorderTraversal();
		TreeNode _5 = new TreeNode(5); TreeNode _3 = new TreeNode(3); TreeNode _8 = new TreeNode(8);
		TreeNode _4 = new TreeNode(4); TreeNode _1 = new TreeNode(1); TreeNode _11 = new TreeNode(11);
		_5.left = _3; _5.right = _8; _3.left = _1; _3.right = _4; _8.right = _11;
		System.out.println(test.inOrder(_5));
	}
}
