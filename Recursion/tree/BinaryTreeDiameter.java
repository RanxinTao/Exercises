package tree;

import impl.TreeNode;

public class BinaryTreeDiameter {
	public int diameter(TreeNode root) {
		int[] res = new int[] {0};
		helper(root, res);
		return res[0];
	}

	private int helper(TreeNode root, int[] res) {
		if (root == null) {
			return 0;
		}
		int leftRes = helper(root.left, res);
		int rightRes = helper(root.right, res);
		if (root.left != null && root.right != null) {
			res[0] = Math.max(res[0], 1 + leftRes + rightRes);
			return 1 + (leftRes > rightRes ? leftRes : rightRes);
		}
		return 1 + (root.left == null ? rightRes : leftRes);
	}
	
	public static void main(String[] args) {
		BinaryTreeDiameter test = new BinaryTreeDiameter();
		TreeNode root = new TreeNode(5);
		/*TreeNode one = new TreeNode(2);
		TreeNode two = new TreeNode(11);
		TreeNode three = new TreeNode(6);
		TreeNode four = new TreeNode(14);
		root.left = one; root.right = two; two.left = three; two.right = four;*/
		System.out.println(test.diameter(root));
	}
}
