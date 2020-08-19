package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of characters represented by a String, return a list containing all subsets of the characters whose size 
 * is k. Notice that each subset returned will be sorted for deduplication.
 * 
 * Assumptions: 
 * There could be duplicate characters in the original set
 * 
 * Examples:
 * 1. Set = "abc", K = 2, all the subsets are ["ab", "ac", "bc"].
 * 2. Set = "abb", K = 2, all the subsets are ["ab", "bb"].
 * 3. Set = "abab", K = 2, all the subsets are ["aa", "ab", "bb"].
 * 4. Set = "",  K = 0, all the subsets are [""].
 * 5. Set = "", K = 1, all the subsets are [].
 * 6. Set = null, K = 0, all the subsets are [].
 * 
 * Time: O(2^k)
 * Space: O(k)
 */
public class AllSubsetsIIOfSizeK {
	public List<String> subSetsIIOfSizeK(String set, int k) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		char[] charArray = set.toCharArray();
		Arrays.sort(charArray);
		handleCharAtIdx(charArray, k, 0, res, new StringBuilder());
		return res;
	}

	private void handleCharAtIdx(char[] set, int k, int index, List<String> res, StringBuilder cur) {
		if (cur.length() == k) {
			res.add(cur.toString());
			return;
		} 
		if (set.length - index < k - cur.length() ) {
			return;
		}
		cur.append(set[index]);
		handleCharAtIdx(set, k, index + 1, res, cur);
		cur.deleteCharAt(cur.length() - 1);
		// skip all the consecutive and duplicate elements.
		while (index + 1 < set.length && set[index] == set[index + 1]) {
			index++;
		}
		handleCharAtIdx(set, k, index + 1, res, cur);
	}
	
	public static void main(String[] args) {
		AllSubsetsIIOfSizeK test = new AllSubsetsIIOfSizeK();
		String set = "usadedxrb";
		int k = 3;
		System.out.println(test.subSetsIIOfSizeK(set, k));
	}
}
