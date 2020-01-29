package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import impl.TreeNode;

/**
 * Given a binary tree, get the top view of it. Top view of a binary tree is the set of nodes visible when the tree is
 * viewed from the top. A node x belongs to the output if x is the topmost node at its column. The nodes in the output
 * list should be from left to right. 
 * 
 * Examples:
 * 1.
 *      1              
 *     / \     
 *    2   3 
 *   / \ / \
 *  4 (5,6) 7
 * the top view is [4, 2, 1, 3, 7]
 * 
 * 2.
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 *       \
 *        5 
 *         \
 *          6
 * the top view is [2, 1, 3, 6]
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class TopViewOfBinaryTree {
	public List<Integer> topView(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		Integer[] res = new Integer[getRange(root)]; 
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int pos = 0;
		while (!queue.isEmpty()) {
			TreeNode curNode = queue.poll();
			res.add(curNode.key);
			if (curNode.left != null) {
				queue.offer(curNode.left);
			}
			if (curNode.right != null) {
				queue.offer(curNode.right);
			}
		}
		return res;
	}
	
	private int getRange(TreeNode root) {
		int left = 0;
		while (root.left != null) {
			left++;
			root = root.left;
		}
		int right = 0;
		while (root.right != null) {
			right++;
			root = root.right;
		}
		return left + right + 1;
	}
}
