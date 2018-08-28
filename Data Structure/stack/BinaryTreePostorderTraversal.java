package stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import impl.TreeNode;

public class BinaryTreePostorderTraversal {
	public List<Integer> postOrder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);
		TreeNode prev = null;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peekFirst();
			// 1. if we are going down, either left or right direction.
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null) {
					stack.offerFirst(cur.left);	
				} else if (cur.right != null) {
					stack.offerFirst(cur.right);
				}
			// 2. if we are going up from the left side
			} else if (prev == cur.left) {
				if (cur.right != null) {
					stack.offerFirst(cur.right);
				}
			// 3. if we are going up from the right side
			} else {
				stack.pollFirst();
				res.add(cur.key);
			}
			prev = cur;
		}
		return res;
	}
	
	/*public List<Integer> postOrder(TreeNode root) {
	    List<Integer> res = new ArrayList<>();
	    if (root == null) {
	      return res;
	    }
	    Deque<TreeNode> stack = new LinkedList<>();
	    TreeNode cur = root;
	    TreeNode last_visited = null;  //store last visited TreeNode
	    
	    while (cur != null || !stack.isEmpty()) {
	      if (cur != null) {
	        stack.offerFirst(cur);
	        cur = cur.left;
	      } else {
	        TreeNode parent = stack.peekFirst();
	        // if right tree is not null and has not been visited
	        if (parent.right != null && last_visited != parent.right) {
	          cur = parent.right;
	        // if right tree is null or was the last visited TreeNode, visit parent
	        } else {
	          res.add(parent.key); // visit
	          last_visited = parent; // mark last visited
	          stack.pollFirst(); // after visit, now it can be forever removed 
	        }
	      }
	    }
	    return res;
	}*/
	
	public static void main(String[] args) {
		BinaryTreePostorderTraversal test = new BinaryTreePostorderTraversal();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(11);
		System.out.println(test.postOrder(root));
	}
}
