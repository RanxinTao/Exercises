package DFS_base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string with possible duplicate characters, return a list with all permutations of the characters.
 * 
 * Examples:
 * 1. Set = ¡°abc¡±, all permutations are [¡°abc¡±, ¡°acb¡±, ¡°bac¡±, ¡°bca¡±, ¡°cab¡±, ¡°cba¡±]
 * 2. Set = "aba", all permutations are ["aab", "aba", "baa"]
 * 3. Set = "", all permutations are [""]
 * 4. Set = null, all permutations are []
 */
public class AllPermutationsII {
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
		Set<Character> used = new HashSet<>();
		for (int i = index; i < array.length; i++) {
			if (used.add(array[i])) {
				swap(array, index, i);
				permutations(array, index + 1, res);
				swap(array, index, i);
			}
		}
	}

	private void swap(char[] array, int i, int j) {
		char tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void main(String[] args) {
		AllPermutationsII test = new AllPermutationsII();
		String set = "abba";
		System.out.println(test.permutations(set));
	}
}
