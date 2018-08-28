package impl;

import java.util.Arrays;

public class Utils {
	public static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}
	
	public static void printArray(String[] array) {
		System.out.println(Arrays.toString(array));
	}
	
	public static void print2dArray(int[][] array) {
		for (int[] elem : array) {
			System.out.println(Arrays.toString(elem));
		}
	}
	
	public static TreeNode[] createNodes(int[] keys) {
		TreeNode[] nodes = new TreeNode[keys.length];
		int i = 0;
		for (int key : keys) {
			TreeNode node = new TreeNode(key);
			nodes[i] = node;
			i++;
		}
		return nodes;
	}
}
