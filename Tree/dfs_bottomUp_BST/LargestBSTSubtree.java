package dfs_bottomUp_BST;

import impl.TreeNode;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest
 * means subtree with largest number of nodes in it.
 * Note: a subtree must include all of its descendants.
 * Follow up: Can you figure out ways to solve it with O(n) time complexity.
 * 
 * Examples:
 * 1.   10
 *     /  \
 *    5(*) 15
 *   / \    \
 *  1(*)8(*) 7 
 * The Largest BST Subtree in this case is the highlighted one. The return value is the subtree's
 * size, which is 3. 
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class LargestBSTSubtree {
	public int largestBSTSubtree(TreeNode root) {
		int[] largest = {0};
		largestBSTUtil(root, largest);
		return largest[0];
	}
	
	private Result largestBSTUtil(TreeNode root, int[] largest) {
		if (root == null) {
			return new Result(0, 0, 0);
		}
		Result lRes = largestBSTUtil(root.left, largest);
		Result rRes = largestBSTUtil(root.right, largest);
		boolean lCheck = (lRes.size == 0) || (lRes.size > 0 && lRes.max < root.key); // if left subtree is null, it still meets BST constraints
		boolean rCheck = (rRes.size == 0) || (rRes.size > 0 && rRes.min > root.key); // if right subtree is null, it still meets BST constraints
		if (lCheck && rCheck) { // the current node is a BST
			int size = lRes.size + rRes.size + 1;
			int min = lRes.size == 0 ? root.key : lRes.min;
			int max = rRes.size == 0 ? root.key : rRes.max;
			largest[0] = Math.max(largest[0], size);
			return new Result(size, min, max);
		}
		return new Result(-1, 0, 0); // not even a BST
	}
	
	static class Result {
		int size; // -1 means it is not BST
		int min; // min value in the subtree
		int max; // max value in the subtree
		
		public Result(int size, int min, int max) {
			this.size = size;
			this.min = min;
			this.max = max;
		}
	}
	
	public static void main(String[] args) {
		LargestBSTSubtree test = new LargestBSTSubtree();
		TreeNode one = new TreeNode(10); TreeNode two = new TreeNode(5); TreeNode three = new TreeNode(15);
		TreeNode four = new TreeNode(1); TreeNode five = new TreeNode(8); TreeNode six = new TreeNode(7);
		one.left = two; one.right = three; two.left = four; two.right = five; three.right = six;
		System.out.println(test.largestBSTSubtree(one));
	}
}
