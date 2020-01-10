package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string with no duplicate characters, return a list with all permutations of the characters.
 * 
 * Examples:
 * 1. Set = "abc", all permutations are ["abc", "acb", "bac", "bca", "cab", "cba"]
 * 2. Set = "", all permutations are [""]
 * 3. Set = null, all permutations are []
 * 
 * Time: O(n!)
 * Space: O(n)
 */
public class AllPermutationsI {
	public List<String> permutations(String set) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
	    permutations(set.toCharArray(), 0, res);
	    return res;
	}
	
	private void permutations(char[] array, int index, List<String> res) {
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
		String set = "";
		System.out.println(test.permutations(set));
	}
}
