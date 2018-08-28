package impl;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int key) {
		this.key = key;
	}
	
	/*public TreeNode(String str) {
		TreeNode root = new TreeNode(str.charAt(0));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int index = 2;
		while (index < str.length()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				char ch = str.charAt(index);
				if (ch != '#') {
					cur.left = new TreeNode(ch - '0');
					index += 2;
				}
				if (index < str.length()) {
					TreeNode right = new TreeNode(str.charAt(index));
					index += 2;
				}
			}
		}
	}*/
	
	@Override
	public String toString() {
		return key + " ";
	}
	
	/*@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(this);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (cur == null) {
					sb.append('#');
					sb.append(' ');
				} else {
					sb.append(cur.key);
					sb.append(' ');
					queue.offer(cur.left);
					queue.offer(cur.right);
				}
			}
		}
		while (sb.charAt(sb.length() - 1) == ' ' && sb.charAt(sb.length() - 2) == '#') {
			sb.deleteCharAt(sb.length() - 1);
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}*/
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		System.out.println(root.toString());
	}
}
