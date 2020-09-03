package dfs_topDown;

import java.util.ArrayList;
import java.util.List;

import impl.TreeNode;
import impl.Utils;

/**
 * Given a binary tree, return all root-to-leaf paths from left to right.
 * 
 * Examples:
 * 1. Given the following binary tree:
 *    1
 *   / \
 *  2   3
 *   \
 *    5
 * All root-to-leaf paths are: ["1->2->5", "1->3"]
 * 
 * Thoughts: Instead of using string builder to prepare the final path, we use a list to store numbers
 * first, because it is harder to restore a string builder to the initial state, but for list we only
 * need to remove the last element. When we reach the leaf node, just convert the list to string.
 * 
 * Time: O(n^2), it is not O(n) because we need to print the paths. there can be at most n/2 leaf 
 * nodes, and in the worst case the height is n, so printing all paths will be O(n^2). Can a tree 
 * have O(n) leaf nodes while have O(n) height at the same time? How about this tree:
 *         #
 *        / \
 *       #   #
 *      / \
 *     #   #
 *    / \
 *   #   #
 * Space: auxiliary worst O(n), O(logn) if the binary tree is balanced.
 * 
 * Reference: https://stackoverflow.com/questions/57940296/what-is-the-maximum-and-minimum-number-of-leaf-nodes-of-a-binary-tree-with-n-nod
 */
public class BinaryTreePaths {
	public String[] binaryTreePaths(TreeNode root) {
		if (root == null) {
			return new String[0];
		}
		List<String> res = new ArrayList<>();
		addToPath(root, new ArrayList<>(), res);
		return res.toArray(new String[0]); // String is not a primitive class so we can convert the list to array directly
	}
	
	private void addToPath(TreeNode root, List<Integer> cur, List<String> res) {
		cur.add(root.key);
		if (root.left == null && root.right == null) { // leaf node
			res.add(listToStr(cur));
			cur.remove(cur.size() - 1); // easy to miss this statement, we should also restore the initial state here. Or we don't return here so the last element will be removed later
			return;
		}
		if (root.left != null) {
			addToPath(root.left, cur, res);
		}
		if (root.right != null) {
			addToPath(root.right, cur, res);
		}
		cur.remove(cur.size() - 1); // restore the initial state
	}
	
	private String listToStr(List<Integer> cur) { 
		StringBuilder builder = new StringBuilder();
		for (int val : cur) {
			builder.append(val).append("->");
		}
		builder.delete(builder.length() - 2, builder.length()); // the input list cannot be empty so we don't do empty check here
		return builder.toString();
	}
	
	public static void main(String[] args) {
		BinaryTreePaths test = new BinaryTreePaths();
		TreeNode one = new TreeNode(1); TreeNode two = new TreeNode(2); TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(5);
		one.left = two; one.right = three; two.right = four;
		Utils.printArray(test.binaryTreePaths(one));
	}
}
