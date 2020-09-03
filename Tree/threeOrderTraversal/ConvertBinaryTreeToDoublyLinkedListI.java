package threeOrderTraversal;

import impl.TreeNode;

/**
 * Given a binary tree, convert it to a doubly linked list in place (use the left pointer as previous,
 * use the right point as next).
 * The value in the nodes of the doubly linked list should follow the in-order traversal sequence of
 * the binary tree.
 * 
 * Examples:
 * 1.
 *      10
 *     /  \
 *    5   15
 *   /
 *  2 
 * Output: 2 <-> 5 <-> 10 <-> 15
 */
public class ConvertBinaryTreeToDoublyLinkedListI {
	public TreeNode toDoubleLinkedList(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode dummy = new TreeNode(0);
		linkPrevCurNd(root, new TreeNode[] {dummy});
		dummy.right.left = null; // de-link dummy node
		return dummy.right;
	}
	
	private void linkPrevCurNd(TreeNode root, TreeNode[] prev) {
		if (root == null) {
			return;
		}
		linkPrevCurNd(root.left, prev);
		prev[0].right = root;
		root.left = prev[0];
		prev[0] = root;
		linkPrevCurNd(root.right, prev);
	}
}
