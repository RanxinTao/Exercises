package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import impl.TreeNode;

/**
 * Given a binary tree, return its border view. The border view is defined as follow: first get all the border nodes at
 * left side (from root and always go to the left subtree unless the left subtree does not exist until reach a left
 * node), then get all the leaf nodes (from left to right), at last get all the border nodes at right side (similar to
 * left border but from buttom to top), the list of border view should not contain duplicate nodes.
 * Note that for the given root, if it has no left sub-tree or right sub-tree, it is considered the left border/right
 * border, but this rule applies to only the input tree not any sub-tree of it.
 * 
 * Examples:
 *       1              
 *     /   \     
 *    2     3 
 *   / \   / \
 *  4   5 6   7
 *   \     \
 *    9     8
 *     \
 *     11
 * the border view is [1, 2, 4, 9, 11, 5, 8, 7, 3]
 * 1, 2, 4, 9, 11 are the left border,
 * 11, 5, 8, 7 are the leaf nodes,
 * 7, 3, 1 are the right border.
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class BorderViewOfBinaryTree {
	public List<Integer> borderView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		res.addAll(getLeftBorderNodes(root));
		List<Integer> leafNodes = new ArrayList<>();
		getLeafNodes(root, leafNodes);
		for (int i = 1; i < leafNodes.size() - 1; i++) {
			res.add(leafNodes.get(i));
		}
		res.addAll(getRightBorderNodes(root.right));
		return res;
	}
	
	private List<Integer> getLeftBorderNodes(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		while (root != null) {
			res.add(root.key);
			root = root.left != null ? root.left : root.right;
		}
		return res;
	}
	
	private List<Integer> getRightBorderNodes(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		while (root != null) {
			res.add(root.key);
			root = root.right != null ? root.right : root.left;
		}
		Collections.reverse(res);
		return res;
	}
	
	private void getLeafNodes(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) { // leaf node
			res.add(root.key);
		} else {
			getLeafNodes(root.left, res);
			getLeafNodes(root.right, res);
		}
	}
	
	public static void main(String[] args) {
		BorderViewOfBinaryTree test = new BorderViewOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2); root.right = new TreeNode(3);
		root.left.left = new TreeNode(4); root.left.right = new TreeNode(5); 
		root.right.left = new TreeNode(6); root.right.right = new TreeNode(7);
		root.left.left.right = new TreeNode(9); root.right.left.right = new TreeNode(8);
		root.left.left.right.right = new TreeNode(11);
		System.out.println(test.borderView(root));
	}
}
