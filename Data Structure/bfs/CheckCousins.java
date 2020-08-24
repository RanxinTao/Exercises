package bfs;
import java.util.LinkedList;
import java.util.Queue;

import impl.TreeNode;

/**
 * Check if two nodes are cousins in a binary tree. Given the binary tree and the two nodes 'a' and 'b', determine whether
 * the two nodes are cousins of each other or not. 
 * Two nodes are cousins of each other if they are at same level and have different parents.
 * 
 * Examples:
 *     6
 *    / \
 *   3   5
 *  / \ / \
 * 7  8 1  2
 * 7 and 1, result is true; 3 and 5, result is false; 7 and 5, result is false.
 */
public class CheckCousins {
	public boolean AreCousins(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null || a == null || b == null) {
			return false;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode tmp1 = null;
		TreeNode tmp2 = null;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (cur.left != null) {
					if (cur.left == a) {
						tmp1 = cur;
					} else if (cur.left == b) {
						tmp2 = cur;
					}
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					if (cur.right == a) {
						tmp1 = cur;
					} else if (cur.right == b) {
						tmp2 = cur;
					}
					queue.offer(cur.right);
				}
			}
			if (tmp1 != null && tmp2 != null && tmp1 != tmp2) {
				return true;
			} else {
				tmp1 = null;
				tmp2 = null;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode one = new TreeNode(6);
		TreeNode two = new TreeNode(3);
		TreeNode three = new TreeNode(5);
		TreeNode four = new TreeNode(7);
		TreeNode five = new TreeNode(8);
		TreeNode six = new TreeNode(1);
		TreeNode seven = new TreeNode(2);
		one.left = two; one.right = three;
		two.left = four; two.right = five;
		three.left = six; three.right = seven;
		CheckCousins test = new CheckCousins();
		System.out.println(test.AreCousins(one, three, four));
		if (one == two && one == two && one == two && 
		one == two && one == two) {}
	}
}
