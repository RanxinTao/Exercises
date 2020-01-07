package tree;

import impl.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in -place.
 * 
 * Examples:
 * Given
 *      1             
 *     / \            
 *    2   5          
 *   / \   \        
 *  3   4   6      
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) is the binary tree is balanced.
 */
public class FlattenBinaryTreeToLinkedList {
	public TreeNode flatten(TreeNode root) {
		if (root == null) {
			return null;
		}
		flattenImpl(root);
		return root;
	}
	
	private TreeNode flattenImpl(TreeNode root) { // using 3-step method, return the last element of the flattened linked list 
		if (root == null) {
			return null;
		}
		TreeNode leftRes = flattenImpl(root.left);
		TreeNode rightRes = flattenImpl(root.right);
		if (leftRes == null) {
			return rightRes == null ? root : rightRes;
		} else { // root.left != null
			TreeNode right = root.right;
			root.right = root.left;
			root.left = null;
			leftRes.right = right;
			return rightRes == null ? leftRes : rightRes;
		}
	}
	
	/*private TreeNode flattenImpl(TreeNode root) { // return the last element of the flattened linked list
		if (root.left == null && root.right == null) {
			return root;
		}
		if (root.left == null) { // which means root.right != null
			return flattenImpl(root.right);
		}
		if (root.right == null) { // which means root.left != null
			root.right = root.left;
			root.left = null;
			return flattenImpl(root.right);
		}		
		TreeNode right = root.right; // TreeNode right = old right
		root.right = root.left;
		root.left = null;
		flattenImpl(root.right).right = right;
		return flattenImpl(right); 
	}*/
}
