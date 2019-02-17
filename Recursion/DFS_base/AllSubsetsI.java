package DFS_base;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of characters represented by a String, return a list containing all subsets of the characters.
 * 
 * Assumptions: 
 * There are no duplicate characters in the original set.
 * Examples:
 * 1. Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
 * 2. Set = "", all the subsets are [""]
 * 3. Set = null, all the subsets are []
 * 
 * Time: O(2^n)
 */
public class AllSubsetsI {
	public List<String> subSets(String set) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		subSets(set, 0, res, new StringBuilder());
		return res;
	}

	private void subSets(String set, int index, List<String> res, StringBuilder cur) {
		if (index == set.length()) {
			res.add(cur.toString());
			return;
		} else {
			cur.append(set.charAt(index));
			subSets(set, index + 1, res, cur);
			cur.deleteCharAt(cur.length() - 1);
			subSets(set, index + 1, res, cur);
		}
	}
}
