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
