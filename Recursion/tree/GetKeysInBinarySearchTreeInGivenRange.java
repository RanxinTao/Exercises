package tree;

import java.util.ArrayList;
import java.util.List;

import impl.TreeNode;

public class GetKeysInBinarySearchTreeInGivenRange {
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
		} else if (max < root.key) {
			inorder(root.left, min, max, res);
		} else if (min > root.key) {
			inorder(root.right, min, max, res);
		} else {
			inorder(root.left, min, max, res);
			res.add(root.key);
			inorder(root.right, min, max, res);
		}
	}
}
