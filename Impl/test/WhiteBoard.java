package test;

import java.util.ArrayList;
import java.util.List;

import DFS.AllPermutationsI;
import impl.ListNode;
import impl.TreeNode;

@SuppressWarnings("unused")
public class WhiteBoard {
	public List<String> permutations(String set) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
	    permutations(set.toCharArray(), 0, res);
	    return res;
	}
	
	public void permutations(char[] array, int index, List<String> res) {
		if (index == array.length) {
			res.add(new String(array));
			return;
		}
		for (int i = index; i < array.length; i++) {
			swap(array, index, i);
			permutations(array, index + 1, res);
			swap(array, index, i);
		}
	}
	
	private void swap(char[] array, int i, int j) {
		char tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void main(String[] args) {
		AllPermutationsI test = new AllPermutationsI();
		String set = "abc";
		System.out.println(test.permutations(set));
	}
}
