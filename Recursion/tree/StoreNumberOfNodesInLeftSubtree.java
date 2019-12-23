package tree;

import impl.TreeNodeLeft;

/**
 * Given a binary tree, count the number of nodes in each node's left subtree, and store it in the numNodesLeft field.
 * 
 * Examples:   
 *          1(6)          
 *         /   \              
 *       2(3)  3(0)          
 *      /  \                    
 *     4(1) 5(0)  
 *    /  \    \  
 *   6(0) 7(0) 8(0)
 * The numNodesLeft is shown in parentheses.
 * 
 * Time: O(n)
 * Space: O(n), O(logn) if the tree is balanced.
 */
public class StoreNumberOfNodesInLeftSubtree {
	public void numNodesLeft(TreeNodeLeft root) {
		numNodes(root);
	}
	
	private int numNodes(TreeNodeLeft root) {
		if (root == null) {
			return 0;
		}
		root.numNodesLeft = numNodes(root.left);
		int numNodesRight = numNodes(root.right);
		return root.numNodesLeft + numNodesRight + 1;
	}
}
