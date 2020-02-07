package binarySearchTree;

import java.util.Deque;
import java.util.LinkedList;

import impl.TreeNode;

/**
 * Implement an iterator over a binary search tree. Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * 
 * Assumptions:
 * 1. next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * 2. You may assume that next() call will always be valid, that is, there will be at least a next smallest number in
 * the BST when next() is called.
 * 
 * Examples:
 *    7
 *   / \
 *  3  15
 *    /  \
 *   9   20
 * BSTIterator iterator = new BSTIterator(root);
 * Calling iterator.next() 5 times returns 3 -> 7 -> 9 -> 15 -> 20
 *   
 * Time: O(n)
 * Space: worst O(n), O(logn) if the binary tree is balanced.
 */
public class BSTIterator {
	Deque<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
		stack = new LinkedList<>();
		pushLeftBranch(root, stack);
    }
    
    public int next() {
        TreeNode cur = stack.pollFirst();
        pushLeftBranch(cur.right, stack);
        return cur.key;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void pushLeftBranch(TreeNode root, Deque<TreeNode> stack) {
		while (root != null) {
			stack.offerFirst(root);
			root = root.left;
		}
	}
    
    public static void main(String[] args) {
		TreeNode _7 = new TreeNode(7); TreeNode _3 = new TreeNode(3); TreeNode _15 = new TreeNode(15); 
		TreeNode _9 = new TreeNode(9); TreeNode _20 = new TreeNode(20);
		_7.left = _3; _7.right = _15; _15.left = _9; _15.right = _20;
		BSTIterator test = new BSTIterator(_7);
		System.out.println(test.next());
		System.out.println(test.next());
		System.out.println(test.hasNext());
		System.out.println(test.next());
		System.out.println(test.hasNext());
		System.out.println(test.next());
		System.out.println(test.hasNext());
		System.out.println(test.next());
		System.out.println(test.hasNext());
	}
}
