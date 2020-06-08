package check1_other;

import java.util.HashMap;
import java.util.Map;

import impl.TreeNode;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the
 * "root". Besides the root, each house has one and only one parent house. After a tour the smart thief realized that
 * "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses
 * were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * 
 * Examples:
 * 1.
 *     3*
 *    / \
 *   2   3 
 *    \   \
 *     3*  1*
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * 2.
 *     3
 *    / \
 *   4*  5* 
 *  / \   \
 * 1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 * 
 * Thoughts: There are two scenarios, depends on if root is robbed or not. If root is robbed, the next level of subtrees that
 * are available would be the four "grandchild-subtrees". However, if root is not robbed, the next level of available subtrees
 * would just be the two "child-subtrees".
 * Reference: https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class HouseRobberIII {
	public int rob(TreeNode root) {
		return robSub(root, new HashMap<>());
	}
	
	private int robSub(TreeNode root, Map<TreeNode, Integer> cache) {
		if (root == null) {
			return 0;
		}
		if (cache.containsKey(root)) {
			return cache.get(root);
		}
		int robRootMax = root.key; // max money can get if rob the current house
		if (root.left != null) {
			robRootMax += rob(root.left.left) + rob(root.left.right);
		}
		if (root.right != null) {
			robRootMax += rob(root.right.left) + rob(root.right.right);
		}
		int notRobRootMax = rob(root.left) + rob(root.right); // max money can get if not rob the current house
		int max = Math.max(robRootMax, notRobRootMax);
		cache.put(root, max);
		return max;
	}
	
	/*public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int robRootMax = root.key; // max money can get if rob the current house
		if (root.left != null) {
			robRootMax += rob(root.left.left) + rob(root.left.right);
		}
		if (root.right != null) {
			robRootMax += rob(root.right.left) + rob(root.right.right);
		}
		int notRobRootMax = rob(root.left) + rob(root.right); // max money can get if not rob the current house
		return Math.max(robRootMax, notRobRootMax); 
	}*/
	
	public static void main(String[] args) {
		HouseRobberIII test = new HouseRobberIII();
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(5);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(3);
		TreeNode t6 = new TreeNode(1);
		t1.left = t2; t1.right = t3; t2.left = t4; t2.right = t5; t3.right = t6;
		System.out.println(test.rob(t1));
	}
}
