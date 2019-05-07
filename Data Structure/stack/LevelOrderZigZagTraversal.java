package stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import impl.TreeNode;

/**
 * Get the list of keys in a given binary tree layer by layer in zig-zag order.
 * 
 * Examples:
 *       5
 *      / \
 *     3   8
 *    / \   \
 *   1   4  11
 * the result is [5, 3, 8, 11, 4, 1] 
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class LevelOrderZigZagTraversal {
	public List<Integer> zigZag(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.offer(root);
		int layer = 0; // decide the order of traversal
		while (!stack.isEmpty()) {
			Deque<TreeNode> newStack = new LinkedList<>();
			while (!stack.isEmpty()) {
				TreeNode curNode = stack.pollFirst();
				res.add(curNode.key);
				if (layer % 2 == 0) {
					if (curNode.right != null) {
						newStack.offerFirst(curNode.right);
					}
					if (curNode.left != null) {
						newStack.offerFirst(curNode.left);
					}
				} else {
					if (curNode.left != null) {
						newStack.offerFirst(curNode.left);
					}	
					if (curNode.right != null) {
						newStack.offerFirst(curNode.right);
					}
				}
			}
			stack = newStack;
			layer++;
		}
		return res;
	}
	
	/*public List<Integer> zigZag(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offerFirst(root);
		boolean evenLayer = true;
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				if (evenLayer) {
					TreeNode tmp = deque.pollFirst();
					res.add(tmp.key);
					if (tmp.right != null) {
						deque.offerLast(tmp.right);
					}
					if (tmp.left != null) {
						deque.offerLast(tmp.left);
					}
				} else {
					TreeNode tmp = deque.pollLast();
					res.add(tmp.key);
					if (tmp.left != null) {
						deque.offerFirst(tmp.left);
					}
					if (tmp.right != null) {
						deque.offerFirst(tmp.right);
					}
				}
			}
			evenLayer = !evenLayer;
		}
		return res;
	}*/
	
	public static void main(String[] args) {
		LevelOrderZigZagTraversal test = new LevelOrderZigZagTraversal();
		TreeNode[] nodes = new TreeNode[] {new TreeNode(5), new TreeNode(3), new TreeNode(8), 
				new TreeNode(1), new TreeNode(4), new TreeNode(11)};
		nodes[0].left = nodes[1];
		nodes[0].right = nodes[2];
		nodes[1].left = nodes[3];
		nodes[1].right = nodes[4];
		nodes[2].right = nodes[5];
		System.out.println(test.zigZag(nodes[0]));
	}
}
