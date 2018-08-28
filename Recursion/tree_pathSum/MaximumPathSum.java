package tree_pathSum;

import impl.TreeNode;
import impl.Utils;

/**
 * Path from one leaf node to root
 */
public class MaximumPathSum {
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftSum = maxPathSum(root.left);
		int rightSum = maxPathSum(root.right);
		if (root.left != null && root.right != null) {
			return Math.max(leftSum, rightSum) + root.key;
		}
		return root.left == null ? rightSum + root.key : leftSum + root.key;
	}
	
	public static void main(String[] args) {
		MaximumPathSum test = new MaximumPathSum();
		//int[] keys = new int[] {10, -2, 7, 8, -4};
		int[] keys = new int[] {1,2,3,4,5,6,7,8,9};
		TreeNode[] nodes = Utils.createNodes(keys);
		nodes[0].left = nodes[1]; nodes[0].right = nodes[2]; nodes[1].left = nodes[3]; nodes[1].right = nodes[4];
		nodes[2].right = nodes[5]; nodes[3].left = nodes[6]; nodes[3].right = nodes[7]; nodes[4].right = nodes[8];
		System.out.println(test.maxPathSum(nodes[0]));
	}
}
