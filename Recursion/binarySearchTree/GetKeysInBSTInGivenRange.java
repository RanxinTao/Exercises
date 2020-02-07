package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

import impl.TreeNode;

/**
 * Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, both min and max
 * are inclusive.
 * 
 * Examples:
 *      5             
 *     / \            
 *    3   8          
 *   / \ / \        
 *  1  4   11      
 * get the keys in [2, 5] in ascending order, result is [3, 4, 5]
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) is the binary tree is balanced.
 */
public class GetKeysInBSTInGivenRange {
	public List<Integer> getRange(TreeNode root, int min, int max) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		List<Integer> res = new ArrayList<>();
		inorder(root, min, max, res);
		return res;
	}

	private void inorder(TreeNode root, int min, int max, List<Integer> res) {
		if (root == null) {
			return;
		}
		if (min < root.key) {
			inorder(root.left, min, max, res);
		}
		if (min <= root.key && root.key <= max) {
			res.add(root.key);
		}
		if (root.key < max) {
			inorder(root.right, min, max, res);
		}
	}
}
