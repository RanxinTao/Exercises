package tree;

import impl.TreeNode;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * 
 * Examples:
 * 1. Given binary tree,
 *      5             
 *     / \            
 *    1   5          
 *   / \   \        
 *  5   5   5      
 * return 4.
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) is the binary tree is balanced.
 */
public class CountUnivalueSubtrees {
	public int countUnivalSubtrees(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] res = new int[1];
		count(root, res);
		return res[0];
	}
	
	private Integer count(TreeNode root, int[] res) { // return the uni-value of the subtree
		if (root.left == null && root.right == null) {
			res[0]++;
			return root.key;
		} else if (root.left == null || root.right == null) { // merge the case where root.left == null and the case where root.right == null
			TreeNode sub = root.left != null ? root.left : root.right;
			Integer val = count(sub, res);
			if (val != null && val.intValue() == root.key) {
				res[0]++;
				return root.key;
			}
			return null;
		} else { // root.left != null && root.right != null
			Integer lVal = count(root.left, res);
			Integer rVal = count(root.right, res);
			if (lVal != null && rVal != null && lVal.equals(rVal) && lVal.intValue() == root.key) {
				res[0]++;
				return root.key;
			}
			return null;
		}
	}
	
	public static void main(String[] args) {
		CountUnivalueSubtrees test = new CountUnivalueSubtrees();
		/*TreeNode one = new TreeNode(5); TreeNode two = new TreeNode(1); TreeNode three = new TreeNode(5);
		TreeNode four = new TreeNode(5); TreeNode five = new TreeNode(5); TreeNode six = new TreeNode(5);
		one.left = two; one.right = three; two.left = four; two.right = five; three.right = six;*/
		TreeNode one = new TreeNode(2); TreeNode two = new TreeNode(2); TreeNode three = new TreeNode(2);
		TreeNode four = new TreeNode(2); TreeNode five = new TreeNode(2); TreeNode six = new TreeNode(2);
		one.left = two; one.right = three; two.left = four; two.right = five; three.left = six;
		System.out.println(test.countUnivalSubtrees(one));
	}
}
