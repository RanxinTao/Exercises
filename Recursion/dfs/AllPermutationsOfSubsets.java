package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string with no duplicate characters, return a list with all permutations of the string and all its subsets.
 * 
 * Examples:
 * 1. Set = "abc", all permutations are ["", "a", "ab", "abc", "ac", "acb", "b", "ba", "bac", "bc", "bca", 
 * "c", "cb", "cba", "ca", "cab"].
 * 2. Set = "", all permutations are [""]
 * 4. Set = null, all permutations are []
 * 
 * Time: O(n!)
 * Space: O(n)
 */
public class AllPermutationsOfSubsets {
	public List<String> allPermutationsOfSubsets(String set) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		permutations(set.toCharArray(), 0, res);
		return res;
	}
	
	private void permutations(char[] array, int index, List<String> res) {
		if (index > array.length) {
			return;
		}
		res.add(new String(array, 0, index));
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
}
