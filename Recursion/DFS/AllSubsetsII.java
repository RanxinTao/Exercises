package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of characters represented by a String, return a list containing all subsets of the characters.
 * 
 * Assumptions: 
 * There could be duplicate characters in the original set
 * Examples:
 * 1. Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
 * 2. Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
 * 3. Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
 * 3. Set = "", all the subsets are [""]
 * 4. Set = null, all the subsets are []
 * 
 * Time: O(2^n)
 * Space: O(n)
 */
public class AllSubsetsII {
	public List<String> subSets(String set) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		char[] charArray = set.toCharArray();
		Arrays.sort(charArray);
		handleCharAtIdx(charArray, 0, res, new StringBuilder());
		return res;
	}

	private void handleCharAtIdx(char[] set, int index, List<String> res, StringBuilder cur) {
		if (index == set.length) {
			res.add(cur.toString());
			return;
		} else {
			cur.append(set[index]);
			handleCharAtIdx(set, index + 1, res, cur);
			cur.deleteCharAt(cur.length() - 1);
			// skip all the consecutive and duplicate elements.
			while (index + 1 < set.length && set[index] == set[index + 1]) {
				index++;
			}
			handleCharAtIdx(set, index + 1, res, cur);	
		}
	}
	
	public static void main(String[] args) {
		AllSubsetsII test = new AllSubsetsII();
		System.out.println(test.subSets("abcb"));
	}
}
