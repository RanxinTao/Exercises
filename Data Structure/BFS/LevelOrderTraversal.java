package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import impl.TreeNode;

/**
 * Get the list of list of keys in a given binary tree layer by layer. Each layer is represented by a list of keys and 
 * the keys are traversed from left to right.
 * 
 * Examples:
 *      5              
 *     / \     
 *    3   8 
 *   / \ / \ 
 *  1  4   11
 * the result is [[5], [3, 8], [1, 4, 11]]
 * Time: O(n), Space: O(n)
 */
public class LevelOrderTraversal {
	public List<List<Integer>> layerByLayer(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> curLayer = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode curNode = queue.poll();
				curLayer.add(curNode.key);
				if (curNode.left != null) {
					queue.offer(curNode.left);
				}
				if (curNode.right != null) {
					queue.offer(curNode.right);
				}
			}
			res.add(curLayer);
		}
		return res;
	}
}
