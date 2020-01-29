package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import impl.TreeNode;

/**
 * Print all node values in a tree in level order.
 * 
 * Assumption:
 * 1. The tree is not null or empty.
 * 
 * Example:
 *      7              
 *     / \     
 *    5   4 
 *   / \  
 *  3   6
 *     /
 *    1  
 * the result is [7, 5, 4, 3, 6, 1]
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class PrintTreeInLevelOrder {
	public List<Integer> bfs(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
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
}
