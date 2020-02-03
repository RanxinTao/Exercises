package binarySearchTree;

import java.util.LinkedList;
import java.util.List;

import impl.TreeNode;

/**
 * In a binary search tree, find k nodes containing the closest numbers to the given target number.
 * Return them in sorted array.
 * 
 * Assumptions:
 * 1. The given root is not null.
 * 2. There are no duplicate keys in the binary search tree.
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) if the binary tree is balanced.
 */
public class ClosestNumberInBinarySearchTreeII { // not the best solution, best time complexity can be reduced to O(logn) when the tree is balanced.
	public int[] closestKValues(TreeNode root, double target, int k) {
		List<Integer> res = new LinkedList<>();
		inOrder(root, target, k, res);
		return convertToIntArray(res);
	}
	
	private void inOrder(TreeNode root, double target, int k, List<Integer> res) {
		if (root != null) {
			inOrder(root.left, target, k, res);
			if (res.size() < k) {
				res.add(root.key);
			} else if (Math.abs(root.key - target) < Math.abs(res.get(0) - target)) {
				res.remove(0);
				res.add(root.key);
			} else {
				return;
			}
			inOrder(root.right, target, k, res);
		}
	}
	
	private int[] convertToIntArray(List<Integer> list) {
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
