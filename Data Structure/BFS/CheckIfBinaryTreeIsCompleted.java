package BFS;

import java.util.LinkedList;
import java.util.Queue;

import impl.TreeNode;

public class CheckIfBinaryTreeIsCompleted {
	public boolean isCompleted(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		boolean missing = false;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			// check left child
			if (cur.left == null) {
				missing = true;
			} else if (missing) {
				return false;
			} else {
				queue.offer(cur.left);
			}
			// check right child
			if (cur.right == null) {
				missing = true;
			} else if (missing) {
				return false;
			} else {
				queue.offer(cur.right);
			}
		}
		return true;
	}
}
