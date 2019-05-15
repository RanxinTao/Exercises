package stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import impl.TreeNode;

/**
 * Implement an iterative, post-order traversal of a given binary tree, return the list of keys of each node in the tree
 * as it is post-order traversed.
 * 
 * Examples:
 *      5
 *     / \
 *    3   8
 *   / \   \
 *  1  4   11
 * Post-order traversal is [1, 4, 3, 11, 8, 5]
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) is the binary tree is balanced.
 */
public class BinaryTreePostorderTraversal {
	public List<Integer> postOrder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		// corner case
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);
		TreeNode prev = null;
		while (!stack.isEmpty()) {
			// we do not pop the current node because it will be visited after left and right subtrees
			TreeNode cur = stack.peekFirst();
			// 1. if we are going down, either from prev.left or prev.right
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null) {
					stack.offerFirst(cur.left);	
				} else if (cur.right != null) {
					stack.offerFirst(cur.right);
				// if cur is a leaf node
				} else {
					res.add(cur.key);
					stack.pollFirst();
				}
			// 2. if we are going up from the left side
			} else if (prev == cur.left) {
				if (cur.right != null) {
					stack.offerFirst(cur.right);
				} else {
					res.add(cur.key);
					stack.pollFirst();			
				}
			// 3. if we are going up from the right side
			} else {
				res.add(cur.key);
				stack.pollFirst();	
			}
			prev = cur;
		}
		return res;
	}
	
	public static void main(String[] args) {
		BinaryTreePostorderTraversal test = new BinaryTreePostorderTraversal();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(11);
		System.out.println(test.postOrder(root));
	}
}
